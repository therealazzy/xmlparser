//@(#)Program_IDAssembler.java	 0.0.1

 
package cobol;

import parse.*;
import parse.tokens.*;
public class Program_idAssembler extends Assembler {

// Pop a string, and set the target Program_ID to this string.
public void workOn(Assembly a) {
	Cobol c = new Cobol();
	Token t = (Token) a.pop();
	c.setProgram_ID(t.sval().trim());
	a.setTarget(c);
}
}