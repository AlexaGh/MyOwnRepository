
public class Teacher implements Sailor{
	
	public int test;
	
	@Override
	public void saySomething() {
		System.out.println("I am a teacher.");
		
	}

	@Override
	public void yell(String y) {
		System.out.println("I wich");
	}

}
