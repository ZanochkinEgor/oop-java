package ua.khpi.oop.zanochkyn04;
import java.util.Scanner;

/**
 * Клас Main, який створює данні для обробки класом DeleteWords.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 22/10/20
 */
public class Main 
{
	/**
	 * Метод main, який:
	 * 1) виводить додаткову інформацію, якщо програма запускається з параметрами;
	 * 2) викликає метод Menu.
	 */
	public static void main(String[] args) 
	{
		boolean debug = false;
		for (String string : args) 
		{
			if (string.equals("-help") || string.equals("-h")) 
				System.out.println("Author: Zanochkyn Yehor\nGroup KIT-119a\nTask: Remove from the text all words of a given length that begin with a consonant letter.\n");
			if (string.equals("-debug") || string.equals("-d")) 
				debug = true;
		}
		Menu(debug);
	}
	/**
	 * Метод Menu, який є меню програми;
	 */
	public static void Menu(boolean debug) 
	{
		String str = new String("There are five types of schools in the US educational system. They are: kindergarten, elementary school, middle school, high school and private school. Children go to kindergarten when they are 5 years old. They go to elementary school from ages 6 through 11 (1-5 grades), middle school from ages 12 through 14 (6-8 grades) and high school from ages 15 through 19 (9-12 grades).");
		boolean endCheck = true;
		int count = 0;
		StringBuilder sb = new StringBuilder(str);
		Scanner in = new Scanner(System.in);
		while (endCheck) 
		{
			System.out.println("1. Enter new text");
			System.out.println("2. Show current text");
			System.out.println("3. Delete words that start with a consonant");
			System.out.println("4. Exit");
			System.out.println("Enter your option:");
			int option = in.nextInt();
			switch (option) 
			{
			case 1:
				sb.delete(0, sb.length());
				System.out.println("\nEnter new text: ");
				sb.append(in.nextLine());
				sb.append(in.nextLine());
				System.out.println();
				break;
			case 2:
				System.out.println("\n" + sb + "\n");
				break;
			case 3:
				System.out.println("\nEnter count of digit in word to delete:");
				count = in.nextInt();
				DeleteWords.findAndDelete(sb.toString(), count, debug);
				System.out.println();
				break;
			case 4:
				endCheck = false;
				in.close();
				System.out.println("\nEnd of work");
				break;
			default:
				System.out.println("\nWrong command\n");
				break;
			}
		}
	}
}