import java.util.Scanner;
import java.util.HashMap;

public class AnswerNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();
		int num = 0;
		String word = "";
		String choice = "Y";
		
		myMap.put(0, "zero");
		myMap.put(1, "one");
		myMap.put(2, "two");
		myMap.put(3, "three");
		myMap.put(4, "four");
		
		while (choice.equalsIgnoreCase("Y")) {
			System.out.print("Prompt: Enter a number: ");
			num = sc.nextInt();
			if (myMap.containsKey(num)) {
				System.out.println("Response: You entered " + myMap.get(num) + ".");
			} else {
				System.out.print("The number is not yet in the map. Please type it in English. ");
				word = sc.next();
				sc.nextLine();
				myMap.put(num, word);
				System.out.println("Response: You entered " + myMap.get(num) + ".");
			}
			System.out.print("Would you like to try again? Y/N ");
			choice = sc.next();
			sc.nextLine();
			System.out.println();
		}
		System.out.println("Thank you for using the App.");
	}
}
