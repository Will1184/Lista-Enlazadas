public class Lista {
    private Nodo cabeza=null;
    private int longuitud=0;

    private class Nodo{
        public Libro libro;
        public Nodo siguiente=null;

        public Nodo(Libro libro) {
            this.libro = libro;
        }
    }
    public void insertStart(Libro libro){
        Nodo nodo = new Nodo(libro);
        nodo.siguiente = cabeza;
        cabeza=nodo;
        longuitud++;
    }
    public void insertEnd(Libro libro){
        Nodo nodo = new Nodo(libro);
        if (cabeza==null){
            cabeza = nodo;
        }else {
            Nodo puntero = cabeza;
            while (puntero.siguiente != null) {
                puntero = puntero.siguiente;
            }
            puntero.siguiente = nodo;
            longuitud++;
        }
    }
    public void insertAfter(int n,Libro libro){
        Nodo nodo = new Nodo(libro);
        if (cabeza==null){
            cabeza=nodo;
        }else {
            int cont=0;
            Nodo puntero = cabeza;
            while (cont<n && puntero.siguiente!=null){
                puntero = puntero.siguiente;
                cont++;
            }
            nodo.siguiente = puntero.siguiente;
            puntero.siguiente=nodo;
            longuitud++;
        }
    }
    public Libro find(int n){
        if (cabeza==null){
            return null;
        }else {
            Nodo puntero = cabeza;
            int cont=0;
            while (cont <n && puntero.siguiente!= null){
                puntero=puntero.siguiente;
                cont++;
            }
            if (cont!= n){
                return null;
            }else {
                return puntero.libro;
            }
        }
    }
    public int cont(){
        return longuitud;
    }
    public void deleteStart(){
        if (cabeza!=null){
            Nodo primer = cabeza;
            cabeza=cabeza.siguiente;
            primer.siguiente=null;
            longuitud--;
        }
    }
    public void deleteEnd(){
        if (cabeza!=null){
            if (cabeza.siguiente==null){
                cabeza=null;
            }else {
                Nodo puntero=cabeza;
                while (puntero.siguiente.siguiente!=null){
                    puntero = puntero.siguiente;
                }
                puntero.siguiente=null;
            }
        }
    }
    public void deleteLibro(int n){
        if (cabeza!=null){
            if (n==0){
                deleteStart();
            }else if(n<longuitud) {
                Nodo puntero = cabeza;
                int cont=0;
                while (cont<(n-1)){
                    puntero=puntero.siguiente;
                    cont++;
                }
                Nodo temp = puntero.siguiente;
                puntero.siguiente=temp.siguiente;
                temp.siguiente= null;
                longuitud--;
            }
        }
    }
}
