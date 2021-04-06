/**
 * A class that simulates the functionality of a library
 * @author Abdullah Salem, Gent Blaku
 */
public class Library {
	private Book[] books; // array-based implementation of the bag data structure
	private int numBooks; // the number of books currently in the bag
	private static final int FOUR = 4; //rename?
	private static final int NOTFOUND = -1;
	
	/**
	 * A constuctor that creates an object of the library class.
	 * The library has a beginning capacity of four and no books.
	 */
	public Library() {
		books = new Book[FOUR];
		numBooks = 0;
	} //default constructor to create an empty bag
	
	
	/**
	 * A method that searches through the library for a specific book
	 * @param book that is being searched for
	 * @return the index of the book in the array if found, NOTFOUND if it is not found
	 */
	private int find(Book book) {
		for (int i=0; i<numBooks; i++) {
			if ( books[i].equals(book) ) {
				return i;
			}
		}
		return NOTFOUND;
	} // helper method to find a book in the bag
	
	
	/**
	 * A method that increases the capacity of the library by four after reaching it's limit
	 */
	private void grow() {
		Book[] booksClone;
		booksClone = new Book[books.length];
		
		for (int i=0; i<books.length; i++) {
			booksClone[i] = books[i];
		}
		
		books = new Book[books.length+FOUR];
		
		for (int i=0; i<booksClone.length; i++) {
			books[i] = booksClone[i];
		}
		
		
	} // helper method to grow the capacity by 4
	
	/**
	 * A helper method that finds the first available slot in the array.
	 * @return the index of the slot if found, NOTFOUND if no spots are available
	 */
	private int firstOpenSlot() {
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				return i;
			}
		}
		return NOTFOUND;
	}
	
	/**
	 * A helper method that closes any gaps formed when removing a book from the array
	 * @param empytySlot is the slot that has to be closed
	 */
	private void shiftUp(int empytySlot) {
		for (int i = empytySlot; i < books.length-1; i++) {
			books[i] = books[i+1];
			books[i+1] = null;
		}
	}
	
	/**
	 * A helper method that sorts the books in the array by their publishing date(ascending).
	 */
	private void sortByDate() {
		int oldestBookIndex;
		for (int i = 0; i < numBooks -1; i++){
			oldestBookIndex = i;
			for (int j = i+1; j < numBooks; j++) {
				if (books[j].getDate().isOlderThan(books[oldestBookIndex].getDate())) {
					oldestBookIndex = j;
				}
				else if (books[j].getDate().equals(books[oldestBookIndex].getDate())) {
					if (books[j].getName().compareTo(books[oldestBookIndex].getName()) < 0) {
						oldestBookIndex = j;
					}
				}
			}
			Book tempBookPointer = books[i];
			books[i] = books[oldestBookIndex];
			books[oldestBookIndex] = tempBookPointer;
		}
	}

	/**
	 * A helper method that sorts the book in the array by their serial number(ascending).
	 */
	private void sortByNumber() {
		int smallestNumberIndex;
		for (int i = 0; i < numBooks -1; i++){
			smallestNumberIndex = i;
			for (int j = i+1; j < numBooks; j++) {
				if (books[j].getNumber().compareTo(books[smallestNumberIndex].getNumber()) < 0) {
					smallestNumberIndex = j;
				}
			}
			Book tempBookPointer = books[i];
			books[i] = books[smallestNumberIndex];
			books[smallestNumberIndex] = tempBookPointer;
		}
	}

	
	/**
	 * A method that adds an object of the book class into the library's array
	 * @param book is the object meant to be added
	 */
	public void add(Book book) {
		int firstOpenSlot = this.firstOpenSlot();
		if (firstOpenSlot != NOTFOUND) {
			books[firstOpenSlot] = book;
		}
		else {
			this.grow();
			firstOpenSlot = this.firstOpenSlot();
			books[firstOpenSlot] = book;
		}
		numBooks++;
	}
	
	/**
	 * A method that removes an object of the book class from the library's array.
	 * @param book is the object meant to be removed
	 * @return true if successfully removed, false otherwise
	 */
	public boolean remove(Book book) {
		int bookToBeRemoved = find(book);
		if (bookToBeRemoved == NOTFOUND) {
			return false;
		}
		books[bookToBeRemoved] = null;
		this.shiftUp(bookToBeRemoved);
		numBooks -= 1;
		return true;
	}
	
	/**
	 * A method that checks out a book from the library's array
	 * @param book that is meant to be checked out
	 * @return true if successfully checked out, false otherwise
	 */
	public boolean checkOut(Book book) { 
		int bookToBeCheckedOut = find(book);
		if (bookToBeCheckedOut == NOTFOUND) {
			return false;
		}
		if (books[bookToBeCheckedOut].isCheckedOut() == true) {
			return false;
		}
		else {
			books[bookToBeCheckedOut].checkOut();
			return true;
		}
	}//true if checking out is successful
	
	
	/**
	 * A method that returns a book from the library's array
	 * @param book that is meant to be returned
	 * @return true if successfully returned, false otherwise
	 */
	public boolean returns(Book book) { 
		int bookToBeCheckedOut = find(book);
		if (bookToBeCheckedOut == NOTFOUND) {
			return false;
		}
	
		if (books[bookToBeCheckedOut].isCheckedOut() == false) {
			return false;
		}
		else {
			books[bookToBeCheckedOut].returnBook();
			return true;
		}
	}
	
	/**
	 * A method that checks if the library's array is empty of books
	 * @return true if empty, false otherwise
	 */
	public boolean isempty() {
		if (numBooks ==0)
			return true;
		else 
			return false;
	}
	
	/**
	 * A method that prints the contents of the library's array in a list
	 */
	public void print() {
		for (int i = 0; i < numBooks; i++) {
			if (books[i] != null) {
				System.out.println(books[i].toString());
			}
		}
	} //print the list of books in the bag
	
	/**
	 * A method that prints the contents of the library's array in a list ordered by date(ascending)
	 */
	public void printByDate() {
		this.sortByDate();
		this.print();
	} //print the list of books by datePublished (ascending)
	
	/**
	 * A method that prints the contents of the library's array in a list ordered by serial number(ascending)
	 */
	 public void printByNumber() { 
		 this.sortByNumber();
		 this.print();
	 } //print the list of books by number (ascending)
}
