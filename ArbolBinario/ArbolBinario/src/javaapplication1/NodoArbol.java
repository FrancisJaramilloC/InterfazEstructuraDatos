package javaapplication1;

public class NodoArbol extends Nodo{
    
    private NodoArbol nodoIzquierdo;
    private NodoArbol nodoDerecho;

    public NodoArbol(int valor) {
        super(valor);
    }

    public NodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(NodoArbol nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoArbol nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }
    
    public void insertarNodo(int _valor) {
        if(_valor < this.valor) {   //Se evalua el nodo "raiz"
            //Insertar en lado Izquierdo
            if(this.nodoIzquierdo == null){
                this.nodoIzquierdo = new NodoArbol(_valor); //Si el nodo esta vacio, se coloca el nuevo nodo
            } else {
                this.nodoIzquierdo.insertarNodo(_valor);    //Aplicacion de recursividad
            }
        } else {
            //Insertar en lado Derecho
            if(this.nodoDerecho == null){   
                this.nodoDerecho = new NodoArbol(_valor);   
            } else {
                this.nodoDerecho.insertarNodo(_valor);
            }
        }
    }
    
    public NodoArbol eliminarNodo(NodoArbol root, int valor) {
        if (root == null) {
            return null;
        }

        if (valor < root.getValor()) {
            root.setNodoIzquierdo(eliminarNodo(root.getNodoIzquierdo(), valor));
        } else if (valor > root.getValor()) {
            root.setNodoDerecho(eliminarNodo(root.getNodoDerecho(), valor));
        } else {
            // Nodo encontrado
            if (root.getNodoIzquierdo() == null) {
                return root.getNodoDerecho();
            } else if (root.getNodoDerecho() == null) {
                return root.getNodoIzquierdo();
            }

            // Nodo con dos hijos: encontrar el nodo más grande del subárbol izquierdo
            NodoArbol mayorNodo = obtenerMayor(root.getNodoIzquierdo());

            // Copiar el valor del mayor nodo en el nodo raíz
            root.setValor(mayorNodo.getValor());

            // Eliminar el mayor nodo en el subárbol izquierdo
            root.setNodoIzquierdo(eliminarNodo(root.getNodoIzquierdo(), mayorNodo.getValor()));
        }
        return root;
    }

    private NodoArbol obtenerMayor(NodoArbol root) {
        NodoArbol actual = root;
        while (actual.getNodoDerecho() != null) {
            actual = actual.getNodoDerecho();
        }
        return actual;
    }
}