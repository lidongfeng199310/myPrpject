package ldf.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Assert;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class Test {
	
	@org.junit.Test
	public void test1() throws IOException{
		ClassPathResource res = new ClassPathResource("1.txt");
//		InputStream input = res.getInputStream();
//		Properties properties = new Properties();
//		readFileByLines(res.getFilename());
//		properties.load(input);
//		System.out.println(properties.get("abc"));
//		properties.entrySet().iterator().forEachRemaining(Entry ->{
//			System.out.println(Entry.getValue()+"---"+Entry.getKey());
//		});
		Properties properties =  PropertiesLoaderUtils.loadProperties(res);
		System.out.println(properties.get("abc"));
		properties.entrySet().iterator().forEachRemaining(Entry ->{
			System.out.println(Entry.getValue()+"---"+Entry.getKey());
		});
	}
	
	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件
	 */
	public static void readFileByLines(String fileName) {
		File file = new File(fileName);
		BufferedReader reader = null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				System.out.println("line " + line + ": " + tempString);
				line++;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
	}

}
