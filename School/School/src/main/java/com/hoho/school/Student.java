package com.hoho.school;

public class Student {
	int student_no;
	String name;
	int kor;
	int eng;
	int math;
	int age;
	String adress;
	Student(){
		
	}
	Student(int student_no,String name, int age, String adress){
		this.student_no = student_no;
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	Student(String name, int age, String adress){
		
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	
	Student(String name, int kor, int eng, int math){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	Student(int student_no, String name, int kor, int eng, int math){
		this.student_no = student_no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

}

