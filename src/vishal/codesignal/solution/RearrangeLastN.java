package vishal.codesignal.solution;

public class RearrangeLastN {

	public static void main(String[] args) {
		RearrangeLastN rearrangeLastN = new RearrangeLastN();
		ListNode<Integer> head = new ListNode<Integer>(1);
		head.next = new ListNode<Integer>(2);
		head.next.next = new ListNode<Integer>(3);
		head.next.next.next = new ListNode<Integer>(4);
		head.next.next.next.next = new ListNode<Integer>(5);
		System.out.println(rearrangeLastN.rearrangeLastN(head, 3));
	}

	ListNode<Integer> rearrangeLastN(ListNode<Integer> lst, int n) {
		if (n == 0) {
			return lst;
		}
		ListNode<Integer> revLst = reverseList(lst);
		int count = 0;
		ListNode<Integer> first = revLst;
		ListNode<Integer> prev = null;
		while (revLst != null && count < n) {
			prev = revLst;
			revLst = revLst.next;
			count++;
		}
		if (count == n) {
			prev.next=null;
			first = reverseList(first);
			ListNode<Integer> temp = first;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = reverseList(revLst);
		}
		return first;
	}

	private ListNode<Integer> reverseList(ListNode<Integer> lst) {
		ListNode<Integer> prev = null;
		while (lst != null) {
			ListNode<Integer> temp = lst.next;
			lst.next = prev;
			prev = lst;
			lst = temp;
		}
		return prev;
	}

}
