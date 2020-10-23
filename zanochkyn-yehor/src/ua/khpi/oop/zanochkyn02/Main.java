package ua.khpi.oop.zanochkyn02;
import java.util.Random;

/**
 * ���� Main, ����:
 * 1) ������ �������� ������������ �����;
 * 2) ���������� ���� � ������� ������� ���������;
 * 3) �������� �� ��� �������� ����� �� ��������, � ����� ����� �� ������������� �����.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 03/10/20
 */
public class Main
{
	/**
	 * ����� main, ����:
	 * 1) ������� ������� getRandom();
	 * 2) ������� ������� decimalToOctal();
	 * 3) ������� ������� compare().
	 */
	public static void main(String[] args)
	{
		int num;
		int range1 = 1000;
		int range2 = 9999;
		System.out.println("Number" + "\t\t\t Equals");
		for(int i = 0; i < 10; i++)
		{
			num = getRandom(range1,range2);
			num = decimalToOctal(num);
			compare(num);
		}
	}
	/**
	 * ����� getRandom, ���� ������ ������������ �����.
	 */
	public static int getRandom(int min, int max) 
	{
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	/**
	 * ����� decimalToOctal, ���� ���������� ����� � ��������� � ������� ������� ���������.
	 */
	public static int decimalToOctal(int a)
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
	 * ����� compare, ���� �������� �� ��� �������� ����� �� ��������, � ����� ����� �� ������������� �����.
	 */
	public static int compare(int a)
	{
		int temp = a;
		int temp3 = a;
		int printNum = a;
		int temp2;
		int count = 0;
		while(a>0)
		{
			a/=10;
			count++;
		}
		System.out.print(printNum);
		if (count == 5 &&(temp%10 == temp/10000))
			System.out.print("\t\t| " + temp3%10 + " ~ " + temp3/10000);
		else if (count == 5 &&(temp%10 != temp/10000))
			System.out.print("\t\t| " + "  -  ");
		if (count == 4 &&(temp%10 == temp/1000))
			System.out.print("\t\t| " + temp3%10 + " ~ " + temp3/1000);
		else if (count == 4 &&(temp%10 != temp/1000))
			System.out.print("\t\t| " + "  -  ");
		if(count == 5)
		{
			temp/=10;
			temp2 = temp/10;
			temp2/=10;
			if (temp%10 == temp2%10)
				System.out.print("\t\t " + temp%10 + " ~ " + temp2%10 + " |");
			else if (temp%10 != temp2%10)
				System.out.print("\t\t " + "  -  " + " |");
		}
		else 
		{
			temp/=10;
			temp2 = temp/10;
			if (temp%10 == temp2%10)
				System.out.print("\t\t " + temp%10 + " ~ " + temp2%10 + " |");
			else if (temp%10 != temp2%10)
				System.out.print("\t\t " + "  -  "  + " |");
		}
		System.out.println(" ");
		return 0;
	}
}