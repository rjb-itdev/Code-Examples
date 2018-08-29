package logging;
import java.io.IOException;


import org.apache.log4j.*;
public class LoggerClass {
	
	
	private static org.apache.log4j.Logger log = Logger.getLogger(LoggerClass.class);
	
	
	public static void main(String[] argsv) throws IOException{
		log.addAppender(new org.apache.log4j.FileAppender(new org.apache.log4j.TTCCLayout(),"log.txt"));
		
		log.setLevel(Level.DEBUG);
		
		log.debug("Debug Message");
		log.info("Info Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.fatal("Fatal Message");
	}
}
