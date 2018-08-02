package com.ldf.java.deepCopyClone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable , Cloneable {
	private static final long serialVersionUID = 1L;
	String name;
	String password;
	String[] arrFavor;

	public Person(String name, String password, String[] arrFavor) {
		this.name = name;
		this.password = password;
		this.arrFavor = arrFavor;
	}

	@Override
	protected Object clone() {
		Person person = null;
		try {
			person = (Person) super.clone();
			person.arrFavor = arrFavor.clone();
			return person;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	//必须 序列化 ,否则 会报错
	// 使得序列化student3的时候也会将teacher序列化
	@SuppressWarnings("unchecked")
	public static <T> T deepCopt(T t) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(t);
		// 将当前这个对象写到一个输出流当中，，因为这个对象的类实现了Serializable这个接口，所以在这个类中
		// 有一个引用，这个引用如果实现了序列化，那么这个也会写到这个输出流当中

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return (T) ois.readObject();
		// 这个就是将流中的东西读出类，读到一个对象流当中，这样就可以返回这两个对象的东西，实现深克隆

	}
}

public class Clone {
	public static void main(String[] args) throws Exception {
//		String[] arrFavor = { "basketball", "football" };
		Person person1 = new Person("Jay", "123", null);
		Person person2 = new Person("Jay", "123", null);
		Person person3 = Person.deepCopt(person1);
		// Person p = (Person) person.clone();
		// System.out.println(p.name);
		// System.out.println(p.password);
		// p.name = "Jolin";
		// p.password = "555";
		// p.arrFavor[0] = "valiball";
		// for (String favor : p.arrFavor) {
		// System.out.print(favor + " ");
		// }
		// System.out.println();
		// for (String favor : person.arrFavor) {
		// System.out.print(favor + " ");
		// }
		// System.out.println();
		// System.out.println(p.name);
		// System.out.println(person.name);
		//
		List<Person> pList = new ArrayList<>();
		pList.add(person3);
		for (Person p : pList) {
			p.name = "ldf";
		}

		List<Person> persons = new ArrayList<>();
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		
		List<Person> pList1 = new ArrayList<>();
		pList1 = Person.deepCopt(persons);
		
		for (Person p : pList1) {
			p.name = "abc";
		}
																																																													
		for (Person p : persons) {
			System.out.println(p.name);
		}
		
		
		for (Person p : pList1) {
			System.out.println(p.name);
		}
	}
}
