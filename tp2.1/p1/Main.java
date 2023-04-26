public class Main {
    public static void main(String[] args) {
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();

        tree1.insert(10);
        tree1.insert(14);
        tree1.insert(2);
        tree1.insert(4);
        tree1.insert(24);
        tree1.insert(5);
        tree1.insert(17);
        tree1.insert(26);
        tree1.insert(8);
        tree1.insert(13);
        tree1.insert(6);

        tree2.insert(2);
        tree2.insert(4);
        tree2.insert(5);
        tree2.insert(6);
        tree2.insert(8);
        tree2.insert(10);
        tree2.insert(13);
        tree2.insert(14);
        tree2.insert(17);
        tree2.insert(24);
        tree2.insert(26);

        /* System.out.println("Tree 1:");
        System.out.println("Pre Order:");
        tree1.printPreOrder();
        System.out.println("Order:");
        tree1.printOrder();
        System.out.println("Post Order:");
        tree1.printPostOrder();

        System.out.println("\nTree 2:");
        System.out.println("Pre Order:");
        tree2.printPreOrder();
        System.out.println("Order:");
        tree2.printOrder();
        System.out.println("Post Order:");
        tree2.printPostOrder(); */

        System.out.println("Max elem tree1: " + tree1.getMaxElem());
        System.out.println("Max elem tree2: " + tree2.getMaxElem());

        System.out.println("Has elem -> 2 " + tree1.hasElem(2));
        System.out.println("Has elem -> 2 " + tree2.hasElem(2));

        System.out.println("Deleted elem -> 5 " + tree1.delete(5));
        System.out.println("Deleted elem -> 5 " + tree2.delete(5));

        System.out.println("Tree 1 height: " + tree1.getHeight());
        System.out.println("Tree 2 height: " + tree2.getHeight());

        System.out.println("Longest branch tree1: " + tree1.getLongestBranch());
        System.out.println("Longest branch tree2: " + tree2.getLongestBranch());

        System.out.println("External nodes tree1: " + tree1.getBorder());
        System.out.println("External nodes tree2: " + tree2.getBorder());

        System.out.println("Elems at level 2 tree1: " + tree1.getElemAtLevel(2));
        System.out.println("Elems at level 2 tree2: " + tree2.getElemAtLevel(2));
    }
}