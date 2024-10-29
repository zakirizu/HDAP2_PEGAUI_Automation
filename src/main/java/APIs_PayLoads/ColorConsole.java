package APIs_PayLoads;

public class ColorConsole {

	public static void main(String[] args) {
		 // ANSI escape codes for colors
	    final String RESET = "\033[0m";  // Text Reset
	    final String RED = "\033[31m";   // Red
	    final String GREEN = "\033[32m"; // Green
	    final String YELLOW = "\033[33m"; // Yellow
	    final String BLUE = "\033[34m";  // Blue
	    final String PURPLE = "\033[35m"; // Purple
	    final String CYAN = "\033[36m";  // Cyan

	    System.out.println(RED + "This text is red." + RESET);
	    System.out.println(GREEN + "This text is green." + RESET);
	    System.out.println(YELLOW + "This text is yellow." + RESET);
	    System.out.println(BLUE + "This text is blue." + RESET);
	    System.out.println(PURPLE + "This text is purple." + RESET);
	    System.out.println(CYAN + "This text is cyan." + RESET);


	}

}
