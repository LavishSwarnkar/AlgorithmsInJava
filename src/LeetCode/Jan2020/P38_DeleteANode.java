package LeetCode.Jan2020;

public class P38_DeleteANode {

    public static void main(String args[]){

    }

    public void deleteNode(ListNode node) {
        if(node == null)
            return;
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

}
