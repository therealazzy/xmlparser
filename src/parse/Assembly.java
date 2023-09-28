package parse;

import java.util.*;
import utensil.*;

public abstract class Assembly implements Enumeration<Object>, PubliclyCloneable {
	/*
	 * a place to keep track of consumption progress.
	 */
		protected Stack<Object> stack = new Stack<Object>();
		
		protected PubliclyCloneable target;

	/*
	 * which element is next.
	 */
		protected int index = 0;

	// Return a copy of this object.

	public Object clone() {
		try {
			Assembly a = (Assembly) super.clone();
			a.stack = (Stack<Object>) stack.clone();
			if (target != null) {
				a.target = (PubliclyCloneable) target.clone();
			}
			return a;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}
	/**
	 * Returns the elements of the assembly that have been 
	 * consumed, separated by the specified delimiter.
	 */
	public abstract String consumed(String delimiter);

	//  Returns the default string to show between elements.

	public abstract String defaultDelimiter();

	//  Returns the number of elements that have been consumed.

	public int elementsConsumed() {
		return index;
	}

	//  Returns the number of elements that have not been consumed.

	 
	public int elementsRemaining() {
		return length() - elementsConsumed();
	}

	//  Removes this assembly's stack.

	public Stack<Object> getStack() {
		return stack;
	}

	//  Returns the object identified as this assembly's "target". 

	public Object getTarget() {
		return target;
	}

	//  Returns true if this assembly has unconsumed elements.

	 
	public boolean hasMoreElements() {
		return elementsConsumed() < length();
	}

	//  Returns the number of elements in this assembly.

	public abstract int length();

	//  Shows the next object in the assembly, without removing it.

	public abstract Object peek();

	//  Removes the object at the top of this assembly's stack and returns it.


	public Object pop() {
		return stack.pop();
	}

	// Pushes an object onto the top of this assembly's stack. 

	public void push(Object o) {
		stack.push(o);
	}

	// Returns the elements of the assembly that remain to be consumed

	public abstract String remainder(String delimiter);
	/**
	 * Sets the target for this assembly. Targets must implement 
	 * <code>clone()</code> as a public method.
	 */
	public void setTarget(PubliclyCloneable target) {
		this.target = target;
	}

	// Returns true if this assembly's stack is empty.
	
	public boolean stackIsEmpty() {
		return stack.isEmpty();
	}

	// Returns a textual description of this assembly.

	public String toString() {
		String delimiter = defaultDelimiter();
		return stack + 
			consumed(delimiter) + "^" + remainder(delimiter);
	}

	
	// Put back n objects

	 
	public void unget(int n) {
		index -= n;
		if (index < 0) {
			index = 0;
		}
	}
}
