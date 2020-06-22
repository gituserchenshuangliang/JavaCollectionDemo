package com.collection.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 集合学习
 * @author Cherry
 * 2020年4月6日
 */
public class CollectionDemo {
	public static void main(String[] args) {
		a();
	}
	
	//TreeMap和TreeSet传入Comparator自定义排序
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void a() {
		List list = new ArrayList(10);
		List linked = new LinkedList();
		Map map = new HashMap(10);
		Set set = new HashSet(10);
		Map treeMap = new TreeMap<Integer,String>((i1,i2) -> -(i1-i2));
		Set<String> treeSet = new TreeSet<String>((s1,s2) -> s1.compareTo(s2));
		treeMap.put(1,"A");
		treeMap.put(4,"D");
		treeMap.put(3,"C");
		treeMap.put(2,"B");
		treeSet.add("A");
		treeSet.add("D");
		treeSet.add("C");
		treeSet.add("B");
		Set<Map.Entry<Integer, String>> entry = treeMap.entrySet();
		for (Map.Entry<Integer, String> m : entry) {
//			System.out.println(m.getKey()+"==="+m.getValue());
		}
//		entry.forEach(m -> System.out.println(m.getKey()+"==="+m.getValue())); 
		
		for (String s : treeSet) {
//			System.out.println(s);
		}
//		treeSet.forEach(v -> System.out.println(v));
		//Properties集合可以读取.properties文件
		Properties props = System.getProperties();
		try(FileOutputStream fos = new FileOutputStream(new File("src/com/demo/sys.properties"));
			FileInputStream fis = 	new FileInputStream(new File("src/com/demo/demo.properties"))	){
//			String p = props.toString();
			StringBuilder p = new StringBuilder();
			props.entrySet().forEach(m -> {p.append(m.getKey()).append("=").append(m.getValue()).append("\n");});
			fos.write(p.toString().getBytes());
			//读取demo.properties文件到Properties集合中
			props.clear();
			props.load(fis);
			props.entrySet().forEach(m -> System.out.println(m.getKey()+"="+m.getValue()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
