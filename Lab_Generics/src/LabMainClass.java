import java.util.ArrayList;

public class LabMainClass {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(8);
		list.add(7);
		list.add(25);
		list.add(30);
		// list.add("Something");

		/*
		 * for(int i=0; i<list.size();i++){ System.out.println(list.get(i)); }
		 */

		System.out.println("int:");
		for (int o : list) {
			System.out.println(o);
		}
		System.out.println("Integer:");
		for (Integer o : list) {
			System.out.println(o);
		}

		GenC<String> x = new GenC<String>("");
		x.getObj();
		
	}
}
