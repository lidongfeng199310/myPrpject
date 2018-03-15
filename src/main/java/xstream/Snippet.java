package xstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Snippet {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("X-rapido");
		e.setAge("Manager");
		e.setSex("法国");

		XStream xs = new XStream();
		try {
//			FileOutputStream fs = new FileOutputStream("d:/employeedata.txt");
			FileInputStream  fs = new FileInputStream ("d:/employeedata.txt");
			e = (Employee) xs.fromXML(fs, e);

			System.out.println("XML写入成功"+ e.getAge());
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
