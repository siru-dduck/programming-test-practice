package hash;

public class ChainHash<K, V> {
    private Node<K, V>[] table;
    private int size;

    public ChainHash(int capacity) {
        try{
            table = new Node[capacity];
            this.size = capacity;
        } catch(OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    public V search(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while(p != null) {
            if(p.getKey().equals(key)) {
                return p.getValue();
            }
            p = p.next;
        }
        return null;
    }

    public int add(K key, V data) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];

        while(p != null) {
            if(p.getKey().equals(key)) {
                return 1;
            }
            p = p.next;
        }
        Node<K, V> temp = new Node<>(key,data,table[hash]);
        table[hash] = temp;
        return 0;
    }

    public int remove(K key) {
        int hash = hashValue(key);
        Node<K, V> p = table[hash];
        Node<K, V> pp = null;

        while(p != null) {
            if(p.getKey().equals(key)) {
                if(pp == null) {
                    table[hash] = p.next;
                } else {
                    pp.next = p.next;
                }
                return 0;
            }
            pp = p;
            p = p.next;
        }
        return 1;
    }

    public void dump() {
        for(int i = 0; i < size; i++) {
            Node<K,V> p = table[i];
            System.out.printf("%02d ", i);
            while(p != null) {
                System.out.printf("-> %s (%s) ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        public Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    public static void main(String[] args) {
        ChainHash<Integer, String> chainHash = new ChainHash<>(12);
        chainHash.add(1, "철수");
        chainHash.add(1, "영희");
        chainHash.add(2, "민수");
        chainHash.add(12, "민철");
        chainHash.add(54, "시루");
        chainHash.add(5, "만덕");
        chainHash.add(23, "경희");
        chainHash.add(14, "민주");
        chainHash.dump();

        chainHash.remove(23);
        chainHash.dump();

        System.out.println(chainHash.search(1));
        System.out.println(chainHash.search(23));
    }
}
