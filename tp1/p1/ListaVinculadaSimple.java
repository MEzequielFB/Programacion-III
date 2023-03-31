public class ListaVinculadaSimple {
    private Nodo primero;
    private int tamanio;

    public ListaVinculadaSimple() {
        this.primero = null;
        this.tamanio = 0;
    }

    public void insertarFrente(Object info) {
        Nodo nodo_nuevo = new Nodo(info, null);
        nodo_nuevo.setSiguiente(this.primero);
        this.setPrimero(nodo_nuevo);
        this.setTamanio(this.tamanio + 1);
    }

    public Object extraerFrente() {
        if (this.primero != null) {
            Object info = this.primero.getInfo();
            return info;
        }
        return null;
    }

    public boolean estaVacio() {
        if (this.tamanio == 0) {
            return true;
        }
        return false;
    }

    public Object get(int indice) {
        Nodo nodo_actual = this.primero;
        int posicion_actual = 0;
        while (indice < this.tamanio && indice >= 0) {
            if (posicion_actual == indice) {
                return nodo_actual.getInfo();
            }
            nodo_actual = nodo_actual.getSiguiente();
            posicion_actual++;
        }
        return null;
    }

    public Nodo getPrimero() {
        return this.primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        String lista_string = "";
        if (this.tamanio > 0) {
            Nodo nodo_actual = this.primero;
            while (nodo_actual != null) {
                lista_string += nodo_actual.getInfo() + " | ";
                nodo_actual = nodo_actual.getSiguiente();
            }
        }
        return lista_string;
    }
}