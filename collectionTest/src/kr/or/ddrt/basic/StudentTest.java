package kr.or.ddrt.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 
 *       Student클래스를 만든다.
 *       이 클래스의 생성자에서는 학번,이름,국어점수,영어점수,수학점수만 인수로 받아서
 *       초기화 처리를 한다.
 *       
 *       이 Student객체는 List에 저장하여 관리한다.
 *       
 *       List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 *       총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준도
 *       구현하여 정렬된 결과를 출력하시오.(클래스명 : SortByTotal)
 *       
 *       (등수는 List에 전체 데이터가 추가된 후에 구해서 저장한다.)
 * */
public class StudentTest {
	
	public void setGrade(List<Student> studentList) {
		for(Student std1:studentList) {
			int grade = 1; //처음에는 1등으로 초기화해 놓고 시작한다.
			
			for(Student std2: studentList) { // 비교 대상을 나타내는 반복문
				if(std1.getSum() <std2.getSum()) {
					grade++;
				}
			}
			//구해진 등수를 Student객체의 rank변수에 저장한다.
			std1.setGrade(grade);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		StudentTest test = new StudentTest();
		students.add(new Student(400, "홍길동", 80, 70, 90));
		students.add(new Student(100, "이순신", 60, 90, 40));
		students.add(new Student(200, "강감찬", 50, 100, 60));
		students.add(new Student(300, "일지매", 90, 40, 20));
		
		test.setGrade(students);
		Collections.sort(students);
		for(Student std: students) {
			std.setSum(0);
			System.out.println(std);
		}
		System.out.println("==============================================");
		Collections.sort(students,new SortByTotal());
		System.out.println("총점의 내림차순 정렬후");
		for(Student std:students) {
			System.out.println(std);
		}

	}

}

class Student implements Comparable<Student>{
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int grade;
	
	public Student(int id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum += this.kor+this.eng+this.math;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", grade=" + grade + "]";
	}

	@Override
	public int compareTo(Student student) {
		
		return this.getId()-student.getId();
	}
}

class SortByTotal implements Comparator<Student>{
	public int compare(Student std1, Student std2) {
		if(std1.getSum() == std2.getSum()) {
			return std1.getName().compareTo(std2.getName());
		}else {
			return new Integer(std1.getSum()).compareTo(std2.getSum())*-1;
		}
		
	}	
}