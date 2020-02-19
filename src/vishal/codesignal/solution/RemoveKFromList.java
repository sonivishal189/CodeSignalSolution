package vishal.codesignal.solution;

class ListNode<T> {
	ListNode(T x) {
		value = x;
	}

	T value;
	ListNode<T> next;

	@Override
	public String toString() {
		return "ListNode [value=" + value + ", next=" + next + "]";
	}

}

public class RemoveKFromList {

	public static void main(String[] args) {
		int k = 3;
		ListNode first = new ListNode(3);
		first.next = new ListNode(1);
		first.next.next = new ListNode(2);
		first.next.next.next = new ListNode(3);
		first.next.next.next.next = new ListNode(4);
		first.next.next.next.next.next = new ListNode(5);

		RemoveKFromList list = new RemoveKFromList();
		ListNode<Integer> res = list.removeKFromList(first, k);
		while (res != null) {
			System.out.println(res.value);
			res = res.next;
		}
	}

	ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
		while (l != null && l.value == k) {
			l = l.next;
		}
		if (l != null) {
			ListNode<Integer> prev = null;
			ListNode<Integer> cur = l;
			while (cur != null) {
				if (cur.value == k) {
					cur = cur.next;
					prev.next = cur;
				} else {
					prev = cur;
					cur = cur.next;
				}
			}
		}
		return l;
	}
}
