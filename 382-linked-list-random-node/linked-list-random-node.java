/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 import java.util.*;
class Solution {
    ListNode head ;
    Random rand ;
    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }
    
    public int getRandom() {
            int count =0;
            ListNode temp = head;
            int y = -1;
            while(temp!=null){
                count++;
                if(rand.nextInt(count)==0){
                    y =  temp.val;
                }
                temp = temp.next;
            }
            return y;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */