package ua.khpi.oop.zanochkyn09;

import java.io.Serializable;
import ua.khpi.oop.zanochkyn07.InfoAboutYourself;
import ua.khpi.oop.zanochkyn07.PartnerRequirements;

public class Client implements Serializable 
{
	private static final long serialVersionUID = 8633968308489911794L;
	
	/*
	 * Змінні
	 */
	private String gender;
	private int id;
	private String registrationDate;
	private InfoAboutYourself information;
	private PartnerRequirements requirements;
	
	/*
	 * Конструктори класу
	 */
	public Client(String gender, int id, String date, InfoAboutYourself info, PartnerRequirements requirements)
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
	
	public String getDate()
	{
		return registrationDate;
	}
	
	public void setDate(String date)
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
		return "ID - " + id + "\nRegistration date - " + registrationDate + "\nGender - " + gender + "\n\n" +
				"Information about yourself:\nName - " + getInformation().getName() + "\nAge - " + getInformation().getAge() +
				"\nHeight - " + getInformation().getHeight() + "\nEye colour - " + getInformation().getEyeColour() + 
				"\nHobby - " + getInformation().getClientHobby() + "\n\n" +
				"Partner requirements:\nGender - " + getRequirements().getPartnerGender() +
				"\nMin age - " + getRequirements().getMinAge() + "\nMax age - " + getRequirements().getMaxAge() + 
				"\n----------------------------------------";
	}
}