package ua.khpi.oop.zanochkyn01;

/**
 * ���� Main, ����:
 * 1) ������� ����� ����� � ������������� ���������;
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
	 * 1) ������� ����� ����� � ������������� ���������;
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
		System.out.format("%12s%10s%10s%10s\n", "Number","Paired","Unpaired","BinOnes");
		int paired = getEven(num);
		int unpaired = getOdd(num);
		int binOnes = countBinaryOnes(num);
		System.out.format("%12d%8d%9d%11d\n", num,paired,unpaired,binOnes);
		paired = getEven(phone);
		unpaired = getOdd(phone);
		binOnes = countBinaryOnes(phone);
		System.out.format("%12d%8d%9d%11d\n", phone,paired,unpaired,binOnes);
		paired = getEven(a);
		unpaired = getOdd(a);
		binOnes = countBinaryOnes(a);
		System.out.format("%12d%8d%9d%11d\n", a,paired,unpaired,binOnes);
		paired = getEven(b);
		unpaired = getOdd(b);
		binOnes = countBinaryOnes(b);
		System.out.format("%12d%8d%9d%11d\n", b,paired,unpaired,binOnes);
		paired = getEven(c);
		unpaired = getOdd(c);
		binOnes = countBinaryOnes(c);
		System.out.format("%12d%8d%9d%11d\n", c,paired,unpaired,binOnes);
		binOnes = countBinaryOnes(d);
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