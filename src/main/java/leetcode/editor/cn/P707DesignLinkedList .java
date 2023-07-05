//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// 
//MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// get, addAtHead, addAtTail, addAtIndex 和 deleteAtIndex 的操作次数不超过 2000。 
// 
//
// Related Topics 设计 链表 👍 762 👎 0

package leetcode.editor.cn;
//java:设计链表
class P707DesignLinkedList{
    public static void main(String[] args){
        Solution solution = new P707DesignLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 定义单链表
class ListNode{
    int val;    // 节点数据值
    ListNode next;  // 下一节点
    ListNode(){}    // 无参构造函数
    ListNode(int val){  //有参构造函数
        this.val = val;
    }
}

class MyLinkedList {
    // 保存链表长度值
    int size;
    // 虚拟头节点
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
    public int get(int index) {
        // 若index非法，则返回-1
        if(index < 0 || index >= size)
            return -1;
        ListNode currentNode = head;
        // 由于包含虚拟节点，则需要查询第 index+1 个节点
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        int i = 0;
        ListNode currentNode = head;
        ListNode newNode = new ListNode(val);
        newNode.next = null;
        while(i <= size){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        if(index < 0)
            index = 0;
        size++;

        // 找到插入节点的前驱节点
        ListNode pre = head;
        for(int i = 0; i<index; i++){
            pre = pre.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        // 判断节点
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}