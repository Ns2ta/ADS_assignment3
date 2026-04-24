public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        MyHashTable<String, Integer> table = new MyHashTable<>();

        table.put("hello", 1);
        table.put("bye", 2);
        table.put("hello", 3);

        System.out.println(table.get("hello"));
        System.out.println(table.get("bye"));

        bst.put(1, "A");
        bst.put(2, "B");
        bst.put(5, "D");
        bst.put(3, "C");

        System.out.println(bst.get(1) + " " + bst.get(5));
    }
}