package vishal.codesignal.solution;

public class ReverseNodeInKGroups {

	public static void main(String[] args) {
		ReverseNodeInKGroups reverseNodeInKGroups = new ReverseNodeInKGroups();

		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(2);
		head.next.next = new ListNode<Integer>(3);
		head.next.next.next = new ListNode<Integer>(4);
		head.next.next.next.next = new ListNode<Integer>(5);
		head.next.next.next.next.next = new ListNode<Integer>(6);
		head.next.next.next.next.next.next = new ListNode<Integer>(7);
		head.next.next.next.next.next.next.next = new ListNode<Integer>(8);
		head.next.next.next.next.next.next.next.next = new ListNode<Integer>(9);
		head.next.next.next.next.next.next.next.next.next = new ListNode<Integer>(10);
		head.next.next.next.next.next.next.next.next.next.next = new ListNode<Integer>(11);
		System.out.println(reverseNodeInKGroups.reverseNodesInKGroups(head, 3));
	}

	ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

		ListNode<Integer> res = null;
		ListNode<Integer> cur = null;
		int count = 0;
		while (l != null) {
			if (cur == null) {
				cur = new ListNode<Integer>(l.value);
				count++;
			} else {
				ListNode<Integer> temp = cur;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new ListNode<Integer>(l.value);
				count++;
			}
			if (count == k) {
				if (res == null) {
					res = reverseList(cur, k);
				} else {
					ListNode<Integer> x = res;
					while (x.next != null) {
						x = x.next;
					}
					x.next = reverseList(cur, k);
				}
				count = 0;
				cur = null;
			}
			l = l.next;
		}
		ListNode<Integer> x = res;
		while (x.next != null) {
			x = x.next;
		}
		x.next = cur;
		return res;
	}

	ListNode<Integer> reverseList(ListNode<Integer> head, int k) {
		ListNode<Integer> prev = null;
		ListNode<Integer> temp = null;
		ListNode<Integer> first = head;
		int count = 0;
		while (count < k && null != first) {
			temp = first.next;
			first.next = prev;
			;
			prev = first;
			first = temp;
			count++;
		}
		if (count == k) {
			return prev;
		}
		return head;
	}
}
