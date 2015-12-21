import java.io.*;

public class MainClass {
	public static void main(String[] args) {
		String fileName = "temp.txt";
		String line = null;
		try {
			FileReader fileReader = new FileReader(fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		try {
			f(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void f(int i) throws IOException, IndexOutOfBoundsException {
		if (i == 0) {
			throw new IOException();
		} else if (i == 1) {
			throw new IndexOutOfBoundsException();
		}
	}
}
