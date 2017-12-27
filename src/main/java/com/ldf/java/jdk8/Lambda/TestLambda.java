package com.ldf.java.jdk8.Lambda;

import java.util.Arrays;

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
	}
}
