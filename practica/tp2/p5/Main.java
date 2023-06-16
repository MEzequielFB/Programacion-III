public class Main {
    public static void main(String[] args) {
        TreeWithNode tree = new TreeWithNode();
        tree.insert("M");

        TreeNode root = tree.getRoot();
        root.setLeft(new TreeNode("A"));
        root.getLeft().setLeft(new TreeNode("L"));
        root.getLeft().setRight(new TreeNode("N"));
        root.getLeft().getRight().setLeft(new TreeNode("A"));
        root.getLeft().getRight().setRight(new TreeNode("O"));

        root.setRight(new TreeNode("I"));
        root.getRight().setLeft(new TreeNode("S"));
        root.getRight().getLeft().setRight(new TreeNode("A"));
        root.getRight().setRight(new TreeNode("O"));

        System.out.println("Tree:");
        tree.printPreOrder();

        System.out.println("\nWords 1: " + tree.getWords(1));
        System.out.println("Words 2: " + tree.getWords(2));
    }
}