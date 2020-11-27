package ua.khpi.oop.zanochkyn05;

import java.util.Iterator;

public class MyContainer 
{
	private String[] arrayStr;
	private int size;
	
	/*
	 * Конструктор класу MyContainer
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
	 * Метод toString, який повертає вміст контейнера у вигляді рядка
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) 
			sb.append(arrayStr[i] + " ");
		return sb.toString();
	}
	
	/*
	 * Метод add, який додає рядок в кінець масиву
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
	 * Метод clear, який очищує контейнер
	 */
	public void clear() 
	{
		for (int i = 0; i < size; i++) 
			arrayStr[i] = null;
		size = 0;
	}
	
	/*
	 * Метод remove, який видаляє перший випадок вказаного елемента з контейнера
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
	 * Метод toArray, який повертає масив, що містить всі елементи у контейнері
	 */
	public Object[] toArray() 
	{
		Object[] arr = new Object[size];
		for (int i = 0; i < size; i++)
			arr[i] = arrayStr[i];
		return arr;
	}
	
	/*
	 * Метод size, який повертає кількість елементів у контейнері
	 */
	public int size() 
	{
		return size;
	}
	
	/*
	 * Метод contains, який повертає true, якщо контейнер містить вказаний елемент
	 */
	public boolean contains(String string) 
	{
		for (String str : arrayStr) 
			if (str.equals(string)) 
				return true;
		return false;
	}
	
	/*
	 * Метод containsAll, який повертає true, якщо контейнер містить всі елементи з зазначеного у параметрах
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
	 * Метод iterator, який повертає ітератор відповідно до Interface Iterable.
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