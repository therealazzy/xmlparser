// @(#)DateAssembler.java	 0.0.1

 
package cobol;

import parse.*;
import parse.tokens.*;
public class DateAssembler extends Assembler {

// Pop a string, and set the target SectionName to this string.
public void workOn(Assembly a) {
	Cobol c = new Cobol();
	Token t = (Token) a.pop();
	String tokenString = t.sval().trim();
	
	// deconstructed into month and year components.
	String monthString = "" + tokenString.charAt(0) + tokenString.charAt(1) + tokenString.charAt(2);
	c.setMonthDateWritten(monthString);
	
	String yearString = "" + tokenString.charAt(4) + tokenString.charAt(5) + tokenString.charAt(6) + tokenString.charAt(7);
	c.setYearDateWritten(Integer.parseInt(yearString));
	
	t = (Token) a.pop();
	c.setDayDateWritten( (int) t.nval() );
	a.setTarget(c);
}
}