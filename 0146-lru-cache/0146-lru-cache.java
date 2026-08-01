class LRUCache {

    Map<Integer, Node> map = new HashMap<>();

    // initialize head, tail with default
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    int capacity;

    static class Node{
        private Node prev;
        private Node next;
        int val;
        int key;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

  
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        
        return node.val;
    }
    
    public void put(int key, int val) {
       Node node = new Node(key, val);
        
        if(map.containsKey(key))
            remove(map.get(key));
        
        if(map.size() == capacity)
        remove(tail.prev);

        insert(node);
    }

    private void insert(Node node){
        map.put(node.key, node);

        node.next= head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */