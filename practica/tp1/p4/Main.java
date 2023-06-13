public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        list.push(1);
        list.push(8);
        list.push(5);

        System.out.println(list.pop());
        System.out.println("List: " + list);
        System.out.println("IndexOf: " + list.indexOf(8));
        System.out.println("IndexOf: " + list.indexOf(5));
        System.out.println("IndexOf: " + list.indexOf(1));
        System.out.println("IndexOf: " + list.indexOf(10));
    }
}