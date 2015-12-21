//intr-o calasa abstracta pot sa ma atribute, unlike in interfaces
//pot am atribute primvate pentru metodele care nu sunt abstracte de aici

public abstract class A {
	public int x;

	public abstract void abs();

	public void notAbs() {
		System.out.println("Not abs - A");
	}
}
