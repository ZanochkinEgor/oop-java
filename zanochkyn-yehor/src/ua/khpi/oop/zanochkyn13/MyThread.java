package ua.khpi.oop.zanochkyn13;

import ua.khpi.oop.zanochkyn10.Client;

public class MyThread implements Runnable
{
	private boolean isActive;
	Thread thread;
	private ClientList<Client> container;
	
	MyThread(ClientList<Client> container, String name)
	{
		this.container = container;
		isActive = true;
		thread = new Thread(this, name);
	}
	
	void disable() 
	{
		isActive = false;
	}
	
	@Override
	public void run()
	{
		long count = 0;
		for(Client i : container)
		{
			if(isActive)
				count += i.getInformation().getAge();
			else
				break;
		}
		System.out.println(Thread.currentThread().getName() + ": " + count);
		System.out.println(Thread.currentThread().getName() + " finished");
	}

}