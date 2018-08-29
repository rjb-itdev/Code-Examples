package nz.ac.massey.sdc.cs.assign1.s14083324;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class MemAppender extends AppenderSkeleton{

	private List<LoggingEvent> events;
	private List<SoftReference<LoggingEvent>> eventCache = new ArrayList<SoftReference<LoggingEvent>>();
	private int maxSize = 100; // Default
	private int discardedLogCount = 0;
	public static MemAppender instance = null;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int size) {
		this.maxSize = size;
	}
	
	
	protected MemAppender() {
		this(new ArrayList<LoggingEvent>());
	}

	

	protected MemAppender(ArrayList<LoggingEvent> events) {
		this.events = events;
	}

	public static MemAppender getMemAppender(List<LoggingEvent> events) {
		if (instance == null) {
			instance = new MemAppender();
			return instance;
		}
		return instance;
	}

	public List<LoggingEvent> getCurrentLogs() {
		List<LoggingEvent> currentLogs = new ArrayList<LoggingEvent>();
		for (SoftReference<LoggingEvent> le : eventCache) {
			if(le.get() != null)
			{
				currentLogs.add(le.get());
			}
		}
		currentLogs.addAll(events);
		return Collections.unmodifiableList(currentLogs);
	}

	public void close() {
		events.clear();
	}

	public boolean requiresLayout() {
		// TODO Auto-generated method stub
		return false;
	}

	

	public int getDiscardedLogCount() {
		return this.discardedLogCount;
	}

	@Override
	protected void append(LoggingEvent arg0) {
		int count = 0;
		if (events.size() == this.maxSize) {
			eventCache.add(new SoftReference<LoggingEvent>(events.remove(0)));
			discardedLogCount += 1;
		}
		count += 1;
		events.add(arg0);
		
		
	}

}


//https://docs.oracle.com/javase/7/docs/api/java/lang/ref/SoftReference.html
