//@(#)SectionAssembler.java	 0.0.1

 
package cobol;

import parse.*;
import parse.tokens.*;
public class SectionNameAssembler extends Assembler {

// Pop a string, and set the target SectionName to this string.
public void workOn(Assembly a) {
	Cobol c = new Cobol();
	Token t = (Token) a.pop();
	c.setSectionName(t.sval() );
	a.setTarget(c);
}
}