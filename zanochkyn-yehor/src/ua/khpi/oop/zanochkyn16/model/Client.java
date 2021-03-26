package ua.khpi.oop.zanochkyn16.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import ua.khpi.oop.zanochkyn16.util.LocalDateAdapter;

public class Client 
{
	/*
	 * Client info
	 */
	private StringProperty clientGender;
	private IntegerProperty id;
	private ObjectProperty<LocalDate> registrationDate;
	private StringProperty name;
	private IntegerProperty age;
	private IntegerProperty height;
	private StringProperty eyeColour;
	private StringProperty clientHobbies;
	
	/* 
	 * Partner requirements 
	 */
	private StringProperty partnerGender;
	private IntegerProperty minAge;
	private IntegerProperty maxAge;
	private StringProperty partnerHobbies;
	
	/*
	 * Constructors
	 */
	public Client(String clientGender, int id, LocalDate date, String name, int age, int height, String eyeColour, 
			String clientHobbies, String partnerGender, int minAge, int maxAge, String partnerHobbies)
	{
		this.clientGender = new SimpleStringProperty(clientGender);
		this.id = new SimpleIntegerProperty(id);
		this.registrationDate = new SimpleObjectProperty<LocalDate>(date);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.height = new SimpleIntegerProperty(height);
		this.eyeColour = new SimpleStringProperty(eyeColour);
		this.clientHobbies = new SimpleStringProperty(clientHobbies);
		this.partnerGender = new SimpleStringProperty(partnerGender);
		this.minAge = new SimpleIntegerProperty(minAge);
		this.maxAge = new SimpleIntegerProperty(maxAge);
		this.partnerHobbies = new SimpleStringProperty(partnerHobbies);
	}
	
	public Client() 
	{
		this(null, 0, LocalDate.now(), null, 0, 0, null, null, null, 0, 0, null);
	}

	/*
	 * Getters and setters
	 */
	public String getClientGender()
	{
		return clientGender.get();
	}
	
	public void setClientGender(String gender)
	{
		this.clientGender.set(gender);
	}
	
	public int getId()
	{
		return id.get();
	}
	
	public void setId(int id)
	{
		this.id.set(id);
	}
	
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getRegistrationDate()
	{
		return registrationDate.get();
	}
	
	public void setRegistrationDate(LocalDate date)
	{
		this.registrationDate.set(date);
	}
	
	public String getName()
	{
		return name.get();
	}
	
	public void setName(String name)
	{
		this.name.set(name);
	}
	
	public int getAge()
	{
		return age.get();
	}
	
	public void setAge(int age)
	{
		this.age.set(age);
	}
	
	public int getHeight()
	{
		return height.get();
	}
	
	public void setHeight(int height)
	{
		this.height.set(height);
	}
	
	public String getEyeColour()
	{
		return eyeColour.get();
	}
	
	public void setEyeColour(String eyeColour)
	{
		this.eyeColour.set(eyeColour);
	}
	
	public String getClientHobbies()
	{
		return clientHobbies.get();
	}
	
	public void setClientHobbies(String clientHobbies)
	{
		this.clientHobbies.set(clientHobbies);
	}
	
	public String getPartnerGender()
	{
		return partnerGender.get();
	}
	
	public void setPartnerGender(String partnerGender)
	{
		this.partnerGender.set(partnerGender);
	}
	
	public int getMinAge()
	{
		return minAge.get();
	}
	
	public void setMinAge(int minAge)
	{
		this.minAge.set(minAge);
	}
	
	public int getMaxAge()
	{
		return maxAge.get();
	}
	
	public void setMaxAge(int maxAge)
	{
		this.maxAge.set(maxAge);
	}
	
	public String getPartnerHobbies()
	{
		return partnerHobbies.get();
	}
	
	public void setPartnerHobbies(String partnerHobbies)
	{
		this.partnerHobbies.set(partnerHobbies);
	}
	
	public StringProperty clientGenderProperty()
	{
		return clientGender;
	}

	public IntegerProperty idProperty()
	{
		return id;
	}
	
	public ObjectProperty<LocalDate> registrationDateProperty()
	{
		return registrationDate;
	}

	public StringProperty nameProperty()
	{
		return name;
	}

	public IntegerProperty ageProperty()
	{
		return age;
	}
	
	public IntegerProperty heightProperty()
	{
		return height;
	}
	
	public StringProperty eyeColourProperty()
	{
		return eyeColour;
	}
	
	public StringProperty clientHobbiesProperty()
	{
		return clientHobbies;
	}
	
	public StringProperty partnerGenderProperty()
	{
		return partnerGender;
	}
	
	public IntegerProperty minAgeProperty()
	{
		return minAge;
	}
	
	public IntegerProperty maxAgeProperty()
	{
		return maxAge;
	}
	
	public StringProperty partnerHobbiesProperty()
	{
		return partnerHobbies;
	}
	
	@Override
	public boolean equals(Object o)
	{
	    if (this == o)
	    	return true;
	    if (o == null || getClass() != o.getClass())
	    	return false;
	    Client client = (Client) o;
	    return Objects.equals(getClientGender(), client.getClientGender()) && Objects.equals(getId(), client.getId()) && 
	    		Objects.equals(getRegistrationDate(), client.getRegistrationDate()) && Objects.equals(getName(), client.getName()) && 
	    		Objects.equals(getAge(), client.getAge()) && Objects.equals(getHeight(), client.getHeight()) && Objects.equals(getEyeColour(), client.getEyeColour()) && 
	    		Objects.equals(getClientHobbies(), client.getClientHobbies()) && Objects.equals(getPartnerGender(), client.getPartnerGender()) && 
	    		Objects.equals(getMinAge(), client.getMinAge()) && Objects.equals(getMaxAge(), client.getMaxAge()) && Objects.equals(getPartnerHobbies(), client.getPartnerHobbies());
	}
}