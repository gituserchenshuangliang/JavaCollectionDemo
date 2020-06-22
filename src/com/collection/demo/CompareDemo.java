package com.collection.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class CompareDemo {
	public static void main(String[] args) {
		Score[] sc = {new Score("Math",23),new Score("Chinese",90),new Score("English",3)};
		Student[] st = {new Student("Cherry",90),new Student("Jack",91),new Student("Amy",60)};
		Teacher[] te = {new Teacher("Jack",23,"Math"),new Teacher("Marry",15,"Math"),new Teacher("Jhon",34,"Math")};
		
		List<Teacher> list = Arrays.asList(te);
		list.sort((s1,s2) -> s1.age-s2.age);
		list.forEach(s -> System.out.println(s));
		
		
		TreeSet<Score> tree = new TreeSet<Score>();
		for (int i = 0; i < sc.length; i++) {
			tree.add(sc[i]);
		}
		tree.forEach(s -> System.out.println(s));
		
		
		TreeMap<Score,String> treeMap = new TreeMap<Score,String>();
		for (int i = 0; i < te.length; i++) {
			treeMap.put(sc[i],"A");
		}
		treeMap.entrySet().forEach(e -> {System.out.println(e.getKey());});
		
		List<Student> s = Arrays.asList(st);
		Collections.sort(s,new Student());
		s.forEach(a -> System.out.println(a));
	}
		
		
}

/*
 * 通过实现Comparable接口来设置对象的排序规则
 */
class Score implements Comparable<Score>{
	public String name;
	public int result;
	public Score(String name,int result) {
		this.name = name;
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Score [name=" + name + ", result=" + result + "]";
	}

	@Override
	public int compareTo(Score o) {
		return -this.name.compareTo(o.name);
	}
}
class Student implements Comparator<Student>{
	public String name;
	public int score;
	public Student(String name,int score) {
		this.name = name;
		this.score = score;
	}
	
	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compare(Student o1, Student o2) {
		return -(o1.score-o2.score);
	}
}

class Teacher {
	public String name;
	public int age;
	public String major;
	public Teacher(String name, int age, String major) {
		super();
		this.name = name;
		this.age = age;
		this.major = major;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", age=" + age + ", major=" + major + "]";
	}
}