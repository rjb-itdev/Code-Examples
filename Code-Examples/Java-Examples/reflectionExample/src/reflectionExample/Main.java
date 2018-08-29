package reflectionExample;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Lecturer lecturer = new Lecturer();
		//Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd//MM//yyyy");
		Date date = dateFormat.parse("30//05//1982");
		lecturer.setDob(date);
		inspect(lecturer);
		

	}
	
	
	public static void inspect(Object obj) throws Exception
	{
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor property : properties)
		{
			System.out.println(property.getName());
			Method getter = property.getReadMethod();
			Object value = getter.invoke(obj, new Object[] {});
			System.out.println(" = ");
			System.out.println(value);
		}
	}

}
