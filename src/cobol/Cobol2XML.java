// @(#)Cobol2XML.java	 0.1.0
 

package cobol;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import logger.*;
import parse.*;
import parse.tokens.*;
import xmlwriter.*;

public class Cobol2XML {
	/**
	 * @param args
	 * @throws Exception
	 */
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    
    
    public static void main(String[] args) throws Exception {

        try {
            MyLogger.setup();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Cobol2XML V0.1.0");

        XMLPayload xmlp = new XMLPayload();
		InputStream is = null;
		BufferedReader r = null;
		try {
			is = new FileInputStream(args[0]);
			try {
				r = new BufferedReader(new InputStreamReader(is));

				Tokenizer t = CobolParser.tokenizer();
				Parser p = CobolParser.start();
				
				//iterate through the source code
				while (true) {
					String s = r.readLine();
					if (s == null) {
						break;
					}
					t.setString(s);
					Assembly in = new TokenAssembly(t);
					Assembly out = p.bestMatch(in);
					Cobol c = new Cobol();
					c = (Cobol) out.getTarget();
					
					if(c != null)
						xmlp.addElements(c); 
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if(r != null) {
						r.close(); 
					}
				}
		  } catch (Exception e) {
		    e.printStackTrace();
		  } finally {
			xmlp.writeFile(args[1]);
			if(is != null) {
				is.close(); 
			}		
		  } 

	} 
}


