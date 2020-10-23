package ua.khpi.oop.zanochkyn01;

/**
 * Клас Main, який:
 * 1) створює змінні згідно з індивідуальним завданням;
 * 2) використовуючи десятковий запис цілочисельного значення кожної змінної
 * знаходить і рахує кількість парних і непарних цифр;
 * 3) використовуючи двійковий запис цілочисельного значення кожної змінної
 * рахує кількість одиниць.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 13/09/20
 */
public class Main
{
	/**
	 * Метод main, який:
	 * 1) створює змінні згідно з індивідуальним завданням;
	 * 2) викликає функції getEven/getOdd для рахування кількості парних/непарних цифр;
	 * 3) викликає функцію countBinaryOnes для рахування кількості одиниць;
	 * 4) виводить результати виконання у консоль.
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
	 * Метод getEven, який рахує кількість парних цифр.
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
	 * Метод getOdd, який рахує кількість непарних цифр.
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
	 * Метод countBinaryOnes, який рахує кількість одиниць.
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