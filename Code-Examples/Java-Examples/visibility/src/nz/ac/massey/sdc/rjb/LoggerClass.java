package nz.ac.massey.sdc.rjb;
import java.io.IOException;

import org.apache.log4j.*;

public class LoggerClass {

	private static org.apache.log4j.Logger log = Logger.getLogger(LoggerClass.class);
	
	public static void main(String[] args) throws IOException {
		
		//log.addAppender(new org.apache.log4j.ConsoleAppender(new org.apache.log4j.TTCCLayout()));
		log.addAppender(new org.apache.log4j.FileAppender(new org.apache.log4j.SimpleLayout(),"log.txt"
				));
		log.setLevel(Level.INFO);
		
		
		log.trace("Trace Message");
		log.debug("Debug Message");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.fatal("Fatal Message");
		
	}

}
