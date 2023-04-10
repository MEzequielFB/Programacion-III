import java.util.Iterator;

public class ListaDoblementeVinculada implements Iterable<Object> {
    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public ListaDoblementeVinculada() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterador(this.primero);
    }

    public int indexOf(Object info) {
        int indice = 0;
        while (indice < this.tamanio) {
            Nodo nodo_actual = this.getNodo(indice);
            if (nodo_actual.getInfo().equals(info)) {
                return indice;
            }
            indice++;
        }
        return -1;
    }

    public void reverse() {
        Nodo ultimo_nodo_original = this.ultimo;
        Nodo siguiente_del_ultimo = null;
        Nodo nodo_actual = null;
        Nodo proximo_nodo_actual = this.ultimo.getAnterior();
        int i = 0;

        while (i < this.tamanio) {
            nodo_actual = proximo_nodo_actual;
            proximo_nodo_actual = nodo_actual.getAnterior();

            this.ultimo.setSiguiente(nodo_actual);
            nodo_actual = nodo_actual.getAnterior();
            this.ultimo.setAnterior(nodo_actual);
            if (nodo_actual != null) {
                nodo_actual.setSiguiente(this.ultimo);
            }
    
            siguiente_del_ultimo = this.ultimo.getSiguiente();
            siguiente_del_ultimo.setAnterior(this.ultimo);
            siguiente_del_ultimo.setSiguiente(null);
            this.setUltimo(siguiente_del_ultimo);

            /* nodo_actual = proximo_nodo_actual; */

            i++;
        }
        ultimo_nodo_original.setAnterior(null);
        this.setPrimero(ultimo_nodo_original);

        /* Nodo nodo_actual = this.ultimo.getAnterior();
        this.ultimo.setSiguiente(nodo_actual);
        nodo_actual.setAnterior(this.ultimo);
        nodo_actual = nodo_actual.getAnterior();
        this.ultimo.getSiguiente().setAnterior(this.ultimo); */
        /* Nodo ultimo_nodo_original = this.ultimo;
        int indice = this.tamanio - 2 ;
        while (indice >= 0) {
            Nodo nodo_actual = this.getNodo(indice);
            this.ultimo.setSiguiente(nodo_actual);
            this.setUltimo(nodo_actual);
            indice--;
        }
        this.ultimo.setSiguiente(null);
        this.setPrimero(ultimo_nodo_original); */
    }

    public Object top() {
        return this.ultimo.getInfo();
    }

    public void push(Object info) {
        Nodo nodo_nuevo = new Nodo(info, null, this.ultimo);
        if (this.estaVacio()) {
            this.setPrimero(nodo_nuevo);
        }
        if (this.ultimo != null) {
            this.ultimo.setSiguiente(nodo_nuevo);
        }
        this.setUltimo(nodo_nuevo);
        this.setTamanio(this.tamanio + 1);
    }

    public Object pop() {
        if (!this.estaVacio()) {
            Object ultimo_nodo_info = this.ultimo.getInfo();
            if (this.tamanio == 1) {
                this.setPrimero(null);
            } else {
                Nodo anteultimo_nodo = this.ultimo.getAnterior();
                this.setUltimo(anteultimo_nodo);
                anteultimo_nodo.setSiguiente(null);
            }
            this.setTamanio(this.tamanio - 1);
            return ultimo_nodo_info;
        }
        return null;
    }

    public void insertarFrente(Object info) {
        Nodo nodo_nuevo = new Nodo(info, this.primero, null);
        if (this.estaVacio()) {
            this.setUltimo(nodo_nuevo);
        }
        this.setPrimero(nodo_nuevo);
        this.setTamanio(this.tamanio + 1);
    }

    public Object extraerFrente() {
        if (this.primero != null) {
            Object info = this.primero.getInfo();
            this.setPrimero(primero.getSiguiente());
            this.primero.setAnterior(null);
            this.setTamanio(tamanio - 1);
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

    private Nodo getNodo(int indice) {

        /* int minima_posicion = -1;
        int maxima_posicion = -1;
        int modificador = 1;
        int posicion_actual = -1;

        Nodo nodo_actual = null;

        if (indice >= 0 && indice < this.tamanio) {
            int mitad_tamanio = Math.round(this.tamanio / 2);
            if (indice < mitad_tamanio || indice == mitad_tamanio) {
                minima_posicion = 0;
                maxima_posicion = mitad_tamanio;
                modificador = 1;
            }
            if (indice > mitad_tamanio) {
                minima_posicion = mitad_tamanio;
                maxima_posicion = this.tamanio;
                modificador = -1;
            }
            if (modificador > 0) {
                posicion_actual = minima_posicion;
                nodo_actual = this.primero;
            } else {
                posicion_actual = maxima_posicion;
                nodo_actual = this.ultimo;
            }
            while (posicion_actual >= minima_posicion && posicion_actual <= maxima_posicion) {
                if (indice == posicion_actual) {
                    return nodo_actual;
                }
                posicion_actual = posicion_actual + modificador;
            }
        } */
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

    public Object getPrimero() {
        return this.primero.getInfo();
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
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
}