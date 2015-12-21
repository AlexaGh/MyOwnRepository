package alexas;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) {

		Class<?> noparams[] = {};
		Class[] paramString = new Class[1];
		paramString[0] = String.class;
		
		try{
			Class<?> cls = Class.forName("alexas.ReflectionTest");
			Object obj = cls.newInstance();
			
			Method method = cls.getDeclaredMethod("getCompany", noparams);
			method.invoke(obj);
			
			method = cls.getDeclaredMethod("getCompanyName", paramString);
			method.invoke(obj, new String("Google"));
 
			method = cls.getDeclaredMethod("getCompanyPhone", paramString);
			method.invoke(obj, new String("408.111.1111"));
		}  catch (Exception ex){
			ex.printStackTrace();
		}
	}
}
