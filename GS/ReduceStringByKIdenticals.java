package gs;

import java.util.*;

public class ReduceStringByKIdenticals {

	static class Entity {
		char character;
		int frequency;

		Entity(char p, int q) {
			character = p;
			frequency = q;
		}
	}

	static String remove_k_characters(String st1, int n, int k) {

		Stack<Entity> st = new Stack<Entity>();
		int i = 0;
		for (i = 0; i < n; i++) {
			char x = st1.charAt(i);
			if (st.size() > 0 && st.peek().frequency == k) {
				char curr = st.peek().character;
				while (st.size() > 0 && st.peek().character == curr)
					st.pop();
			}

			if (st.size() > 0 && st.peek().character == x) {
				Entity new_top = new Entity(x, st.peek().frequency + 1);
				st.push(new_top);
			} else {
				Entity new_top = new Entity(x, 1);
				st.push(new_top);
			}
		}

		if (st.size() > 0 && st.peek().frequency == k) {
			char curr = st.peek().character;
			while (st.size() > 0 && st.peek().character == curr)
				st.pop();
		}

		String stack_string = "";
		while (st.size() > 0)
			stack_string += st.pop().character;

		String reduced_string = "";

		for (i = stack_string.length() - 1; i >= 0; i--)
			reduced_string += stack_string.charAt(i);

		return reduced_string;
	}

}
