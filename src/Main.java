public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        bst.put(1, "A");
        bst.put(2, "B");
        bst.put(5, "D");
        bst.put(3, "C");

        System.out.println(bst.get(1) + " " + bst.get(5));
    }
}