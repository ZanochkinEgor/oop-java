package ua.khpi.oop.zanochkyn09;

import java.io.Serializable;

public class Node<T> implements Serializable
{
	private static final long serialVersionUID = -2673405972360871471L;
	public T element;
	public Node<T> next;
	
	public Node() {}
	
	public Node(T el) 
	{
		super();
		this.element = el;
	}
}