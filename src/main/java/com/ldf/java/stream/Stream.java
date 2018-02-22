package com.ldf.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ldf.java.app.model.User;
import com.sun.javafx.collections.MappingChange.Map;

public class Stream {

	public static void main(String[] args) {
		
		List<User> list = new ArrayList<>();
		list.add(new User("ldf", "12345"));
		list.add(new User("jly","12345"));
		
		list.stream().forEach(ab ->{
			System.out.println(ab.getName());
		});
		
		//Map<String, User> map1 = (Map<String, User>) list.stream().collect(Collectors.toMap(User::getName, c->c, (e1,e2)->e1));
	}
}
