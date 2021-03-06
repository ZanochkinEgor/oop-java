package ua.khpi.oop.zanochkyn06;

import java.io.Serializable;
import java.util.Iterator;

public class MyContainer implements Serializable
{
	private String[] arrayStr;
	private int size;
	
	/*
	 * ����������� ����� MyContainer
	 */
	public MyContainer(String... str) 
	{
		if (str.length != 0) 
		{
			size = str.length;
			arrayStr = new String[size];
			for (int i = 0; i < size; i++) 
				arrayStr[i] = str[i];
		}
	}
	
	/*
	 * ����� toString, ���� ������� ���� ���������� � ������ �����
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) 
			sb.append(arrayStr[i] + " ");
		return sb.toString();
	}
	
	/*
	 * ����� add, ���� ���� ����� � ����� ������
	 */
	public void add(String string) 
	{
		String newArr[] = new String[size + 1];
		for (int i = 0; i < size; i++) 
			newArr[i] = arrayStr[i];
		newArr[size] = string;
		size++;
		arrayStr = newArr;
	}
	
	/*
	 * ����� clear, ���� ����� ���������
	 */
	public void clear() 
	{
		for (int i = 0; i < size; i++) 
			arrayStr[i] = null;
		size = 0;
	}
	
	/*
	 * ����� remove, ���� ������� ������ ������� ��������� �������� � ����������
	 */
	boolean remove(String string) 
	{
		boolean flag = false;
		int pos = 0;
		for (int i = 0; i < size; i++) 
			if(arrayStr[i].equals(string)) 
			{
				flag = true;
				pos = i;
				break;
			}
		if (flag) 
		{
			String newArr[] = new String[size - 1];
			for (int i = 0; i < pos; i++) 
				newArr[i] = arrayStr[i];
			for (int i = pos, j = pos + 1; j < size; i++, j++) 
				newArr[i] = arrayStr[j];
			size--;
			arrayStr = newArr;
		}
		return flag;
	}
	
	/*
	 * ����� toArray, ���� ������� �����, �� ������ �� �������� � ���������
	 */
	public Object[] toArray() 
	{
		Object[] arr = new Object[size];
		for (int i = 0; i < size; i++)
			arr[i] = arrayStr[i];
		return arr;
	}
	
	/*
	 * ����� size, ���� ������� ������� �������� � ���������
	 */
	public int size() 
	{
		return size;
	}
	
	/*
	 * ����� contains, ���� ������� true, ���� ��������� ������ �������� �������
	 */
	public boolean contains(String string) 
	{
		for (String str : arrayStr) 
			if (str.equals(string)) 
				return true;
		return false;
	}
	
	/*
	 * ����� containsAll, ���� ������� true, ���� ��������� ������ �� �������� � ����������� � ����������
	 */
	public boolean containsAll(MyContainer container) 
	{
		if (size == 0 || container.size() == 0 || size < container.size()) 
			return false;
		int count = 0;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < container.size(); j++)
				if(arrayStr[i].equals(container.arrayStr[j])) 
				{
					count++;
					break;
				}
		if(count == container.size())	
			return true;
		else
			return false;
	}
	
	/*
	 * ����� printContainer, ���� �������� � ������� ���� ����������
	 */
	public void printContainer()
	{
		for(String str : arrayStr)
			System.out.println(str);
		System.out.println();
	}
	
	/*
	 * ����� sortLength, ���� ����� ��������� �� ��������
	 */
	public void sortLength(int option)
	{
		switch(option)
		{
		case 1:
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arrayStr[j].length() > arrayStr[j+1].length())
					{
						String temp = arrayStr[j];
						arrayStr[j] = arrayStr[j+1];
						arrayStr[j+1] = temp;
					}
			break;
		case 2:
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arrayStr[j].length() < arrayStr[j+1].length())
					{
						String temp = arrayStr[j];
						arrayStr[j] = arrayStr[j+1];
						arrayStr[j+1] = temp;
					}
			break;
		}
	}
	
	/*
	 * ����� sortAlphabet, ���� ����� ��������� �� ��������
	 */
	public void sortAlphabet(int option)
	{
		switch(option)
		{
		case 1:
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arrayStr[j].compareTo(arrayStr[j+1]) > 0)
					{
						String temp = arrayStr[j];
						arrayStr[j] = arrayStr[j+1];
						arrayStr[j+1] = temp;
					}
			break;
		case 2:
			for(int i = 0; i < size - 1; i++)
				for(int j = 0; j < size - 1; j++)
					if(arrayStr[j].compareTo(arrayStr[j+1]) < 0)
					{
						String temp = arrayStr[j];
						arrayStr[j] = arrayStr[j+1];
						arrayStr[j+1] = temp;
					}
			break;
		}
	}
	
	/*
	 * ����� findElement, ���� ��������� �������, �� ��� ���������� ������� � ���������
	 */
	public int findElement(String string)
	{
		int pos = 0;
		for(String str : arrayStr)
		{
			if(str.equals(string))
				return pos;
			pos++;
		}
		return -1;
	}
	
	/*
	 * ����� compareElements, ���� ������� �������� � ���������
	 */
	public int compareElements(int pos1, int pos2)
	{
		if(pos1 > size || pos2 > size)
			return -1;
		if(arrayStr[pos1 - 1].equals(arrayStr[pos2 - 1]))
			return 1;
		else
			return 0;
	}
	
	/*
	 * ����� iterator, ���� ������� �������� �������� �� Interface Iterable.
	 */
	public Iterator<String> iterator() 
	{
		return new MyIterator<String>();
	}
	
	public class MyIterator<String> implements Iterator 
	{
		int index;
		
		/*
		 * Method that returns true if the iteration has more elements
		 */
		@Override
		public boolean hasNext() 
		{
			return index < size;
		}
	
		/*
		 * Method that returns the next element in the iteration
		 */
		@Override
		public Object next() 
		{
			return arrayStr[index++];
		}
		
		/*
		 * Method that removes from the underlying collection the last element returned by this iterator
		 */
		@Override
		public void remove() 
		{
			MyContainer.this.remove(arrayStr[index - 1]);
		}
	}
}