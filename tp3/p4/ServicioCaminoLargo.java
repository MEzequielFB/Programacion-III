import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class ServicioCaminoLargo {
    private Grafo<?> grafo;
    private int esquina_origen;
    private int esquina_destino;

    public ServicioCaminoLargo(Grafo<?> grafo, int esquina_origen, int esquina_destino) {
        this.grafo = grafo;
        this.esquina_origen = esquina_origen;
        this.esquina_destino = esquina_destino;
    }

    public List<Integer> camino() {
        //Verifica que el grafo tenga ambas esquinas, sino, devuelve null
        if (grafo.contieneVertice(this.esquina_origen) && grafo.contieneVertice(esquina_destino)) {

            //En la lista camino se guardan todos los caminos encontrados
            //La lista camino_mas_largo es la que se le va a devolver al usuario
            LinkedList<LinkedList<Integer>> caminos = new LinkedList<>();
            LinkedList<Integer> camino_mas_largo = new LinkedList<>();

            //Se obtienen los caminos y se guardan en la lista
            this.obtenerCaminos2(caminos);

            //Una vez obtenidos todos los caminos se comparan y se queda con el mas grande (mayor size)
            for (LinkedList<Integer> camino : caminos) {
                if (camino_mas_largo.isEmpty() || camino.size() > camino_mas_largo.size()) {
                    camino_mas_largo = camino;
                }
            }
            //Devuelve el camino mas largo
            return camino_mas_largo;
        }
        return null;
    }

    private void obtenerCaminos2(LinkedList<LinkedList<Integer>> caminos) {
        //La lista esquinas_visitadas se usa para no repetir arcos
        LinkedList<Integer> esquinas_visitadas = new LinkedList<>();

        //Se agrega la esquina origen como primer elemento
        esquinas_visitadas.add(this.esquina_origen);

        //Se inicializa una variable de tipo entro en 0
        int contador = 0;

        //Se recorren los adyacentes de la esquina origen
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(this.esquina_origen);
        while (adyacentes.hasNext()) {
            //Por cada adyacente se incrementa el contador
            contador++;

            //Si la esquina origen tiene mas de un adyacente, el contador va a ser mayor a 1 en un momento dado
            //Si es asi, se borra el ultimo elemento de la lista (el adyacente anterior) para obtener los caminos del adyacente actual
            if (contador > 1) {
                esquinas_visitadas.removeLast();
            }

            //Se guarda en una variable al adyacente actual
            //Si no fue visitado se crea una lista con los elementos de la esquinas visitadas y se agrega el adyacente actual
            //Esto se hace porque se va a pasar por parametro a esquinas_visitadas en el metodo agregarCamino y su contenido sera modificado
            //Una vez que finaliza ese metodo la lista de esquinas visitadas vuelve al estado antes de llamar a ese metodo
            int adyacente = adyacentes.next();
            if (!esquinas_visitadas.contains(adyacente)) {
                LinkedList<Integer> backup_visitadas = new LinkedList<>(esquinas_visitadas);
                backup_visitadas.add(adyacente);

                this.agregarCamino(adyacente, caminos, esquinas_visitadas);

                esquinas_visitadas = backup_visitadas;
            }
        }
    }
    
    private void agregarCamino(int esquina, LinkedList<LinkedList<Integer>> caminos, LinkedList<Integer> esquinas_visitadas) {
        //Se agrega la esquina pasada por parametro a las esquinas visitadas
        esquinas_visitadas.add(esquina);

        //Si la esquina es igual a la esquina destino se agrega el camino conseguido hasta el momento a los caminos y se retorna el metodo
        if (esquina == this.esquina_destino) {
            caminos.add(esquinas_visitadas);
            return;
        }

        //Se recorre los adyacentes de la esquina
        Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(esquina);
        while (adyacentes.hasNext()) {
            //Se guarda el estado actual de la lista de esquinas visitadas
            LinkedList<Integer> backup_visitadas = new LinkedList<>(esquinas_visitadas);

            //Si el adyacente de la esquina no fue visitado
            //Se pregunta si el adyacente es la esquina destino, si lo es se agrega a la lista de visitados y se agrega la lista de visitados como un camino. Finalmente retorna
            //De lo contrario llama recursivamente a agregarCamino pasando al adyacente como parametro para seguir el camino y ver si llega a destino
            //Cuando finaliza el agregarCamino recursivo, la lista de visitados vuelve al estado anterior ya que se buscara un camino a partir de otro adyacente si es que existe
            int adyacente = adyacentes.next();
            if (!esquinas_visitadas.contains(adyacente)) {
                if (adyacente == this.esquina_destino) {
                    esquinas_visitadas.add(adyacente);
                    caminos.add(esquinas_visitadas);
                    return;
                }
                this.agregarCamino(adyacente, caminos, esquinas_visitadas);
                esquinas_visitadas = backup_visitadas;
            }
        }
    }
}