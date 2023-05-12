import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

    private int cantidad_vertices;
    private int cantidad_arcos;
    private LinkedList<Integer> vertices;
    private LinkedList<Arco<T>> arcos;

    public GrafoDirigido() {
        this.cantidad_vertices = 0;
        this.cantidad_arcos = 0;
        this.vertices = new LinkedList<>();
        this.arcos = new LinkedList<>();
    }

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.contieneVertice(verticeId)) {
            this.vertices.add(verticeId);
            this.cantidad_vertices++;
        }
	}

	@Override
	public void borrarVertice(int verticeId) {
        Integer vertice_a_borrar = (Integer) verticeId;
        if (this.vertices.remove(vertice_a_borrar)) {
            this.cantidad_vertices--;
        }

        this.borrarArcos(verticeId);
	}

    //Borra todos los arcos que contengan el vertice pasado por parametro
    private void borrarArcos(int verticeId) {
        Iterator<Arco<T>> arcos_vertice = this.obtenerArcos();
        while (arcos_vertice.hasNext()) {
            Arco<T> arco = arcos_vertice.next();
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                arcos_vertice.remove();
                this.cantidad_arcos--;
            }
        }
    }

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (!this.existeArco(verticeId1, verticeId2) && this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
            this.arcos.add(new Arco<T>(verticeId1, verticeId2, etiqueta));
            this.cantidad_arcos++;
        }
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                this.arcos.remove(arco);
                this.cantidad_arcos--;
                return;
            }
        }
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.contains(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
                return true;
            }
        }
        return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId1 && arco.getVerticeDestino() == verticeId2) {
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
	public Iterator<Integer> obtenerVertices() {
		return this.vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        //Crea una lista para los adyacentes
        LinkedList<Integer> adyacentes = new LinkedList<>();
        //Recorre los arcos
        for (Arco<T> arco : this.arcos) {
            //Si el origen es igual al numero pasado por parametro, se agrega el destino a la lista de adyacentes
            if (arco.getVerticeOrigen() == verticeId) {
                adyacentes.add(arco.getVerticeDestino());
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
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        LinkedList<Arco<T>> arcos_vertice = new LinkedList<>();
        for (Arco<T> arco : this.arcos) {
            if (arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId) {
                arcos_vertice.add(arco);
            }
        }
		return arcos_vertice.iterator();
	}

}