package parse;

import java.util.*;

public abstract class Assembler {
	
	// Returns ArrayList of the elements that appear ahead of the fence.
	public static ArrayList<Object> elementsAbove(Assembly a, Object fence) {
		ArrayList<Object> items = new ArrayList<Object>();
		 
		while (!a.stackIsEmpty()) {
			Object top = a.pop();
			if (top.equals(fence)) {
				break;
			}
			items.add(top);
		}
		return items;
	}

	public abstract void workOn(Assembly a);
}

