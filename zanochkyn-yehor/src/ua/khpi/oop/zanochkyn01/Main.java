package ua.khpi.oop.zanochkyn01;

/**
 * ���� Main, ����:
 * 1) ������� ���� ����� � ������������� ���������;
 * 2) �������������� ���������� ����� �������������� �������� ����� �����
 * ��������� � ���� ������� ������ � �������� ����;
 * 3) �������������� �������� ����� �������������� �������� ����� �����
 * ���� ������� �������.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 13/09/20
 */
public class Main
{
	/**
	 * ����� main, ����:
	 * 1) ������� ���� ����� � ������������� ���������;
	 * 2) ������� ������� getEven/getOdd ��� ��������� ������� ������/�������� ����;
	 * 3) ������� ������� countBinaryOnes ��� ��������� ������� �������;
	 * 4) �������� ���������� ��������� � �������.
	 */
	public static void main(String[] args)
	{
		int num = 0x12FD1;
		long phone = 380630464673l;
		int a = 0b1001001;
		int b = 011101;
		int c = ((7-1)%26)+1;
		char d = (char)(c+65);
		int paired = getEven(num);
		int unpaired = getOdd(num);
		paired += getEven(phone);
		unpaired += getOdd(phone);
		paired += getEven(a);
		unpaired += getOdd(a);
		paired += getEven(b);
		unpaired += getOdd(b);
		paired += getEven(c);
		unpaired += getOdd(c);
		int binOnes = countBinaryOnes(num);
		binOnes += countBinaryOnes(phone);
		binOnes += countBinaryOnes(a);
		binOnes += countBinaryOnes(b);
		binOnes += countBinaryOnes(c);
		binOnes += countBinaryOnes(d);
		System.out.println("Paired: " + paired);
		System.out.println("Unpaired: " + unpaired);
		System.out.println("BinOnes: " + binOnes);
	}
	/**
	 * ����� getEven, ���� ���� ������� ������ ����.
	 */
	public static int getEven(long i)
	{
        long rest = 0;
        long acc = i;
        int count = 0;
        while (acc != 0) 
        {
            rest = acc % 10;
            acc = acc / 10;
            if (rest % 2 == 0)
                count++;
        }
        return count;
    }
	/**
	 * ����� getOdd, ���� ���� ������� �������� ����.
	 */
	public static int getOdd(long i) 
	{
        long rest = 0;
        long acc = i;
        int count = 0;
        while (acc != 0) 
        {
            rest = acc % 10;
            acc = acc / 10;
            if (rest % 2 != 0)
                count ++;
        }
        return count;
    }
	/**
	 * ����� countBinaryOnes, ���� ���� ������� �������.
	 */
	public static int countBinaryOnes(long number) 
	{
		long temp = number;
		long bin = 0;
		int result = 0;
		while (temp>0)
		{
		    bin = (temp % 2);
		    temp /= 2;
		    if(bin==1)
		    	result++;
		}
		return result;
    }
}