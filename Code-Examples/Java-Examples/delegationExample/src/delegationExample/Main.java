package delegationExample;

public class Main {

	public static void main(String[] args) {
		
		Cat cat = new Cat();
		cat.makeSound();
		IDelegateSound newsound = new RoarSound();
		cat.setSoundBehaviour(newsound);
		cat.makeSound();

	}

}
