import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
	public static void main(String[] args) throws GeneralSecurityException{
		
		Map<String,String> map = new HashMap() ;
		map.put("sss", "aaaa") ;
		map.put("sss2", "bbbbb") ;
		
		
		for(Map.Entry<String,String> m: map.entrySet()){
			System.out.println("key:"+m.getKey()+"   value:"+m.getValue());
		}
		
		try {
			List list = (List) Class.forName("java.util.ArrayList").newInstance() ;
			
			Class classObj = Class.forName("Test") ;
			
			
			String name = classObj.getName() ;
			
			Method[] method = classObj.getMethods() ;
			
			System.out.println(method[1].getName()) ;
			System.out.println(method[1].getParameters()) ;
			
			
			System.out.println(list.get(0)) ;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
