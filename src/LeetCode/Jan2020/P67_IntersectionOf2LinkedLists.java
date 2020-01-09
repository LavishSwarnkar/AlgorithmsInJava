package LeetCode.Jan2020;

public class P67_IntersectionOf2LinkedLists {

    public static void main(String args[]){

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getListLen(headA)
                , len2 = getListLen(headB);
        if(len1 < len2)
            for(int i=0 ; i<len2-len1 ; i++)
                headB = headB.next;
        else if(len1 > len2)
            for(int i=0 ; i<len1-len2 ; i++)
                headA = headA.next;

        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int getListLen(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

}
