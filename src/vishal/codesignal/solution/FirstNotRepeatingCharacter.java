package vishal.codesignal.solution;

public class FirstNotRepeatingCharacter {

	public static void main(String[] args) {
		String s = "abacabad";
		FirstNotRepeatingCharacter notRepeatingCharacter = new FirstNotRepeatingCharacter();
		System.out.println(notRepeatingCharacter.firstNotRepeatingCharacter(s));
	}

	char firstNotRepeatingCharacter(String s) {
		int a[] = new int[26];
		for (char c : s.toCharArray()) {
			a[c - 'a'] += 1;
		}
		for (char c : s.toCharArray()) {
			if (a[c - 'a'] == 1) {
				return c;
			}
		}
		return '_';
	}
}
