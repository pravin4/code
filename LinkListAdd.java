
public class LinkListAdd {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next;
		
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(8)));
		ListNode l2 = new ListNode(8, new ListNode(8, new ListNode(8, new ListNode(4))));
		
		ListNode l3 = addTwoNumbers(l1,l2);
		printValues(l3);
	}

	private static void printValues(LinkListAdd.ListNode l3) {
		while (l3!=null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode lsum = new ListNode(0);
		ListNode temp = lsum;
		int carry = 0;
		
		while(l1 != null || l2 != null || carry == 1) {
			int sum = 0;
			
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			
			sum += carry;
			carry = sum/10;
			
			ListNode current = new ListNode(sum%10);
			temp.next = current;
			temp = temp.next;
		}
		return lsum.next;

	}
}
