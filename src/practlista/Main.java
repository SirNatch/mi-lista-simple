package practlista;

public class Main {
        public static void main(String[] args) {
        PractLista nodos = new PractLista();

 
        nodos.insertar_inicio("3");
        nodos.insertar_inicio("1");
        nodos.insertar_inicio("6");
        nodos.insertar_inicio("2");
        nodos.insertar_inicio("5");
        nodos.mostrar();
        nodos.ordenar(1);
        nodos.mostrar();
        //nodos.inversaLista().mostrar();
        
        //nodos.dividir(2).mostrar();

        
    }
}
