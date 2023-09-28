// @(#)DataDivisionAssembler.java	 0.0.1

 
package cobol;

import parse.*;
import parse.tokens.*;
public class DivisionAssembler extends Assembler {

// Pop a string, and set the target DataDivision to this string.
public void workOn(Assembly a) {
	Cobol c = new Cobol();
	Token t = (Token) a.pop();
	c.setDivisionName(t.sval().trim());
	a.setTarget(c);
}
}