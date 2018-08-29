package chainedExceptions;

public class Main {

	public static void main(String[] args) {
		
		try 
		{
			getValue();
		}
		catch (MyException myException)
		{
			System.out.println("Cause = " + myException.getCause());
			
		}
		try
		{
			getIndex();
		}
		catch (MyException myException1)
		{
			System.out.println("Cause = " + myException1.getCause());
		}

	}
	public static int getValue() throws MyException{
		int a = 0;
		try
		{
			a = 10/0;
		}
		catch (ArithmeticException arithmeticException)
		{
			MyException myException = new MyException(arithmeticException.getMessage(),
					arithmeticException);
			throw myException;
		}
		return a;
	}
	
	public static String getIndex() throws MyException
	{	String x = null;
		String[] stringArray = {"10","15"};
		try
		{
			x = stringArray[2];
		}
		catch (IndexOutOfBoundsException indexOutOfBoundsException)
		{
			MyException myException1 = new MyException(indexOutOfBoundsException.getMessage(),
					indexOutOfBoundsException);
			throw myException1;
		}
		
		return x;
	}
}
