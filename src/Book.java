/**
 * A Class that manages and stores the information of a book. 
 * This book should hypothetically be owned by a library, so it has functionality to reflect this.
 * @author Abdullah Salem, Gent Blaku
 */
public class Book {
	private String number; //a 5-digit serial number unique to the book
	private String name;
	private boolean checkedOut; //set to true if the book has been checked out
	private Date datePublished;
	private static int availSerial = 10001;
	
	/**
	 * A constructor that creates an object of the Book class.
	 * @param bookName is the name of the book stored as a string
	 * @param publishDate is the date of it's publishing stored as a string
	 */
	public Book(String bookName, String publishDate) {
		this.number = String.valueOf(availSerial);
		this.checkedOut = false;
		this.name   = bookName;
		Date date = new Date(publishDate);
		this.datePublished = date;
		availSerial +=1;
	}
	
	/**
	 * A constructor that creates an incomplete object of the Book class.
	 * This object creates a book object with a specific serial number.
	 * @param serialNumber is the serial number stored in a string
	 */
	public Book(String serialNumber) {
		this.number = serialNumber;
		this.name = null;
		this.checkedOut = false;
		this.datePublished = null;
	}
	
	/**
	 * A method that checks if this book object is on loan.
	 * @return true if the book is available, false if the book is checked out
	 */
	public boolean isCheckedOut () {
		if (this.checkedOut == false) 
			return false;
		else 
			return true;
	}
	
	/**
	 * This method fetches the publish date of this book object.
	 * @return an object of the date class, holding the publish date
	 */
	public Date getDate() {
		return this.datePublished;
	}
	
	/**
	 * A method that fetches the title of the book
	 * @return the name of the book as a string
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * A method that fetches the serial number of this book object
	 * @return the serial number contained in a string
	 */
	public String getNumber() {
		return this.number;
	}
	
	/**
	 * A method that checks out this book object.
	 * A book is checked out as if it is on loan from a library.
	 */
	public void checkOut() {
		if (this.checkedOut == false)
			this.checkedOut = true;
	}
	
	/**
	 * A method that returns this book object.
	 * A book is checked out as if it is being returned to a library.
	 */
	public void returnBook () {
		if (this.checkedOut == true)
			this.checkedOut = false;
	}
	
	/**
	 * Overriding the equals method inherited from the object class.
	 * Compares if this object is equal to another object based on certain criteria.
	 * @param obj is an object that is being compared to this object
	 * @return true if this object is equal to the other object, false if not equal to
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null) {
			return false;
		}
		else if (obj instanceof Book){
			Book other = (Book)obj;
			if (this.number.equals(other.number))
				return true;
		}
		return false;
	}
	
	/**
	 * Overriding the toString method of inherited from the object class.
	 * @returns a string representing this object
	 */
	@Override
	public String toString() {
		if (this.isCheckedOut()) {
			return "Book#" + this.number + "::" + this.name + "::" + this.datePublished + "::is checked out.";
		}
		else{
			return "Book#" + this.number + "::" + this.name + "::" + this.datePublished + "::is available.";
		}
	}
	
}
