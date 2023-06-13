public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        list.insertFront(1);
        list.insertFront(54);
        list.insertFront(5);
        list.insertFront(15);
        list.insertFront(4);

        System.out.println("Extraido: " +  list.extractFront());
        System.out.println("Size: " + list.size());
        System.out.println("Get: " + list.get(2));
        System.out.println("Get: " + list.get(10));
        System.out.println("Empty: " + list.isEmpty());

        System.out.println(list);
    }
}