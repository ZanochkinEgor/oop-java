package ua.khpi.oop.zanochkyn15;

import java.util.ArrayList;

public class MyThread implements Runnable
{
	private boolean isActive;
	Thread thread;
	private ArrayList<Client> container;
	private int time;
	
	MyThread(ArrayList<Client> container, String name, int time)
	{
		this.container = container;
		isActive = true;
		thread = new Thread(this, name);
		this.time = time;
	}
	
	void disable() 
	{
		isActive = false;
	}
	
	@Override
	public void run()
	{
		long countTime = 0;
		long temp = 0;
		for(int i = 0; i < time; i++)
		{
			try
			{
				temp = count();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			countTime += temp;
		}	
		System.out.println("Time spent: " + countTime + " milliseconds");
	}
	
	private long count() throws InterruptedException
	{
		long count = 0;
		long begin = System.currentTimeMillis();
		Thread.currentThread().sleep(1000);
		for(Client i : container)
			if(isActive)
				count += i.getInformation().getAge();
			else
			{
				System.out.println(Thread.currentThread().getName() + " was stopped.");
				return -1;
			}
		System.out.println(Thread.currentThread().getName() + ": " + count);
		System.out.println(Thread.currentThread().getName() + " finished");
		return (System.currentTimeMillis() - begin);
	}
}