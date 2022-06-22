package com.book.model;


public class Book {
	private int rank;
	private int book_id;
	private String title;
	private String author;
	private String field;
	private int rental_status;
	
	public Book(String title) {
		this.title = title;
		
	}
	public Book(String title,int retal_status) {
		this.title = title;
		
	}
	
	public Book(int rank, int book_id, String title, String author, String field,
			int rental_status) {
		super();
		this.rank = rank;
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.field = field;
		this.rental_status = rental_status;
	}
	
	public  Book(Builder builder) {
		this.rank = builder.rank;
		this.book_id = builder.book_id;
		this.title = builder.title;
		this.author = builder.author;
		this.field = builder.field;
		this.rental_status = builder.rental_status;
		
	}
	public static class Builder{

		private int rank;
		private int book_id;
		private String title;
		private String author;
		private String field;
		private int rental_status;
		
		public Builder(int rank) {
			this.rank = rank;
		}
		
		public Builder book_id(int book_id) {
			this.book_id = book_id;
			return this;
		}
		
		public Builder title(String title) {
			this.title = title;
			return this;
		}
		
		public Builder author(String author) {
			this.author = author;
			return this;
		}
		
		public Builder field(String field) {
			this.field = field;
			return this;
		}
		
		public Builder rental_status(int rental_status) {
			this.rental_status = rental_status;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getRental_status() {
		return rental_status;
	}

	public void setRental_status(int rental_status) {
		this.rental_status = rental_status;
	}

	@Override
	public String toString() {
		return "Book [rank=" + rank + ", book_id=" + book_id + ", title=" + title + ", author=" + author + ", field="
				+ field + ", rental_status=" + rental_status + "]";
	}
	
	
	
	

}
