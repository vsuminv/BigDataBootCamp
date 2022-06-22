package dev.sample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Entity annotation : '��ü�� ���̺��� ����(mapping)'
 * �ش� class(Book)�� JPA�� �����ϴ� Entity�� �ν��ϰ� ��
 * ������ Table annoatation(@Table)�� �������� ������ �ش� Ŭ������ �̸�(Book)���� ���̺��� ������
 * 
 * Entity Annotation ���� �� ������ ��
 * 1. �⺻������(Default costructor) �ۼ� �ʼ�(JPA�� ��ƼƼ ��ü�� ������ �� �⺻ �����ڸ� Ȱ���ϱ� ������)
 * 2. ���� �����ϴ� �ʵ忡 final�� ����ϸ� �� ��
 */
//@Table
//@Table(name="BOOKS") //books��� �̸��� ���̺��� ������
@Entity //������ �����. table�� entity�� ����� �� �ʹ�
public class Book {
	
	/*
	 * JPA�� �⺻ Ű ���� ����(ũ�� 2����)
	 * 1. ���� �Ҵ� : �⺻Ű�� ���ø����̼ǿ��� ���� �Ҵ�
	 * ex) new Book(1L, "���ΰ� �ٴ�", "��ֿ���")��
	 * 2. �ڵ� ���� : �븮Ű ���(strategy = GenerationType. (1) or (2) or(3))
	 * 		1) IDENTITY : �⺻Ű ������ DB���� ����(MySQL�� auto_increament)
	 * 		2) SEQUECE : DB�� ������ ����� Ȱ��(Oracle���� �ַ� ���, MySQL�� ������)
	 * 		3) TABLE : Ű ������ ������ ���̺� Ȱ��(�������� ���, ��� DB���� ��� ����)
	 * 
	 * -> ���� �Ҵ� ����� ����ϱ� ���ؼ��� @Id�� �ۼ��ϸ��
	 * 
	 * �ڵ����� ����� Ȱ���Ϸ��� @Id + @GeneratedValue�� �߰�, ���ϴ� Ű ���� ������ ����
	 */
	@Id //PK�� ���� ����
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increament���� ����
	private Long id;
	
	/*
	 * Column annotation : ��ü�� �ʵ�� DB�� �÷� ����
	 */
	@Column(name="book_name", nullable = false) //bookName �ʵ�� ���ε� DB ���̺��� �÷����� book_name���� ����
	private String bookName; //camelcase(Java) & snake_case(Db column)
	
	
	private String author; //annotation ���� �ȵ� 
	
	@Temporal(TemporalType.TIMESTAMP) // java.util.data, util.Calender ������ �� ���	
	//TemporalType.DATE : ��¥, DB data Ÿ�԰� ����(ex. 2022-03-23)
	//TemporalType.TIME : �ð�, DB data Ÿ�԰� ����(ex. 09:30:23)
	//TemporalType.TIMESTAMP : ��¥+�ð�, DB timestamp Ÿ�԰� ����(ex. 2022-03-23 09:53:24)
	//TemporalType.DATE : ��¥, DB data Ÿ�԰� ����(ex. 2022-03-23)
	
	private Date pubDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	} 
	
	
	 
	
}