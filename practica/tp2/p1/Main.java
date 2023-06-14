public class Main {
    public static void main(String[] args) {
        TreeWithNode tree = new TreeWithNode();
        tree.add(7);
        tree.add(5);
        tree.add(3);
        tree.add(12);
        tree.add(10);
        tree.add(16);

        System.out.println("Root: " + tree.getRoot());
        System.out.println("HasElem 2: " + tree.hasElem(2));
        System.out.println("HasElem 12: " + tree.hasElem(12));
        System.out.println("Delete: " + tree.delete(7));

        System.out.println("\nTree:");
        tree.printOrder();
    }
}