package com.ldf.java.jdk8.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import com.ldf.java.app.model.User;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


public class TestLambda {

	public static void main(String[] args) {
//		Arrays.asList("a","b","c").forEach( e->System.out.println(e)); //由编译器给类型
//		Arrays.asList("a","b","c").forEach((String e)->System.out.println(e));//指定类型
//		Arrays.asList("a","b","c").forEach( e->{
//			System.out.println(e);
//			System.out.println(e);
//		});//方法块
//		final  String separator = ","; 
//		Arrays.asList("a","b","c").forEach( e->System.out.print(e+separator));//变量和常量 都可以用
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );
		Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> {
		    int result = e1.compareTo( e2 );
		    return result;
		} );
		User user = new User();
		List<User> us = new ArrayList<>();
		user.setName("ldf");
		user.setPassword("123456");
		user.setId(1L);
		us.add(user);
		User user1 = new User();
		user1.setName("ldf");
		user1.setPassword("12345677");
		us.add(user1);
		user1.setId(1L);
		
		 List<User> personList = new ArrayList<>();
	        
	     // 根据id去重
	        List<User> unique = us.stream().collect(
	                   collectingAndThen(
	                           toCollection(() -> new TreeSet<>(comparing(User::getName))), ArrayList::new)
	           );
	        System.out.println(unique.size()+"\t"+unique.get(0).getPassword());
	}
}
