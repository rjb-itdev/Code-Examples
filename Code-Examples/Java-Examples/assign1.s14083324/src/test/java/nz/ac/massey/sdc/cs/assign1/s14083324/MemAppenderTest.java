package nz.ac.massey.sdc.cs.assign1.s14083324;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MemAppenderTest {

	private static Logger tLogger;
	private static List<LoggingEvent> events;
	
	private static Layout mvelLayout = new nz.ac.massey.sdc.cs.assign1.s14083324.MVELLayout();
	
	@Before
	public void setUp() throws Exception {
		tLogger = Logger.getRootLogger();
		
		tLogger.setLevel(Level.ALL);
		events = new ArrayList<LoggingEvent>();// new CircularFifoQueue<LoggingEvent>();
		//omg sometimes I am so smart, however today I am not
		
	}

	@After
	public void tearDown() throws Exception {
		
		//MemAppender appender = MemAppender.getMemAppender(events);
		MemAppender.getMemAppender(events).close();
		tLogger = null;
	}
	
	
	@Test
	public void SingletonMemAppenderTest()
	{
		MemAppender appender = MemAppender.getMemAppender(events);
		MemAppender appender2 = MemAppender.getMemAppender(events);
		assertEquals(appender, appender2);
	}
	
	
	@Test
	public void MemAppenderSetLevelsTest()
	{
		tLogger.setLevel(Level.DEBUG);
		tLogger.addAppender(MemAppender.getMemAppender(events));
		
		tLogger.debug("TEST");
		tLogger.warn("TEST");
		tLogger.trace("TEST");
		int expected = 2, actual = MemAppender.getMemAppender(events).getCurrentLogs().size();
		assertEquals(expected, actual);
		
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void unmodifiableLogEventsListTest() throws UnsupportedOperationException
	{
		List<LoggingEvent> unmodifiableList = MemAppender.getMemAppender(events).getCurrentLogs();
		unmodifiableList.add(null);
		
		
	}
	@Test
	public void CurrentSizeOfMemAppenderEventsListTest()
	{
		
		//test instance here
		MemAppender.instance.setMaxSize(10);
		tLogger.addAppender(MemAppender.getMemAppender(events));
		for(int i = 0; i < 30; i++)
		{
			tLogger.debug("TEST_DEBUG_MESSAGE");
		}
		long expected, actual = MemAppender.getMemAppender(events).getDiscardedLogCount();
		expected = 20;
		assertEquals(expected,actual);
	}
	//I Like Pascal Case better then camelCase.
	@Test
	public void mvelLayoutToConsoleTest()
	{	
		tLogger.addAppender(new org.apache.log4j.ConsoleAppender(
							new nz.ac.massey.sdc.cs.assign1.s14083324.MVELLayout(),"System.out"));
		tLogger.debug("STRING_FORMAT_TEST_METHOD");
	}
	@Test
	public void stringFormatLayoutDebugFromMemAppender()
	{
		events.clear();
		tLogger.addAppender(MemAppender.getMemAppender(events));
		tLogger.debug("StringFormatLayoutDebugFromMemAppender");
		String expected, actual = MemAppender.getMemAppender(events).getCurrentLogs().get(0).getRenderedMessage();
		expected = ("StringFormatLayoutDebugFromMemAppender");
		assertEquals(expected, actual);
	}
	@Test
	public void mvelLayoutToFileAppenderTest() throws IOException
	{
		String path = File.createTempFile("tempLogs", "txt").getAbsolutePath();
		tLogger.addAppender(new FileAppender(mvelLayout, path));
		tLogger.debug("DEBUG_STATEMENT");
		
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String actual;
		actual = br.readLine();
		//This could actually change I think between class loaders. maybe #sometimes right
		//expected = "main DEBUG DEBUG_STATEMENT org.apache.log4j.spi.RootLogger@45c8e616 org.apache.log4j.spi.LoggingEvent@2133c8f8";
		assert(actual.contains("DEBUG_STATEMENT"));
		br.close();
		fr.close();
	}
}