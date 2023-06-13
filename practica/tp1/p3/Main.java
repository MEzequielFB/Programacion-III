public class Main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> list = new MySimpleLinkedList<>();
        list.push(1);
        list.push(8);
        list.push(5);

        System.out.println("List: " + list);
        list.reverse();
        System.out.println("List: " + list);
        System.out.println("Top: " + list.top());
        System.out.println("Pop: " + list.pop());
        System.out.println("List: " + list);
        System.out.println("Pop: " + list.pop());
        System.out.println("List: " + list);
        System.out.println("Pop: " + list.pop());
        System.out.println("List: " + list);
        System.out.println("Pop: " + list.pop());
    }
}