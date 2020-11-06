package ua.khpi.oop.zanochkyn03;
import java.util.Scanner;

/**
 * Клас Main, який створює данні для обробки класом DeleteWords
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 22/10/20
 */
public class Main 
{
	/**
	 * Метод main, який:
	 * 1) створює рядок для роботи
	 * 2) зчитує данні, що введені з консолі
	 * 3) передає данні до методу findAndDelete класу DeleteWords
	 */
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
        /*System.out.println("Input a string: ");
        String str = in.nextLine();
        System.out.println("Your string: " + str);*/
		String str = "There are five types of schools in the US educational system. They are: kindergarten, elementary school, middle school, high school and private school. Children go to kindergarten when they are 5 years old. They go to elementary school from ages 6 through 11 (1-5 grades), middle school from ages 12 through 14 (6-8 grades) and high school from ages 15 through 19 (9-12 grades).";
        System.out.println("Count letters in word to delete: ");
        int num = in.nextInt();
		DeleteWords.findAndDelete(str,num);
        in.close();
	}
}