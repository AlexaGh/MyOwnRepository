import java.util.Random;

public class Main {
	/*public static void main(String[] args) {
		
		

		//final int i = 7;
		int[][] array = makeArray(4);
		for(int i = 0 ; i< array.length;i++){
			for(int j=0; j< array[i].length; j++){
				System.out.println(array[i][j]);
				
			}
		}
		

		//final C obj = new C();
		/*
		 * obj.x = 5; System.out.println(obj.x); obj.x = 10;
		 */
		/*Sailor t = new Teacher();
		t.saySomething();
		t = new Student();
		t.saySomething();*/
		// homework, ceva similar fara interfata si fara superclass and extands etc 
		//Java Collections
		/*final int MAX = 20;
		Sailor[] sailors = new Sailor[MAX];
		for (int j = 0; j < MAX; j++) {
			int r = new Random().nextInt(3);
			if (r == 0) {
				sailors[j] = new Teacher();
			} else if (r == 1) {
				sailors[j] = new Student();
			} else if (r == 2) {
				sailors[j] = new Jani();
			}

		}
		for (Sailor s : sailors) {
			s.saySomething();
		}

	}*/
	/*}
	 static int[][] makeArray( int size) 
	{  
	   int[][] triArray = new int[size] [];
	   int val=1;
	   for( int i = 0; i < triArray.length; i++ ) 
	   {  
	      triArray[i] = new int[i+1];
	      for( int j=0; j < triArray[i].length; j++ )
	        triArray[i][j] = val++;
	   }
	   return triArray;
	}
	
}*/
	
	public static void main( String args[] )
	{  
	   int a = 5;
	   System.out.println( cube( a ) );
	}
	static int cube( int theNum )
	{
	   return theNum * theNum * theNum;
	}
}
