public class Pila {
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public Pila() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public void push(Object info) {
        Nodo nodo_nuevo = new Nodo(info, null);
        if (this.estaVacio()) {
            this.setPrimero(nodo_nuevo);
        }
        this.setUltimo(nodo_nuevo);
        this.setTamanio(this.tamanio + 1);
    }

    public Object pop() {
        if (!this.estaVacio()) {
            Object ultimo_nodo_info = this.ultimo.getInfo();
            int indice = 0;
            /* Nodo nuevo_nodo_ultimo = null; */
            while (indice < this.tamanio  && indice >= 0 /* && nuevo_nodo_ultimo == null */) {
                Nodo nodo_actual = this.getNodo(indice);
                if (nodo_actual.getSiguiente().equals(this.ultimo)) {
                    nodo_actual.setSiguiente(null);
                    this.setUltimo(nodo_actual);
                    this.setTamanio(this.tamanio - 1);
                    return ultimo_nodo_info;
                    /* nuevo_nodo_ultimo = nodo_actual; */
                }
            }
        }
        return null;
    }

    public void insertarFrente(Object info) {
        Nodo nodo_nuevo = new Nodo(info, this.primero);
        if (this.estaVacio()) {
            this.setUltimo(nodo_nuevo);
        }
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

    public Nodo getNodo(int indice) {
        Nodo nodo_actual = this.primero;
        int posicion_actual = 0;
        while (indice < this.tamanio && indice >= 0) {
            if (posicion_actual == indice) {
                return nodo_actual;
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

    public Nodo getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
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