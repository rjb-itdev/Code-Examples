package delegationExample;

public class Cat {
	private IDelegateSound sound = new MeowSound();
	
	
	public void makeSound()
	{
		this.sound.makeSound();
	}
	public void setSoundBehaviour(IDelegateSound newsound)
	{
		this.sound = newsound;
	}
	
}
