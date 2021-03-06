package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Entity

public class Book {
	
	public Book() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Book_ID") //TABLE의 컬럼명을 MAJOR_ID로 변경
	Long id;
	
	@Column(name="Book_Name") 
	String name;
	@Column(name="Book_author")
	String author;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + "]";
	} 
	
	
}
