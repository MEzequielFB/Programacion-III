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

        System.out.println("Root: " + tree.getRoot());
        System.out.println("HasElem 2: " + tree.hasElem(2));
        System.out.println("HasElem 12: " + tree.hasElem(12));
        System.out.println("Delete: " + tree.delete(7));
        System.out.println("Heigth: " + tree.getHeight());
        System.out.println("Heigth2: " + tree.getHeight2());
        System.out.println("Longest branch: " + tree.getLongestBranch());
        System.out.println("Frontera: " + tree.getFrontera());
        System.out.println("Max elem: " + tree.getMaxElem());
        System.out.println("Elements at level: " + tree.getElemAtLevel(2));

        System.out.println("\nTree:");
        tree.printPreOrder();
    }
}