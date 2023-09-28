//@(#)Cobol.java	 0.0.1
 

package cobol;

import utensil.*;

public class Cobol implements PubliclyCloneable {
	protected String commentLine;
	protected String program_id;
	protected String sectionName;
	protected String divisionName;
	protected int dayDateWritten = 0;
	protected String monthDateWritten;
	protected int yearDateWritten = 0;

	
	//Return a copy of this object.
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}

	// Compares two objects for equality, treating nulls
	public static boolean ifCobolObjEqual(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return o1 == null && o2 == null;
		}
		return o1.equals(o2);
	}

	// Compares this object against the specified object. The 

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Cobol)) {
			return false;
		}
		Cobol c = (Cobol) o;
		
		
		if (!ifCobolObjEqual(program_id, c.program_id)) {
			return false;
		}
		
		if (!ifCobolObjEqual(sectionName, c.sectionName)) {
			return false;
		}
		

		return true;
	}
	
	 @Override
	  public int hashCode() {
	    return super.hashCode();
	  }


	// Return line of commented text from the COBOL program.

	public String getCommentLine() {
		return commentLine;
	}
	

	// Return the name of this COBOL program.

	public String getProgram_ID() {
		return program_id;
	}

	// Return the section name.

	public String getSectionName() {
		return sectionName;
	}

	// Return the division name.

	public String getDivisionName() {
		return divisionName;
	}
	
    // Return the dayDateWritten of this COBOL program.

	public int getDayDateWritten() {
		return dayDateWritten;
	}

	
	// Return the monthWritten of this COBOL program.
	
	public String getMonthDateWritten() {
		return monthDateWritten;
	}
	
	// Return the dayDateWritten of this COBOL program.

	public int getYearDateWritten() {
		return yearDateWritten;
	}
	
	// Set a line of commented text from the COBOL program.

	public void setCommentLine(String commentLine) {
		this.commentLine = commentLine;
	}



	// Set the name of this cobol file.

	public void setProgram_ID(String program_idString) {
		this.program_id = program_idString;
	}

	// Set the dayDateWritten of this COBOL program.

	public void setDayDateWritten(int dayDateWritten) {
		this.dayDateWritten = dayDateWritten;
	}
	
	// Return the monthWritten of this COBOL program.

	public void setMonthDateWritten(String monthDateWritten) {
		this.monthDateWritten = monthDateWritten;
	}
	
	// Set the yearDateWritten of this COBOL program.

	public void setYearDateWritten(int yearDateWritten) {
		this.yearDateWritten = yearDateWritten;
	}
	

	// Set the section name 

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	// Set the division name 

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	// Return a textual description of this cobol type.

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(program_id);
		buf.append(", ");
		buf.append(divisionName);
		buf.append(", ");
		buf.append(sectionName);
		
		return buf.toString();
	}
}
