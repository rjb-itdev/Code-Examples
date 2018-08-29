package exceptions;

public class SingletonException extends Exception {
	public SingletonException(String message)
	{
		super(message);
	}
	public SingletonException(Throwable throwable)
	{
		super(throwable);
	}
	public SingletonException(String message, Throwable throwable)
	{
		super(message,throwable);
	}
}
