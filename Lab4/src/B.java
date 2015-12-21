
//concrete, not abstract
public class B extends A{
	

	@Override
	public void abs() {
		// TODO Auto-generated method stub
		System.out.println("abs B");
	}
	
	
	@Override
	public void notAbs() {
		super.notAbs();
		System.out.println("Not abs - A");
	}
}
