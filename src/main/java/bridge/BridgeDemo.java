package bridge;

public class BridgeDemo {
	public static void main(String[] args) {
		Movie movie = new Movie();
		movie.setClassification("Action");
		movie.setTitle("John Wick");
		movie.setRunTime("2:15");
		movie.setYear("2014");

		Formatter printFormater = new PrintFormatter();
		Printer moviePrinter = new MoviePrinter(movie);

		String printedMaterial = moviePrinter.print(printFormater);

		System.out.println(printedMaterial);
	}
}
