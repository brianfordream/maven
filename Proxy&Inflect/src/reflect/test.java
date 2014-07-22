package reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Properties;

public class test {
	public static void main(String args[]) throws FileNotFoundException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, ClassNotFoundException{
		Properties property=new Properties();
		property.load(new FileInputStream("config.property"));
		String name=property.getProperty("connect");
		System.out.println(name);
		Connect impl=(Connect) Class.forName(name).newInstance();
		Dao dao =new Dao();
		Field field=Dao.class.getDeclaredField("connect");
		field.setAccessible(true);
		field.set(dao, impl);
		Connect connect=dao.getConnect();
		connect.connect();
	}
}
