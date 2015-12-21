package utilities;

public class Functions {

	public  boolean isPrime(int x) {

		for (int d = 2; d < x / 2; d++) {
			if (x % d == 0)
				return false;
		}
		return true;
	}

	public  boolean isEven(int x) {
		if (x % 2 == 0)
			return true;
		else
			return false;
	}

	public  int[] checkSum(int userInput) {
		int nr = 2;
		int array[] = new int[2];
		while (nr < userInput) {
			if (isPrime(nr) && isPrime(userInput - nr)) {
				array[0] = userInput - nr;
				array[1] = nr;
				return array;
			}
			nr++;
		}
		return array;
	}
}
