package BillPughSingleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class MyBillPughSingleton implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyBillPughSingleton()
	{
	}

	private static class createBillPughSingleton {
		public static final MyBillPughSingleton mbp = new MyBillPughSingleton();
	}
	
	public static MyBillPughSingleton getInstance()
	{
		return createBillPughSingleton.mbp;
	}
	public Object readResolve() throws ObjectStreamException
	{
		return MyBillPughSingleton.getInstance();
	}
	//If implementing cloneable make sure to override clone so it cannot return an instance of this class
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException();
	}
}
