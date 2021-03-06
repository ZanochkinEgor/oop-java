package ua.khpi.oop.zanochkyn07;

import java.io.Serializable;

public class PartnerRequirements implements Serializable
{
	private static final long serialVersionUID = 1765405399776141969L;
	
	/*
	 * �����
	 */
	private String gender;
	private int minAge;
	private int maxAge;
	
	/*
	 * ������������ �����
	 */
	public PartnerRequirements(String gender, int minAge, int maxAge)
	{
		this.gender = gender;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	
	public PartnerRequirements()
	{
		
	}
	
	/*
	 * ������� �� �������
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
}
