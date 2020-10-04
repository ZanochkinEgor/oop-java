package ua.khpi.oop.zanochkyn02;
import java.util.Random;

/**
 * Клас Main, який:
 * 1) генерує випадкве чотиризначне число;
 * 2) переводить його у вісімкову систему счислення;
 * 3) перевіряє чи рівні значення першої та останньої, а також другої та передостанньої цифри.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 03/10/20
 */
public class Main
{
	/**
	 * Метод main, який:
	 * 1) викликає функцію getRandom();
	 * 2) викликає функцію decimalToOct();
	 * 3) викликає функцію compare().
	 */
	public static void main(String[] args)
	{
		int num;
		int range1 = 1000;
		int range2 = 9999;
		for(int i = 0; i < 10; i++)
		{
			num = getRandom(range1,range2);
			System.out.println("Decimal: " + num);
			num = decimalToOct(num);
			System.out.println("Octal: " + num);
			compare(num);
		}
	}
	/**
	 * Метод getRandom, який:
	 * 1) генерує чотиризначне число.
	 */
	public static int getRandom(int min, int max) 
	{
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	/**
	 * Метод decimalToOct, який:
	 * 1) переводить число з десяткової у вісімкову систему счислення.
	 */
	public static int decimalToOct(int a)
	{
		int temp = a;
		int newch = 0;
		int mn = 1;
		while (temp>0)
		{
			newch += (temp%8) *mn;
			temp/=8;
			mn*=10;
			if(temp<1) 
				break;
		}
		return newch;
	}
	/**
	 * Метод compare, який:
	 * 1) перевіряє чи рівні значення першої та останньої, а також другої та передостанньої цифри.
	 */
	public static int compare(int a)
	{
		int temp = a;
		int printNum = a;
		int temp2;
		int count = 0;
		while(a>0)
		{
			a/=10;
			count++;
		}
		if ((count == 4 &&(temp%10 == temp/1000)) || (count == 5 &&(temp%10 == temp/10000)))
			System.out.println(printNum + " - first and last numbers are equal");
		else
			System.out.println(printNum + " - first and last numbers are NOT equal");
		if(count == 5)
		{
			temp/=10;
			temp2 = temp/10;
			temp2 = temp/10;
			if (temp%10 == temp2%10)
				System.out.println(printNum + " - second and fourth numbers are equal");
			else
				System.out.println(printNum + " - second and fourth numbers are NOT equal");
		}
		else 
		{
			temp/=10;
			temp2 = temp/10;
			if (temp%10 == temp2%10)
				System.out.println(printNum + " - second and third numbers are equal");
			else
				System.out.println(printNum + " - second and third numbers are NOT equal");
		}
		return 0;
	}
}