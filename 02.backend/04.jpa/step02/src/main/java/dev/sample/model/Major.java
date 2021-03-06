package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //기본 생성자 안 만들면 빨간 줄 생김
public class Major {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MAJOR_ID") //TABLE의 컬럼명을 MAJOR_ID로 변경
	private Long id;
	
	@Column(name="MAJOR_NAME")
	private String majorName; //컬럼명 MAJOR_NAME
	
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
	
	
	
}
