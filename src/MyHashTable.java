public class MyHashTable <K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

        private HashNode<K, V>[] chainArray;
        private int M = 11;
        private int size;

        private void rehash(int newM) {
            HashNode<K, V>[] oldArray = chainArray;

            chainArray = (HashNode<K, V>[]) new HashNode[newM];
            int oldM = M;
            M = newM;

            size = 0;

            for (int i = 0; i < oldM; i++) {
                for (HashNode<K, V> node = oldArray[i]; node!= null; node = node.next) {
                    putInternal(node.key, node.value);
                }
            }
        }

        public MyHashTable() {
            this.M = 11;
            chainArray = (HashNode<K, V>[]) new HashNode[M];
        }

        public MyHashTable(int M) {
            this.M = M;
            chainArray = (HashNode<K, V>[]) new HashNode[M];
        }

        private int hash(K key) {
            return (key.hashCode() & Integer.MAX_VALUE) % M;
        }

        private void putInternal(K key, V value) {
            int index = hash(key);

            HashNode<K, V> head = chainArray[index];

            for (HashNode<K, V> node = head; node!= null; node = node.next) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }

            HashNode<K, V> newNode = new HashNode<>(key, value);
            newNode.next = head;
            chainArray[index] = newNode;

            size++;
        }

        public void put(K key, V value) {
            if (value == null) throw new NullPointerException();
            if (key == null) throw new NullPointerException();

            if ((double)(size + 1) / M >= 0.75) {
                rehash(2 * M + 1);
            }

            putInternal(key, value);
        }

        public V get(K key) {
            if (key == null) throw new NullPointerException();

            int index = hash(key);

            for (HashNode<K, V> node = chainArray[index]; node != null; node = node.next) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

            return null;
        }

        public V remove (K key) {
            if (key == null) throw new NullPointerException();

            int index = hash(key);

            HashNode<K, V> current = chainArray[index];
            HashNode<K, V> prev = null;

            while (current != null) {
                if (current.key.equals(key)) {
                    if (prev == null) {
                        chainArray[index] = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    size--;
                    return current.value;
                }

                prev = current;
                current = current.next;
            }

            return null;
        }

        public boolean contains(V value) {
            if (value == null) throw new NullPointerException();

            for (int i = 0; i < M; i++) {
                for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                    if (node.value.equals(value)) return true;
                }
            }
            return false;
        }

        public K getKey(V value) {
            if (value == null) throw new NullPointerException();

            for (int i = 0; i < M; i++) {
                for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                    if (node.value.equals(value)) return node.key;
                }
            }
            return null;
        }

        public int size() {
            return size;
        }

    public void printBucketStats() {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int nonEmpty = 0;

        for (int i = 0; i < M; i++) {
            int count = 0;

            for (HashNode<K, V> node = chainArray[i]; node != null; node = node.next) {
                count++;
            }

            if (count > 0) nonEmpty++;
            max = Math.max(max, count);
            min = Math.min(min, count);

            System.out.println("Bucket " + i + ": " + count);
        }

        System.out.println();
        System.out.println("Number of buckets: " + M);
        System.out.println("Non-empty buckets: " + nonEmpty);
        System.out.println("Max chain: " + max);
        System.out.println("Min chain: " + min);
    }
}
