package practlista;

public class PractLista<T> {
    private Nodo<T> top = null;
    
    public void insertar_inicio(T x){
        Nodo<T> nuevo = new Nodo(x);
        nuevo.setLiga(top);
        top = nuevo;
    }
    
    public void insertar_final(T x){
        Nodo<T> aux = top; 
        while(aux.getLiga()!=null)
            aux = aux.getLiga();
        aux.setLiga(new Nodo(x));
    }
    
    public void mostrar(){
        Nodo<T> aux = top;
        while(aux!=null){
            System.out.print(aux.getDato()+" | ");
            aux = aux.getLiga();
        }
        System.out.println();
    }
    
    public PractLista<T> inversaLista(){
        PractLista<T> regreso = new PractLista<>();
        Nodo<T> q = top;
        while(q!=null){
            regreso.insertar_inicio(q.getDato());
            q = q.getLiga();
        }
        return regreso;
    }
    
    public void insertarAntesX(T dato, T referencia){
        Nodo<T> p = top;
        boolean bandera = true;
        
        if(p == null)
            System.out.print("No ahi elementos");
        else{
            while(bandera && p.getLiga()!=null){
            if(p.getLiga().getDato()==T){
                Nodo<T> nuevo = new Nodo<>(dato);
                nuevo.setLiga(p.getLiga());
                p.setLiga(nuevo);
                bandera = false;
            }else
                p=p.getLiga();
            }
            
            if(!bandera)
                System.out.println("No se encontro el elemento");
        }
    }

    public static void main(String[] args) {
        PractLista nodos = new PractLista();
        
        nodos.insertar_inicio("5");
        nodos.insertar_inicio("casa");
        nodos.insertar_inicio("10");
        nodos.insertar_final("nacho");
        nodos.mostrar();
        nodos.insertarAntesX("trololo", "casa");
        nodos.inversaLista().mostrar();
    }
    
}
