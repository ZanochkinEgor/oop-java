package ua.khpi.oop.zanochkyn10;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Client implements Serializable 
{
	private static final long serialVersionUID = 8633968308489911794L;
	
	/*
	 * Змінні
	 */
	private String gender;
	private int id;
	private GregorianCalendar registrationDate;
	private InfoAboutYourself information;
	private PartnerRequirements requirements;
	
	/*
	 * Конструктори класу
	 */
	public Client(String gender, int id, GregorianCalendar date, InfoAboutYourself info, PartnerRequirements requirements)
	{
		this.gender = gender;
		this.id = id;
		this.registrationDate = date;
		this.information = info;
		this.requirements = requirements;
	}
	
	public Client()
	{
		
	}
	/*
	 * Геттери та сеттери
	 */
	public String getClientGender()
	{
		return gender;
	}
	
	public void setClientGender(String gender)
	{
		this.gender = gender;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public GregorianCalendar getDate()
	{
		return registrationDate;
	}
	
	public void setDate(GregorianCalendar date)
	{
		this.registrationDate = date;
	}
	
	public InfoAboutYourself getInformation()
	{
		return information;
	}
	
	public void setInformation(InfoAboutYourself info)
	{
		this.information = info;
	}
	
	public PartnerRequirements getRequirements()
	{
		return requirements;
	}
	
	public void setRequirements(PartnerRequirements requirements)
	{
		this.requirements = requirements;
	}
	
	public String toString()
	{
		return "ID - " + id + "\nRegistration date - " + registrationDate.getTime() + "\nGender - " + gender + "\n\n" +
				"Information about yourself:\nName - " + getInformation().getName() + "\nAge - " + getInformation().getAge() +
				"\nHeight - " + getInformation().getHeight() + "\nEye colour - " + getInformation().getEyeColour() + 
				"\nHobbies - " + hobbiesToString(getInformation().getClientHobby()) + "\n\n" +
				"Partner requirements:\nGender - " + getRequirements().getPartnerGender() + "\nMin age - " + getRequirements().getMinAge() +
				"\nMax age - " + getRequirements().getMaxAge() + "\nHobbies - " + hobbiesToString(getRequirements().getPartnerHobby()) +
				"\n----------------------------------------";
	}
	
	public String hobbiesToString(String[] arr)
	{
		int size = arr.length;
		if(size == 0)
			return "No hobbies";
		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(String temp : arr)
		{
			if(i != size)
				sb.append(temp + ", ");
			else
				sb.append(temp);
			i++;
		}
		return sb.toString();
	}
}