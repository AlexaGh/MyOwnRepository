package alexasTrials;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionExample {
	public static void main(String[] args) {

		// Obtain the class object if we know the name of the class

		Class rental = RentCar.class;

		try {

			// get the absolute name of the class
			System.out.println("1");
			String rentalClassPackage = rental.getName();
			System.out.println("Class name is: " + rentalClassPackage);

			System.out.println("2");
			// get the simple name of the class(without package info)
			String rentalClassNoPack = rental.getSimpleName();
			System.out.println("class name without pack is: " + rentalClassNoPack);

			System.out.println("3");
			// get all the constructors of the class
			Constructor[] constructors = rental.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));

			System.out.println("4");
			// get constructor with specific argument
			Constructor constructor = rental.getConstructor(Integer.TYPE);

			System.out.println("5");
			// initializing an object of the RentCar class
			RentCar rent = (RentCar) constructor.newInstance(455);

			System.out.println("6");
			Method[] allmethods = rental.getMethods(); 
			System.out.println("Methods are: " + Arrays.toString(allmethods));
			for (Method method : allmethods) {

				System.out.println("method = " + method.getName());

			}

			System.out.println("7");
			Method[] declaredMethods = rental.getDeclaredMethods();
			System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods) {
				System.out.println("method = " + dmethod.getName());
			}
			System.out.println("8");

			// get method with specific name and parameters
			Method oneMethod = rental.getMethod("computeRentalCost", new Class[] { Integer.TYPE });
			System.out.println("Method is: " + oneMethod);
			// call computeRentalCost method with parameter int
			oneMethod.invoke(rent, 4);

			System.out.println("9");
			// get all the parameters of computeRentalCost
			Class[] parameterTypes = oneMethod.getParameterTypes();
			System.out.println("Parameter types of computeRentalCost() are: " + Arrays.toString(parameterTypes));

			// get the return type of computeRentalCost

			Class returnType = oneMethod.getReturnType();

			System.out.println("Return type is: " + returnType);

			// gets all the public member fields of the class RentCar

			Field[] fields = rental.getFields();

			System.out.println("Public Fields are: ");

			for (Field oneField : fields) {

				// get public field name

				Field field = rental.getField(oneField.getName());

				String fieldname = field.getName();

				System.out.println("Fieldname is: " + fieldname);
				// get public field type
				Object fieldType = field.getType();
				System.out.println("Type of field " + fieldname + " is: " + fieldType);
				// get public field value

				Object value = field.get(rent);

				System.out.println("Value of field " + fieldname + " is: " + value);
			}

			// How to access private member fields of the class
			// getDeclaredField() returns the private field

			Field privateField = RentCar.class.getDeclaredField("type");

			String name = privateField.getName();

			System.out.println("One private Fieldname is: " + name);

			// makes this private field instance accessible

			// for reflection use only, not normal code

			privateField.setAccessible(true);

			// get the value of this private field

			String fieldValue = (String) privateField.get(rent);
			System.out.println("fieldValue = " + fieldValue);

		} catch (NoSuchFieldException e) {

			e.printStackTrace();

		} catch (NoSuchMethodException e) {

			e.printStackTrace();

		} catch (IllegalArgumentException e) {

			e.printStackTrace();

		} catch (IllegalAccessException e) {

			e.printStackTrace();

		} catch (InstantiationException e) {

			e.printStackTrace();

		} catch (InvocationTargetException e) {

			e.printStackTrace();

		}

	}

}
