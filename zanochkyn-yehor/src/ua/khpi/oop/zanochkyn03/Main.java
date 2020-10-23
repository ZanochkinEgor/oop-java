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
		String str = "Welcome, @to our - #to@ !welcome@ ( hi ) club, buddy. 12345 @Welcome to our to welcome club, buddy.";
        System.out.println("Count letters in word to delete: ");
        int num = in.nextInt();
		DeleteWords.findAndDelete(str,num);
        in.close();
	}
}