public class Main {
    public static void main(String[] args) {
        TreeWithNode tree = new TreeWithNode();
        tree.add(7);
        tree.add(5);
        tree.add(3);
        tree.add(12);
        tree.add(10);
        tree.add(16);
        tree.add(18);

        System.out.println("Sum internal nodes: " + tree.getInternalNodesSum());

        System.out.println("\nTree:");
        tree.printPreOrder();
    }
}