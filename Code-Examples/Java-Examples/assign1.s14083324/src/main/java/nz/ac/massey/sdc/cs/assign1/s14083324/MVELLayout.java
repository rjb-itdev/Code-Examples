package nz.ac.massey.sdc.cs.assign1.s14083324;

import org.apache.log4j.spi.LoggingEvent;
import org.mvel2.templates.TemplateRuntime;
import org.apache.log4j.Layout;
import java.util.HashMap;
import java.util.Map;

public class MVELLayout extends Layout{
	
	public void activateOptions() {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public String format(LoggingEvent event) {
		
		Map<String, Object> vars = new HashMap<String, Object>();
		
		String template = "@{t} @{p} @{m} @{c} @{d}@{n}";
		vars.put("t",event.getThreadName());
		vars.put("p",event.getLevel());
		vars.put("m",event.getMessage());
		vars.put("c", event.getLogger());
		vars.put("d", event.toString());
		vars.put("n","\n");
		
		String eventOutput = (String) TemplateRuntime.eval(template, vars);
		return eventOutput;
	}
	
	@Override
	public boolean ignoresThrowable() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
