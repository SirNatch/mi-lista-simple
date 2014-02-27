package practlista;

public class PractLista<T>{
    private Nodo<T> top = null;
    
    PractLista(){
        top= null;
    }
    
    public void insertar_inicio(T x){
        Nodo<T> nuevo = new Nodo(x);
        nuevo.setLiga(getTop());
        setTop(nuevo);
    }
    
    public void insertarAntesX(T dato, T referencia){
        Nodo<T> p = getTop();
        boolean bandera = true;
        
        if(p == null)
            System.out.print("No ahi elementos en la lsta");
        else{
            
            while(p.getLiga()!=null && bandera){
                
            if(p.getDato()==referencia){
                insertar_inicio(referencia);
            }else
                if(p.getLiga().getDato()==referencia){
                    Nodo<T> nuevo = new Nodo<>(dato);
                    nuevo.setLiga(p.getLiga());
                    p.setLiga(nuevo);
                    bandera = false;
                }else
                    p=p.getLiga();
                }
            if(bandera)
                System.out.println("No se encontro el elemento que se dio de referencia");
        }
    }
     
    public void insertar_final(T x){
        Nodo<T> aux = getTop(); 
        if(aux == null)
            insertar_inicio(x);
        else{
            while(aux.getLiga()!=null)
                aux = aux.getLiga();
            aux.setLiga(new Nodo(x));
        }
    }
    
    public void eliminar_inicio(Nodo<T> p){
         Nodo<T> q =p ;
         p = q.getLiga();
         q = null;
     }
     
     public void elimina_ultimo(Nodo p){
         Nodo<T> q = p;
         Nodo<T> t = new Nodo<>();
         
         if(p.getLiga()==null)
             p=null;
         else{
             while(q.getLiga()!=null){
                 t=q;
                 q=q.getLiga();
             }
            t.setLiga(null);
         }
         q=null;
     }
    
    public void eliminar(T x){
        Nodo<T> aux = top;
        Nodo<T> q = new Nodo<>();
        boolean bandera = true;
        
        while(bandera && aux != null){
            if(aux.getDato() == x){
                if(top == aux){
                    top = aux.getLiga();
                    aux = null;
                }else{
                q.setLiga(aux.getLiga());
                aux = null;
                }
                bandera = false;
            }else{
                q = aux;
                aux = aux.getLiga();
            }
        }
        
       // if(bandera)
         //   System.out.println("No se encontro el elemento");
    }
    
    public void mostrar(){
        Nodo<T> aux = getTop();
        while(aux!=null){
            System.out.print(aux.getDato()+" | ");
            aux = aux.getLiga();
        }
        System.out.println();
    }
    
    public PractLista<T> inversaLista(){
        PractLista<T> regreso = new PractLista<>();
        Nodo<T> aux = getTop();
        while(aux!=null){
            regreso.insertar_inicio(aux.getDato());
            aux = aux.getLiga();
        }
        return regreso;
    }
       
    public int n_espacios(int x){
        if( x % 2 == 0){
            x = x/2;
        }else
            x = x/2 + 1;
        return x;
    }
    
    public int contarElementos(){
        if(getTop() == null)
            return 0;
        else{
            int x = 0;
            Nodo <T> aux = getTop();
                while(aux !=null){
                    x++;
                    aux = aux.getLiga();
                }
            return x;
        }
    }
    
    public PractLista dividir(int mitad){  //1 izq, 2 der
        int i = contarElementos();
        if(i !=0){
            Nodo<T> aux = getTop();
            i = n_espacios(i);
            
            if(mitad == 1){
             
                PractLista<T> izq = new PractLista<>();
                while(i != 0){
                    izq.insertar_final(aux.getDato());
                    aux = aux.getLiga();
                    i--;
                }
                
                return izq;       
                
            }else if(mitad == 2){
                
                PractLista<T> der = new PractLista<>();
                
                while(i != 0){
                    aux = aux.getLiga();
                    i--;
                }
                
                while(aux != null){
                    der.insertar_final(aux.getDato());
                    aux = aux.getLiga();
                }
                return der;
                
                
            }else
                System.out.println("No se especifico bien la referencia de la funcion");
            
        }else
            System.out.println("Lista vacia");
        return null;
        
    }
    
    public void quitarDuplicados(){
        Nodo<T> p = top;
        Nodo<T> adelante = p.getLiga();
        
        while(p != null){
            T dato = p.getDato();
            Nodo<T>  seguidor = p;
            
            while(adelante != null){
                if(dato == adelante.getDato()){
                    Nodo<T> aux = adelante;
                    seguidor.setLiga(adelante.getLiga());
                    adelante=adelante.getLiga();
                    aux = null;
                    
                }else{
                    seguidor = seguidor.getLiga();
                    adelante = adelante.getLiga();
                    
                }
            }
            
            p = p.getLiga();
            if(p!=null)
                adelante = p.getLiga();
        }
    }
    
    public PractLista dividirAlternado(int inicio){  //1 la primera sisi, 2 la primera no
        PractLista<T> cadena = new PractLista<>();
        Nodo<T> aux = new Nodo<>();
        
        if(inicio == 1){
            aux = top;
            while(aux !=null){
                cadena.insertar_final(aux.getDato());
                aux=aux.getLiga();
                if(aux!=null)
                    aux=aux.getLiga();
            }
        }else if(inicio == 2){
            aux = top.getLiga();
             
            while(aux !=null){
                cadena.insertar_final(aux.getDato());
                aux=aux.getLiga();
                if(aux!=null)
                    aux=aux.getLiga();
            }
        }
        
        return cadena;
        
        
    }
    
    public void ordenar(int orden){ //1 ascedente, 2 descedente
        Nodo <T>inicio = top;
        Nodo <T>p = inicio;
        Nodo <T>q = p.getLiga();
        
        
        while(p!=null){
            
            while(q!=null){
                
                if(orden == 1){
                    int a = Integer.parseInt(p.getDato().toString());
                    int b = Integer.parseInt(q.getDato().toString());

                    if((a<b)){
                        Nodo<T> aux = p;
                        p=q;
                        q = aux;
                        System.out.println(p.getDato().toString()+'|'+q.getDato().toString());
                    }
                    
                    
                }else if (orden==2){
                    int a = Integer.parseInt(p.getDato().toString());
                    int b = Integer.parseInt(q.getDato().toString());

                    if((a>b)){
                        Nodo<T> aux = p;
                        p=q;
                        q = aux;
                    }                   
                    }
                q=q.getLiga();
                        
            }
            inicio=inicio.getLiga();
            p=inicio;
            if(p != null)
            q=p.getLiga();
        }
    }

    /**
     * @return the top
     */
    public Nodo<T> getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Nodo<T> top) {
        this.top = top;
    }

}