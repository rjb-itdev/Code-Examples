package delegationExample;

public class MeowSound implements IDelegateSound {

	@Override
	public void makeSound() {
		System.out.println("Meow");
	}

}
