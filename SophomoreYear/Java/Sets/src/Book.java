
/**
 * This file will provide the getter and setter methods for the Book as well as various other
 * methods to help navigate this file and BookBag class.
 * @author Nick Pieroni
 */

public class Book {

	private String title;
	private String author;
	
	/**
	 * Constructor for object
	 */
	public Book() {
		this.author = null;
		this.title = null;
	}
	
	/**
	 * Constructor for object
	 * @param title			name of title
	 * @param author		name of author
	 */
	public Book(String title, String author) {
		this.setTitle(title);
		this.setAuthor(author);
	}

	/**
	 * This method will get the title of a book
	 * @return title		A string that is the name of the current title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method will set the title to the new title parameter
	 * @param title		A string of a new book title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * get the author String
	 * @return author		what author of the object is
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * sets to a new author
	 * @param author		set the objects author to this string
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * turns the title and author into one string
	 * @return				returns the title joined by " by " and then the author
	 */
	@Override
	public String toString() {
		return title + " by " + author;
	}

	/**
	 * This method will check to see if obj is equal to the current book
	 * @param obj		This will be another book
	 * @return			This will only return true if they are equal. Every other case will be false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Book other = (Book) obj;
		if (!other.equals(obj)) {
			return false;
		}
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		}
		else if (!title.equals(other.title)) {
			return false;
		}
		
		return true;
	}
}
