package nz.ac.massey.cs.sdc.parserss;

import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
/*
 * Name:	Ross Bell
 * ID: 14083324
 */
public class Main {

	public static void main(String[] args) throws JAXBException 
	{
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Rss rss = (Rss) unmarshaller.unmarshal(new File("nzhrsscid_000000005.xml"));

		List<RssItem> l1 = rss.getChannel().getItem();
		
		for (int i = 0; i < l1.size(); i++) 
		{
			RssItem item = (RssItem) l1.get(i);
			for (Object object : item.getTitleOrDescriptionOrLink()) 
			{
				JAXBElement<?> element = (JAXBElement<?>) object;
				QName name = element.getName();
				
				if (name.getLocalPart().equals("title")) 
				{
					System.out.println(name.getLocalPart() + ": " + element.getValue());
				}
				if(name.getLocalPart().equals("link"))
				{
					System.out.println(name.getLocalPart() + ": " + element.getValue());
				}
				if (name.getLocalPart().equals("description")) 
				{
					System.out.println(name.getLocalPart() + ": " + element.getValue() + "\n");
				}
		
			}

		}
	}

}
