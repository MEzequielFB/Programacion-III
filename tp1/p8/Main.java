public class Main {
    public static void main(String[] args) {
        ListaDoblementeVinculada lista = new ListaDoblementeVinculada();
        lista.push("string1");
        lista.push("string2");
        lista.push("string3");

        for (Object elemento : lista) {
            System.out.println(elemento);
        }
        System.out.println("");
        lista.reverse();
        for (Object elemento : lista) {
            System.out.println(elemento);
        }
    }
}