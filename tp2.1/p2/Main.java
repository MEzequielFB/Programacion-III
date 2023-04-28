public class Main {
    public static void main(String[] args) {
        Tree tree1 = new Tree();

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

        System.out.println("Tree1 internal nodes sum: " + tree1.getInternalNodesSum());
    }
}