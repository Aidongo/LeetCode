/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode () {}
        public DLinkedNode (int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> map = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 初始化伪头节点和尾节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = map.get(key);

        if(node == null) {
            return -1;
        }
        
        moveToHead(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if( node == null ) {
            // 创建新节点
            DLinkedNode newNode = new DLinkedNode(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            // 超过容量，删除尾节点
            if(size > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }
    private DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

