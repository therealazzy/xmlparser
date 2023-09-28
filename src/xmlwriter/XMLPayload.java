//@(#)XMLPayload.java	 0.1.0
package xmlwriter;


import cobol.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.logging.Logger;




public class XMLPayload {
	Document doc;
	Element rootElement;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public XMLPayload() {
		try {
		DocumentBuilderFactory dbFactory =
		         DocumentBuilderFactory.newInstance();
		dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // XML parsers should not be vulnerable to XXE attacks
		dbFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
		DocumentBuilder dBuilder = 
		            dbFactory.newDocumentBuilder();
		doc = dBuilder.newDocument();

        rootElement = doc.createElement("cobol");
        doc.appendChild(rootElement);
		
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
		
	}
	
	
	public void addElements(Cobol c) {
		String sectionName = c.getSectionName();
		if (sectionName != null) {
			this.addSectionElement( sectionName );
			

		} else {

		}
		

		String divisionName = c.getDivisionName();
		if (divisionName != null) {
			this.addDivisionElement( divisionName );

		} else {

		}

		String programIDName = c.getProgram_ID();
		if (programIDName != null) {
			this.addProgram_IDElement( programIDName );

		} else {
			
		}
		
		int dayDateWritten = c.getDayDateWritten();
		if(dayDateWritten != 0) {
			this.addDayDateWrittenElement( dayDateWritten );
		}

		String monthDateWritten = c.getMonthDateWritten();
		if (monthDateWritten != null) {
			this.addMonthDateWrittenElement( monthDateWritten );

		} else {

		}


		int yearDateWritten = c.getYearDateWritten();
		if(yearDateWritten != 0) {
			this.addYearDateWrittenElement( yearDateWritten );
		}

	}
	

 	void addProgram_IDElement(String stringElement) {
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("Program-ID");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
	void addCommentLineElement(String stringElement) {
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("comment");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	
 	
 	void addSectionElement(String stringElement) {
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("section");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
 	
 	void addDivisionElement(String stringElement) {

		if(stringElement != null) {
			Element cobolname = doc.createElement("division");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}
	
	void addDayDateWrittenElement(int intElement) {
		
		if(intElement != 0) {
			Element cobolname = doc.createElement("day-date-written");
			String s = "" + intElement;
			cobolname.appendChild(doc.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
 	
	void addMonthDateWrittenElement(String stringElement) {
		
		if(stringElement != null) {
			Element cobolname = doc.createElement("month-date-written");
			cobolname.appendChild(doc.createTextNode(stringElement));
			rootElement.appendChild(cobolname);
		}
	}

	void addYearDateWrittenElement(int intElement) {
		
		if(intElement != 0) {
			Element cobolname = doc.createElement("year-date-written");
			String s = "" + intElement;
			cobolname.appendChild(doc.createTextNode(s));
			rootElement.appendChild(cobolname);
		}
	}
	
	public void writeFile(String filename) {
		try {
		// write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        transformerFactory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
        
        // Output to console for testing
        StreamResult consoleResult = new StreamResult(System.out);
        transformer.transform(source, consoleResult);
        
        StringWriter writer = new StringWriter();
        
        transformer.transform(source, new StreamResult(writer));
        
        String xmlString = writer.getBuffer().toString();
        LOGGER.info(xmlString);
		 } catch (Exception e) {
	         e.printStackTrace();
	     }
	}

}
