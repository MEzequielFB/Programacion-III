import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

    private int cantidad_vertices;
    private int cantidad_arcos;
    private LinkedList<Tarea> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new LinkedList<>();
        this.arcos = new LinkedList<>();
    }

	@Override
	public void agregarVertice(String nombre_tarea, String descripcion, int duracion) {
		if (!this.contieneVertice(nombre_tarea)) {
            this.vertices.add(new Tarea(nombre_tarea, descripcion, duracion));
            this.cantidad_vertices++;
        }
	}

    public int obtenerDuracionVertice(String nombre_tarea) {
        for (Tarea vertice : this.vertices) {
            if (vertice.getNombre().equals(nombre_tarea)) {
                return vertice.getDuracion();
            }
        }
        return -1;
    }

	@Override
	public void borrarVertice(String nombre_tarea) {
        for (Tarea vertice : this.vertices) {
            if (vertice.getNombre().equals(nombre_tarea)) {
                this.vertices.remove(vertice);
                this.cantidad_vertices--;

                this.borrarArcos(nombre_tarea);
                return;
            }
        }
	}

    private Tarea obtenerVertice(String nombre_tarea) {
        for (Tarea vertice : this.vertices) {
            if (vertice.getNombre().equals(nombre_tarea)) {
                return vertice;
            }
        }
        return null;
    }

    //Borra todos los arcos que contengan el vertice pasado por parametro
    private void borrarArcos(String nombre_tarea) {
        Iterator<Arco<T>> arcos_vertice = this.obtenerArcos();
        while (arcos_vertice.hasNext()) {
            Arco<T> arco = arcos_vertice.next();
            if (arco.getVerticeOrigen().equals(nombre_tarea) || arco.getVerticeDestino().equals(nombre_tarea)) {
                arcos_vertice.remove();
                this.cantidad_arcos--;
            }
        }
    }

	@Override
	public void agregarArco(String nombre_tarea1, String nombre_tarea2, T etiqueta) {
		if (this.contieneVertice(nombre_tarea1) && this.contieneVertice(nombre_tarea2)) {
            if (!this.existeArco(nombre_tarea1, nombre_tarea2)) {
                this.arcos.add(new Arco<T>(nombre_tarea1, nombre_tarea2, etiqueta));
                this.cantidad_arcos++;
            }
        }
	}

	@Override
	public void borrarArco(String nombre_tarea1, String nombre_tarea2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen().equals(nombre_tarea1) && arco.getVerticeDestino().equals(nombre_tarea2)) {
                this.arcos.remove(arco);
                this.cantidad_arcos--;
                return;
            }
        }
	}

	@Override
	public boolean contieneVertice(String nombre_tarea) {
		for (Tarea vertice : this.vertices) {
            if (vertice.getNombre().equals(nombre_tarea)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public boolean existeArco(String nombre_tarea1, String nombre_tarea2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen().equals(nombre_tarea1) && arco.getVerticeDestino().equals(nombre_tarea2)) {
                return true;
            }
        }
        return false;
	}

	@Override
	public Arco<T> obtenerArco(String nombre_tarea1, String nombre_tarea2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen().equals(nombre_tarea1) && arco.getVerticeDestino().equals(nombre_tarea2)) {
                return arco;
            }
        }
        return null;
	}

	@Override
	public int cantidadVertices() {
		return this.cantidad_vertices;
	}

	@Override
	public int cantidadArcos() {
		return this.cantidad_arcos;
	}

	@Override
	public Iterator<Tarea> obtenerVertices() {
		return this.vertices.iterator();
	}

	@Override
	public Iterator<Tarea> obtenerAdyacentes(String nombre_tarea) {
        //Crea una lista para los adyacentes
        LinkedList<Tarea> adyacentes = new LinkedList<>();
        //Recorre los arcos
        for (Arco<T> arco : this.arcos) {
            //Si el origen es igual al numero pasado por parametro, se agrega el destino a la lista de adyacentes
            if (arco.getVerticeOrigen().equals(nombre_tarea)) {
                adyacentes.add(this.obtenerVertice(arco.getVerticeDestino()));
            }
        }
        //Retorna el iterator de la lista
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		return this.arcos.iterator();
	}

    //Devuelve los arcos en los que aparece el vertice pasado por parametro
	@Override
	public Iterator<Arco<T>> obtenerArcos(String nombre_tarea) {
        LinkedList<Arco<T>> arcos_vertice = new LinkedList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen().equals(nombre_tarea) || arco.getVerticeDestino().equals(nombre_tarea)) {
                arcos_vertice.add(arco);
            }
        }
		return arcos_vertice.iterator();
	}
}