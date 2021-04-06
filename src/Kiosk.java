import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * A class that facilitates the input and output of the program -- The User Interface
 * @author Abdullah Salem, Gent Blaku
 */
public class Kiosk {

	//...
	private static final int FIRSTINDEX = 0;
	private static final int SECONDINDEX = 1;
	private static final int THIRDINDEX = 2;
	private static final int MAXINPUTS = 3;
	
	/**
	 * A method that handles the user input and gives appropriate output.
	 * It creates objects of the other classes and calls their public methods to handle data.
	 */
	public void run() {
		String line;
		boolean Quit = false;
		
		System.out.println("Library Kiosk running.");
		Library library = new Library();
		Scanner input = new Scanner(System.in);
		StringTokenizer tokens;
		String tokensArray[];
		
		while(!Quit){ //Running until the user quits
			line = input.nextLine();
			tokens = new StringTokenizer(line, ",");
			tokensArray = this.tokenizedInput(tokens);
			
			
			
			
			switch(tokensArray[FIRSTINDEX]) 
			{
				case "A": //adding a book
					Date bookToAddDate = new Date(tokensArray[THIRDINDEX]);
					if (bookToAddDate.isValid()) {
						Book bookToAdd = new Book(tokensArray[SECONDINDEX],tokensArray[THIRDINDEX]);
						library.add(bookToAdd);
						System.out.println(tokensArray[SECONDINDEX] + " added to the Library.");
					}
					else {
						System.out.println("Invalid Date!");
					}
					break;
				case "R": //removing a book
					Book bookToBeRemoved = new Book(tokensArray[SECONDINDEX]);
					if (library.remove(bookToBeRemoved)){
						System.out.println("Book#" + tokensArray[SECONDINDEX] + " removed.");
					}
					else{
						System.out.println("Unable to remove, the library does not have this book.");
					}
					break;
				case "O": //checking out a book
					Book bookToBeCheckedOut = new Book(tokensArray[SECONDINDEX]);
					if (library.checkOut(bookToBeCheckedOut)){
						System.out.println("You've checked out Book#" + tokensArray[SECONDINDEX] + ". Enjoy!");
					}
					else {
						System.out.println("Book#" + tokensArray[SECONDINDEX] + " is not available.");
					}
					break;
				case "I"://returning a book
					Book bookToBeReturned = new Book(tokensArray[SECONDINDEX]);
					if (library.returns(bookToBeReturned)){
						System.out.println("Book#" + tokensArray[SECONDINDEX] + " return has completed. Thanks!");
					}
					else {
						System.out.println("Unable to return Book#" + tokensArray[SECONDINDEX] + ".");
					}
					break;
				case "PA"://printing out all the books in the library
					if (library.isempty()) {
						System.out.println("Library catalog is empty!");
					}
					else {
					System.out.println("**List of books in the library.");
					library.print();
					System.out.println("**End of list");
					}
					break;
				case "PD"://printing out all the books in the library by date (ascending)
					if (library.isempty()) {
						System.out.println("Library catalog is empty!");
					}
					else {
					System.out.println("**List of books by the dates published.");
					library.printByDate();
					System.out.println("**End of list");
					}
					break;
				case "PN"://printing out all the books in the library by serial number (ascending)
					if (library.isempty()) {
						System.out.println("Library catalog is empty!");
					}
					else {
					System.out.println("**List of books by the book numbers.");
					library.printByNumber();
					System.out.println("**End of list");
					}
					break;
				case "Q"://Quits the program
					Quit = true;
					break;
				default: //Any other user input
					System.out.println("Invalid command!");
					break;
			}
		}
		
		input.close();
		System.out.println("Kiosk session ended.");
	}
	
	
	
	/**
	 * A helper method that converts proper user input into a more usable form
	 * @param token is a stringTokenizer object containing the segmented user input
	 * @return an array that contains the user input separated appropriately 
	 */
	private String[] tokenizedInput(StringTokenizer token) {
		String tokens[] = new String[MAXINPUTS];
		for (int i=0; i<MAXINPUTS; i++) {
			if (token.hasMoreTokens()) {
				tokens[i] = token.nextToken();
			}
		}
		return tokens;
	}
	
	
}
