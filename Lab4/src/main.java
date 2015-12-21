
public class main {
	public static void main(String[] args) {
		A b = new B();
		A c = new C();
		b.abs();
		c.abs();
		b.notAbs();
		c.notAbs();
	}
}
//o clasa care e abstracta nu poate fi instantiata
//o clasa care nu ii abstracta nu poate contine metoda abstracta