package nz.ac.massey.sdc.cs.assign1.s14083324;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.spi.LoggingEvent;

public class AppStressTest {
	
	
	private List<LoggingEvent> events;
	private static MemAppender appender;
	
	public AppStressTest() {}
	
	public void Sleep(int time) throws InterruptedException {
		
		Thread.sleep(time);

	}
	public long memoryConsumption()
	{
		Runtime runtime = Runtime.getRuntime();
		
		return runtime.totalMemory();
	}
	public void stressMemAppenderWithLinkedList(int maxSize, int logAmount)
	{
		MemAppender appender = MemAppender.getMemAppender(new LinkedList<LoggingEvent>());
		Logger logger = Logger.getLogger("MemAppender");
		appender.setMaxSize(maxSize);
		logger.addAppender(appender);
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE " + memoryConsumption());
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to add " + logAmount + " logs to memAppender LinkedList is " 
				+ (finishTime - startTime) + " milliseconds");
		
	}
	public void stressMemAppenderArrayList(int maxSize, int logAmount)
	{
		events = new ArrayList<LoggingEvent>();
		Logger logger = Logger.getLogger("MemAppender");
		appender = MemAppender.getMemAppender(events);
		appender.setMaxSize(maxSize);
		logger.addAppender(appender);
		
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE " + memoryConsumption());
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to add " + logAmount + " logs is to the mem appender is " 
													+ (finishTime - startTime) + " milliseconds");
		
	}
	
	public void stressConsoleAppenderSimpleLayout(int maxSize, int logAmount)
	{
		
		Logger logger = Logger.getLogger("Console Appender");
		logger.addAppender(new ConsoleAppender(new SimpleLayout()));
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE " + memoryConsumption()/1024);
		}
		long finishTime = System.currentTimeMillis();
		
		System.out.println("Time to add " + logAmount + " logs is to the console appender is " 
													+ (finishTime - startTime) + " milliseconds");
	}
	public void stressConsoleAppenderMVELLayout(int logAmount)
	{	
		Logger logger = Logger.getLogger("Console Appender");
		logger.addAppender(new ConsoleAppender(new MVELLayout()));
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE :MEMORY_USAGE IS: " + memoryConsumption()/(1024L * 1024L) + "MB");
		}
		long finishTime = System.currentTimeMillis();
		
		System.out.println("Time to add " + logAmount + " logs is to the console  using MVELLAyout is " 
													+ (finishTime - startTime) + " milliseconds");
	}
	
	public void stressFileAppenderSimpleLayout(int logAmount) throws IOException
	{
		Logger logger = Logger.getLogger("File Appender");
		
		String file = File.createTempFile("logsSimpleLayout", "txt").getAbsolutePath();
		logger.addAppender(new org.apache.log4j.FileAppender(new org.apache.log4j.SimpleLayout(),
				file));
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE :MEMORY_USAGE IS: " + memoryConsumption()/(1024L * 1024L) + "MB");
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to add " + logAmount + " logs to the file appender using simpleLayout is " 
													+ (finishTime - startTime) + " milliseconds");
	}
	
	public void stressFileAppenderMVELLayout(int logAmount) throws IOException
	{
		Logger logger = Logger.getLogger("File Appender");
		String file = File.createTempFile("LogsMVELLayout", "txt").getAbsolutePath();
		logger.addAppender(new org.apache.log4j.FileAppender(new MVELLayout(),
				file));
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < logAmount; i++)
		{
			logger.info("STRESS_TEST_MESSAGE :MEMORY_USAGE IS: " + memoryConsumption()/(1024L * 1024L) + "MB");
		}
		long finishTime = System.currentTimeMillis();
		System.out.println("Time to add " + logAmount + " logs to the file appender using MVELLayout is " 
													+ (finishTime - startTime) + " milliseconds");
	}
	
}
/*
 * Reference

	Bytes to Megabytes
	http://www.rgagnon.com/javadetails/java-0540.html
	
	Current Memory in use by an object (Runtime.totalMemory();
	https://docs.oracle.com/javase/6/docs/api/java/lang/Runtime.html#totalMemory()
	

	https://docs.oracle.com/javase/7/docs/api/java/lang/ref/SoftReference.html
	
	All soft references to softly-reachable objects are guaranteed to have been cleared
	before the virtual machine throws an OutOfMemoryError. 
	Otherwise no constraints are placed upon the time at which a soft reference will be cleared or the order
	in which a set of such references to different objects will be cleared. Virtual machine 
	implementations are, however, encouraged to bias against clearing recently-created or 
	recently-used soft references.
	
	The main event list is maintained, softreference to (eventsCache) is used to hold references while
	the main events list is re-organized to fit the newest 
	
	was pointed in the direction of this as at the time I was using a circularfifoqueue from org.apache.commons.collections4
	
*
*/

