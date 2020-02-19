package vishal.codesignal.solution;

public class FirstDuplicate {

	public static void main(String[] args) {
		int a[] = { 2, 1, 3, 5, 3, 2 };
		FirstDuplicate duplicate = new FirstDuplicate();
		System.out.println(duplicate.firstDuplicate(a));
	}

	int firstDuplicate(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[Math.abs(a[i]) - 1] < 0) {
				return Math.abs(a[i]);
			} else {
				a[Math.abs(a[i]) - 1] = -a[Math.abs(a[i]) - 1];
			}
		}
		return -1;
	}
}
