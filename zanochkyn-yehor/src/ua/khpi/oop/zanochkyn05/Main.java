package ua.khpi.oop.zanochkyn05;

import java.util.Iterator;

public class Main 
{
	public static void main(String[] args) 
	{
		MyContainer container = new MyContainer("There are five types of schools in the US educational system.", "They are: kindergarten, elementary school, middle school, high school and private school.", "Children go to kindergarten when they are 5 years old.", "They go to elementary school from ages 6 through 11 (1-5 grades), middle school from ages 12 through 14 (6-8 grades) and high school from ages 15 through 19 (9-12 grades).");
		Iterator<String> it = container.iterator();
		System.out.println("While cycle:");
		it = container.iterator();
		while (it.hasNext()) 
			System.out.println(it.next());
		
		System.out.println("\nToArray method and displaying using for each cycle:");
		it = container.iterator();
		Object[] array = container.toArray();
		for(Object arr : array)
			System.out.println(arr);
		
		System.out.println("\nSize of the container: " + container.size());
		
		System.out.println("\nRemove and toString methods:");
		System.out.println("String to remove: Children go to kindergarten when they are 5 years old.");
		container.remove("Children go to kindergarten when they are 5 years old.");
		System.out.println(container.toString());
		
		System.out.println("\nSize of the container: " + container.size());
		
		System.out.println("\nContains method:\nString: Children go to kindergarten when they are 5 years old.");
		System.out.println(container.contains("Children go to kindergarten when they are 5 years old."));
		
		System.out.println("\nAdd method:\nString to add: Children go to kindergarten when they are 5 years old.");
		container.add("Children go to kindergarten when they are 5 years old.");
		System.out.println(container.toString());
		
		System.out.println("\nCreating a second container:");
		MyContainer container2 = new MyContainer("There are five types of schools in the US educational system.", "They are: kindergarten, elementary school, middle school, high school and private school.", "Children go to kindergarten when they are 5 years old.", "They go to elementary school from ages 6 through 11 (1-5 grades), middle school from ages 12 through 14 (6-8 grades) and high school from ages 15 through 19 (9-12 grades).");
		System.out.println(container2.toString());
		
		System.out.println("\nContainsAll method:\n"  + container.containsAll(container2));
		System.out.println("\nRemove string: There are five types of schools in the US educational system. from the first container.");
		container.remove("There are five types of schools in the US educational system.");
		
		System.out.println("\nContainsAll method:\n" + container.containsAll(container2));
		
		System.out.println("\nClearing the container.");
		container.clear();
	}
}