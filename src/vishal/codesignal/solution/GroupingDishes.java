package vishal.codesignal.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GroupingDishes {

	public static void main(String[] args) {
		GroupingDishes obj = new GroupingDishes();
		String[][] dishes = { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, { "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } };
		System.out.println(dishes.length);
		String res[][] = obj.groupingDishes(dishes);
		for (String[] dish : res) {
			for (String name : dish) {
				System.out.print(name + "  ");
			}
			System.out.println();
		}
	}

	String[][] groupingDishes(String[][] dishes) {
		Map<String, ArrayList<String>> map = new TreeMap<>();
		for (String[] ingred : dishes) {
			for (int i = 1; i < ingred.length; i++) {
				if (map.containsKey(ingred[i])) {
					ArrayList<String> foods = map.get(ingred[i]);
					foods.add(ingred[0]);
					map.put(ingred[i], foods);
				} else {
					ArrayList<String> foods = new ArrayList<>();
					foods.add(ingred[0]);
					map.put(ingred[i], foods);
				}
			}
		}

		ArrayList<String[]> list = new ArrayList<>();
		for (String ingred : map.keySet()) {
			ArrayList<String> foods = map.get(ingred);
			if (foods.size() > 1) {
				Collections.sort(foods);
				String[] fin = new String[foods.size() + 1];
				fin[0] = ingred;
				for (int i = 0; i < foods.size(); i++)
					fin[i + 1] = foods.get(i);
				list.add(fin);
			}
		}

//	    Collections.sort(list,(a,b)->a[0].compareTo(b[0]));
		return list.toArray(new String[0][]);
	}
}
