package dev.sample.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity //기본 생성자 안 만들면 빨간 줄 생김
public class Major {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MAJOR_ID") //TABLE의 컬럼명을 MAJOR_ID로 변경
	private Long id;
	
	@Column(name="MAJOR_NAME")
	private String majorName; //컬럼명 MAJOR_NAME
	
	//mappedBy : 반대쪽(student) 매핑의 필드 이름을 값으로 지정. Student.java의 major 필드.
	@OneToMany(mappedBy = "major") //학과(1)는 여러 학생들(N)을 보유하고 있음
	private List<Student> students = new ArrayList<>();
	


	public Major() {}
	
	
	public Major(String majorName) {
		super();
		this.majorName = majorName;
	}

	public Major(Long id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	
	public List<Student> getStudents() {
		return students;
	}
	
	
	public void setStudents(List<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + ", students=" + students + "]";
	}
	
}
