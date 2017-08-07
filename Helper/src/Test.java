import com.rzx.proper.PropertiesUtil;

public class Test {
 public static void main(String[] args) {
//	System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
	 	PropertiesUtil proName=new PropertiesUtil("test.properties");
		System.out.println(proName.getProperties().getProperty("initYears2").trim());
}
}
