package ua.khpi.oop.zanochkyn10;

import java.io.Serializable;

public class PartnerRequirements implements Serializable
{
	private static final long serialVersionUID = 1765405399776141969L;
	
	/*
	 * Змінні
	 */
	private String gender;
	private int minAge;
	private int maxAge;
	private String[] hobby;
	
	/*
	 * Конструктори класу
	 */
	public PartnerRequirements(String gender, int minAge, int maxAge, String[] hobby)
	{
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.hobby = hobby;
	}
	
	public PartnerRequirements()
	{
		
	}
	
	/*
	 * Геттери та сеттери
	 */
	public String getPartnerGender()
	{
		return gender;
	}
	
	public void setPartnerGender(String gender)
	{
		this.gender = gender;
	}
	
	public int getMinAge()
	{
		return minAge;
	}
	
	public void setMinAge(int minAge)
	{
		this.minAge = minAge;
	}
	
	public int getMaxAge()
	{
		return maxAge;
	}
	
	public void setMaxAge(int maxAge)
	{
		this.maxAge = maxAge;
	}
	
	public String[] getPartnerHobby()
	{
		return hobby;
	}
	
	public void setPartnerHobby(String[] hobby)
	{
		this.hobby = hobby;
	}
}
