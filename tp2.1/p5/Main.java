public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.setRoot("M");
        
        Node tree_root = tree.getRoot();

        //Root left subtree
        tree_root.setLeft(new Node("A"));

        tree_root.getLeft().setLeft(new Node("L"));
        tree_root.getLeft().setRight(new Node("N"));

        tree_root.getLeft().getRight().setLeft(new Node("A"));
        tree_root.getLeft().getRight().setRight(new Node("O"));

        //Root right subtree
        tree_root.setRight(new Node("I"));

        tree_root.getRight().setLeft(new Node("S"));
        tree_root.getRight().setRight(new Node("O"));

        tree_root.getRight().getLeft().setRight(new Node("A"));

        //Get words
        System.out.println("Tree words with N vowels: " + tree.getWords(1));
        System.out.println("Tree words with N vowels: " + tree.getWords(2));
        System.out.println("Tree words with N vowels: " + tree.getWords(3));
        System.out.println("Tree words with N vowels: " + tree.getWords(0));
    }
}