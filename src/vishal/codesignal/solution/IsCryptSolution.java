package vishal.codesignal.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsCryptSolution {

	public static void main(String[] args) {
		String[] crypt = {"SEND", "MORE", "MONEY"};
		char[][] sol = {{'O','0'}, 
				 		{'M','1'}, 
				 		{'Y','2'}, 
				 		{'E','5'}, 
				 		{'N','6'}, 
				 		{'D','7'}, 
				 		{'R','8'}, 
				 		{'S','9'}};
		IsCryptSolution cryptSolution = new IsCryptSolution();
		System.out.println(cryptSolution.isCryptSolution(crypt, sol));
	}
	
	boolean isCryptSolution(String[] crypt, char[][] solution) {
		int n = solution.length;
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i=0 ; i<n ; i++) {
			map.put(solution[i][0], solution[i][1]);
		}
		List<String> list = new ArrayList<String>();
		for (String s : crypt) {
			if (map.get(s.charAt(0)) == '0' && s.length() > 1) {
				return false;
			}
			String str = "";
			for (char c : s.toCharArray()) {
				str += map.get(c);
			}
			list.add(str);
		}
		if (Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1)) == Integer.parseInt(list.get(2))) {
			return true;
		}
		return false;
	}

}
