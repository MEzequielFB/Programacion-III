public class Main {
    public static void main(String[] args) {
        ListaVinculadaSimple lista = new ListaVinculadaSimple();

        System.out.println("Tamanio: " + lista.getTamanio());
        lista.insertarFrente("Soy un string");
        lista.insertarFrente("Soy un string 2");
        System.out.println("Tamanio: " + lista.getTamanio()+"\n");

        System.out.println(lista+"\n");

        System.out.println(lista.extraerFrente()+"\n");

        System.out.println(lista.estaVacio()+"\n");

        System.out.println(lista.get(3));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
    }
}