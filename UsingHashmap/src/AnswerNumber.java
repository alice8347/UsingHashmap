import java.util.Scanner;
import java.util.HashMap;
import java.io.*;

public class AnswerNumber {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> myMap = new HashMap<String, String>();
		
		String fileName = (System.getProperty("user.dir") + File.separatorChar + "myFile.txt");

		String num = "";
		String word = "";
		String choice = "Y";
		
		try {
			while (choice.equalsIgnoreCase("Y")) {
				BufferedReader reader = new BufferedReader(new FileReader(fileName));
				
				String readWholeLine = reader.readLine();

				while (readWholeLine != null) {
					String line[] = new String[2];
					line = readWholeLine.split("\t");
					String key = line[0];
					String value = line[1];
					myMap.put(key, value);
					readWholeLine = reader.readLine();
				}
				reader.close();
	
	 			System.out.print("Prompt: Enter a number: ");
	 			num = sc.nextLine();
	 			if (myMap.containsKey(num)) {
	 				System.out.println("Response: You entered " + myMap.get(num) + ".");
	 			} else {
	 				System.out.print("The number is not yet in the map. Please type it in English. ");
	 				word = sc.nextLine();
	 				myMap.put(num, word);
	 				System.out.println("Response: You entered " + myMap.get(num) + ".");
	 				
	 				PrintWriter writer = new PrintWriter(new File(fileName));
	 				for (String key : myMap.keySet()) {
	 					writer.println(key + "\t" + myMap.get(key));
	 				}
	 				writer.close();
	 			}
	 			System.out.print("Would you like to try again? Y/N ");
	 			choice = sc.next();
	 			sc.nextLine();
	 			System.out.println();
	 		}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Thank you for using the App.");
		}
	}
}