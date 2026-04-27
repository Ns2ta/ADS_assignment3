import java.util.Random;
public class Main {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "A");
        bst.put(2, "B");
        bst.put(5, "D");
        bst.put(3, "C");

        System.out.println(bst.get(1) + " " + bst.get(5));

        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(101);

        Random rand = new Random();

        for (int i = 0; i < 10000; i++) {
            int a = rand.nextInt(1000);
            int b = rand.nextInt(1000);

            table.put(new MyTestingClass(a, b), i);
        }

        System.out.println("Size: " + table.size());
        table.printBucketStats();
    }
}