package vishal.codesignal.solution;

public class IsListPalindrome {

	public static void main(String[] args) {
		IsListPalindrome listPalindrome = new IsListPalindrome();

		ListNode<Integer> first = new ListNode(1);
		first.next = new ListNode(1000000000);
		first.next.next = new ListNode(-1000000000);
		first.next.next.next = new ListNode(-1000000000);
		first.next.next.next.next = new ListNode(1000000000);
		first.next.next.next.next.next = new ListNode(1);
		System.out.println(first);
		System.out.println(listPalindrome.isListPalindrome(first));
	}

	boolean isListPalindrome(ListNode<Integer> l) {
		ListNode<Integer> fast = l;
		ListNode<Integer> slow = l;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		slow = reverse(slow);
		fast = l;
		while (null != slow) {
			if (!fast.value.equals(slow.value)) {
				return false;
			}
			fast = fast.next;
			slow = slow.next;
		}
		return true;
	}

	public ListNode<Integer> reverse(ListNode<Integer> head) {
		ListNode<Integer> prev = null;
		while (head != null) {
			ListNode<Integer> temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
}
