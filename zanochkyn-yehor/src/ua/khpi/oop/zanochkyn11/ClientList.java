package ua.khpi.oop.zanochkyn11;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import ua.khpi.oop.zanochkyn10.Client;
import ua.khpi.oop.zanochkyn10.Node;

public class ClientList<T> implements Serializable, Iterable<T>
{	
	private static final long serialVersionUID = 5493313651067238933L;
	public Node<T> head;
	private int size;
	
	/*
	 * Getter and setter for size
	 */
	public int getSize() { return size; }
	public void setSize(int size) { this.size = size; }

	/*
	 * Method (add) that add a new client into container
	 */
	public void add(T el) 
	{
		Node<T> temp = new Node<T>();
		if(head == null)
			head = new Node<T>(el);
		else 
		{
			temp = head;
			while(temp.next != null)
				temp = temp.next;
			temp.next = new Node<T>(el);
		}
		size++;
	}
	
	/*
	 * Method (remove) that remove a client from container
	 */
	public void remove(int id) 
	{
		Node<T> temp = head;
		if(head != null) 
		{
			if(id == 0)
				head = head.next;
			else 
			{
				for(int i = 0; i < id - 1; i++) 
					temp = temp.next;
				if(temp.next != null) 
					temp.next = temp.next.next;
				else 
					temp.next = null;
			}
			size--;
		}
		else 
			System.out.println("Container is empty.");
	}
	
	/*
	 * Method (clear) that clear the container
	 */
	public void clear()
	{
		this.head = null;
		size = 0;
	}
	
	/*
	 * Method (toArray[]) that return container as an array
	 */
	public Object[] toArray() 
	{
		Object[] arr = new Object[size];
		for(int i = 0; i < size; i++) 
			arr[i] = getElement(i);
		return arr;
	}
	
	/*
	 * Method (getElement) that return a specific element from container
	 */
	public T getElement(int id) 
	{
		if(id < 0 || id >= size) 
		{
			System.out.println("Wrong id.");
			return null;
		}
		Node<T> temp = head;
		for(int i = 0; i < id; i++) 
			temp = temp.next;
		return temp.element;
	}
	
	/*
	 * Method (toString) that return a container as a string
	 */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		for(T value : this)
			sb.append(value + "\n");
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	public void sort(Comparator<T> comp, int option)
	{
		Object[] arr = this.toArray();
		Object temp;
		boolean flag;
		if(option == 1)
			do
			{
				flag = false;
				for(int i = 0; i < size - 1; i++)
					if(comp.compare((T)arr[i], (T)arr[i+1]) == 1)
					{
						flag = true;
						temp = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = temp;
					}
			}
			while(flag == true);
		else
			do
			{
				flag = false;
				for(int i = 0; i < size - 1; i++)
					if(comp.compare((T)arr[i], (T)arr[i+1]) == -1)
					{
						flag = true;
						temp = arr[i+1];
						arr[i+1] = arr[i];
						arr[i] = temp;
					}
			}
			while(flag == true);
		this.clear();
		for (Object i : arr)
			this.add((T) i);
	}
	
	public Iterator<T> iterator()
	{
		return new Iterator<T>() 
		{
			int index = 0;
			boolean check = false;
			
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
			public T next()
			{
				if (index == size)
					throw new NoSuchElementException();
				check = true;
				return getElement(index++);
			}
			
			/*
			 * Method that removes from the container the last element returned by this iterator
			 */
			@Override
			public void remove() 
			{
				if (check) 
				{
					ClientList.this.remove(index - 1);
					check = false;
				}
				else 
					throw new IllegalStateException();
			}
		};
	}
}

class RegistrationDateComparator implements Comparator<Client>
{
	public int compare(Client o1, Client o2)
	{
		if(o1.getDate().getTimeInMillis() > o2.getDate().getTimeInMillis())
			return 1;
		else if(o1.getDate().getTimeInMillis() < o2.getDate().getTimeInMillis())
			return -1;
		else
			return 0;
	}
}

class ClientHobbiesComparator implements Comparator<Client>
{
	public int compare(Client o1, Client o2)
	{
		if(o1.getInformation().getClientHobby().length > o2.getInformation().getClientHobby().length)
			return 1;
		else if(o1.getInformation().getClientHobby().length < o2.getInformation().getClientHobby().length)
			return -1;
		else
			return 0;
	}
}

class PartnerHobbiesComparator implements Comparator<Client>
{
	public int compare(Client o1, Client o2)
	{
		if(o1.getRequirements().getPartnerHobby().length > o2.getRequirements().getPartnerHobby().length)
			return 1;
		else if(o1.getRequirements().getPartnerHobby().length < o2.getRequirements().getPartnerHobby().length)
			return -1;
		else
			return 0;
	}
}

class IdComparator implements Comparator<Client>
{
	public int compare(Client o1, Client o2)
	{
		if(o1.getId() > o2.getId())
			return 1;
		else if(o1.getId() < o2.getId())
			return -1;
		else
			return 0;
	}
}