package delegationExample;

public class RoarSound implements IDelegateSound {

	@Override
	public void makeSound() {
		System.out.println("Roar");
		
	}
	
}
