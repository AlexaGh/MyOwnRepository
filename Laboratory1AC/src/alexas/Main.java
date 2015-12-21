package alexas;

import java.util.Scanner;

import javax.swing.JOptionPane;

import utilities.Functions;

public class Main {
	public static void main(String[] args) {

		Functions f = new Functions();
		//System.out.println("Plese enter an integer");
		
		/*Scanner userInput = new Scanner(System.in);
		int number = userInput.nextInt();

		System.out.println("Is the number prime? " + f.isPrime(number));
		System.out.println("Is the number even? " + f.isEven(number));
		if (f.isEven(number)) {
			int array[] = new int[2];
			array = f.checkSum(number);
			System.out.println("First number " + array[0] + " Second number: " + array[1]);
		}*/

		String numberV = JOptionPane.showInputDialog("Enter your lucky number: ");
		int numV = Integer.parseInt(numberV);

		if (f.isEven(numV)) {
			int array[] = new int[2];
			array = f.checkSum(numV);
			// System.out.println("First number " + array[0] + " Second number:
			// " + array[1]);
			JOptionPane.showMessageDialog(null, "First number " + array[0] + " Second number: " + array[1]);
		} else {
			JOptionPane.showMessageDialog(null, "You must insert an even number");
		}
	}

}
