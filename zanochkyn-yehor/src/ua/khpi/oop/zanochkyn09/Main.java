package ua.khpi.oop.zanochkyn09;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import ua.khpi.oop.zanochkyn07.InfoAboutYourself;
import ua.khpi.oop.zanochkyn07.PartnerRequirements;

public class Main 
{
	public static void main(String[] args) 
	{
		ClientList<Client> container = new ClientList<Client>();
		String gender;
		String date;
		InfoAboutYourself info;
		PartnerRequirements requirements;
		int ID = 1;
		boolean endCheck = true;
		Scanner inInt = new Scanner(System.in);
		Scanner inStr = new Scanner(System.in);
		while (endCheck) 
		{
			System.out.println("Menu:");
			System.out.println("1. Show clients");
			System.out.println("2. Add client");
			System.out.println("3. Remove client");
			System.out.println("4. Change information");
			System.out.println("5. Clear list");
			System.out.println("6. Serialize data");
			System.out.println("7. Deserialize data");
			System.out.println("8. Count elements in a container");
			System.out.println("0. Exit");
			System.out.println("Enter your option:");
			int option = inInt.nextInt();
			System.out.println();
			switch (option) 
			{
			case 1:
				if(container.getSize() > 0)
					System.out.println(container.toString());
				else
					System.out.println("Container is empty.\n");
				break;
			case 2:
				System.out.println("Enter gender:");
				gender = inStr.nextLine();
				System.out.println("Enter registration date:");
				date = inStr.nextLine();
				System.out.println("Enter information about yourself: Name, age, height, eye colour, hobby.");
				info = new InfoAboutYourself(inStr.nextLine(), inInt.nextInt(), inInt.nextInt(), inStr.nextLine(), inStr.nextLine());
				System.out.println("Enter partner requirements: Gender, min age, max age.");
				requirements = new PartnerRequirements(inStr.nextLine(), inInt.nextInt(), inInt.nextInt());
				container.add(new Client(gender, ID++, date, info, requirements));
				System.out.println("\n" + container.toString());
				break;
			case 3:
				System.out.println("Enter client's ID to remove him:");
				int id = inInt.nextInt();
				int size = container.getSize();
				for(int i = 0; i < container.getSize(); i++)
					if(container.getElement(i).getId() == id)
					{
						container.remove(i);
						break;
					}
				if(size == container.getSize())
					System.out.println("There is no such client");
				else
					System.out.println("Client removed");
				System.out.println();
				break;
			case 4:
				System.out.println("Enter client's ID to change his information:");
				id = inInt.nextInt();
				int index = 0;
				for(index = 0; index < container.getSize(); index++)
					if(container.getElement(index).getId() == id)
						break;
				if(index == container.getSize())
				{
					System.out.println("There is no client with that ID.\n");
					break;
				}
				boolean endCheck2 = true;
				int option2 = 0;
				while(endCheck2)
				{
					System.out.println("\n" + container.getElement(index).toString() + "\n");
					System.out.println("Which information you want to change?");
					System.out.println("1. Gender");
					System.out.println("2. ID");
					System.out.println("3. Registration date");
					System.out.println("4. Information about yourself");
					System.out.println("5. Partner requirements");
					System.out.println("6. End of change");
					System.out.println("Enter option:");
					option2 = inInt.nextInt();
					System.out.println();
					switch(option2)
					{
					case 1:
						System.out.println("Enter new gender:");
						container.getElement(index).setClientGender(inStr.nextLine());
						break;
					case 2:
						System.out.println("Enter new ID:");
						container.getElement(index).setId(inInt.nextInt());
						break;
					case 3:
						System.out.println("Enter new registration date:");
						container.getElement(index).setDate(inStr.nextLine());
						break;
					case 4:
						System.out.println("Information about yourself:");
						System.out.println("1. Name");
						System.out.println("2. Age");
						System.out.println("3. Height");
						System.out.println("4. Eye colour");
						System.out.println("5. Hobby");
						System.out.println("6. Change all information");
						System.out.println("Enter option:");
						int option3 = inInt.nextInt();
						System.out.println();
						switch(option3)
						{
						case 1:
							System.out.println("Enter new name:");
							container.getElement(index).getInformation().setName(inStr.nextLine());
							break;
						case 2:
							System.out.println("Enter new age:");
							container.getElement(index).getInformation().setAge(inInt.nextInt());
							break;
						case 3:
							System.out.println("Enter new height:");
							container.getElement(index).getInformation().setHeight(inInt.nextInt());
							break;
						case 4:
							System.out.println("Enter new eye colour:");
							container.getElement(index).getInformation().setEyeColour(inStr.nextLine());
							break;
						case 5:
							System.out.println("Enter new hobby:");
							container.getElement(index).getInformation().setClientHobby(inStr.nextLine());
							break;
						case 6:
							System.out.println("Enter information about yourself: Name, age, height, eye colour, hobby.");
							info = new InfoAboutYourself(inStr.nextLine(), inInt.nextInt(), inInt.nextInt(), inStr.nextLine(), inStr.nextLine());
							container.getElement(index).setInformation(info);
							break;
						default:
							System.out.println("Wrong command.");
							break;
						}
						break;
					case 5:
						System.out.println("Partner requirements:");
						System.out.println("1. Gender");
						System.out.println("2. Min age");
						System.out.println("3. Max age");
						System.out.println("4. Change all requirements");
						System.out.println("Enter option:");
						option3 = inInt.nextInt();
						System.out.println();
						switch(option3)
						{
						case 1:
							System.out.println("Enter new gender:");
							container.getElement(index).getRequirements().setPartnerGender(inStr.nextLine());
							break;
						case 2:
							System.out.println("Enter new min age:");
							container.getElement(index).getRequirements().setMinAge(inInt.nextInt());
							break;
						case 3:
							System.out.println("Enter new max age:");
							container.getElement(index).getRequirements().setMaxAge(inInt.nextInt());
							break;
						case 4:
							System.out.println("Enter partner requirements: Gender, min age, max age.");
							requirements = new PartnerRequirements(inStr.nextLine(), inInt.nextInt(), inInt.nextInt());
							container.getElement(index).setRequirements(requirements);
							break;
						default:
							System.out.println("Wrong command.");
							break;
						}
						break;
					case 6:
						endCheck2 = false;
						break;
					default:
						System.out.println("Wrong command.");
						break;
					}	
				}
				break;
			case 5:
				container.clear();
				System.out.println("Container cleared.\n");
				break;
			case 6:
				System.out.println("Choose the method");
				System.out.println("1. Standard serialization");
				System.out.println("2. XML serialization");
				System.out.println("3. End");
				System.out.println("Enter your option:");
				option2 = inInt.nextInt();
				System.out.println();
				switch(option2)
				{
				case 1:
					try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Lab09.ser"))))
					{
						oos.writeObject(container);
						oos.flush();
						System.out.println("Serialization successful.\n");
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage() + "\n");
					}
					break;
				case 2:
					try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Lab09.xml"))))
					{
						encoder.writeObject(container);
						System.out.println("Serialization successful.\n");
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage() + "\n");
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Wrong command.\n");
					break;
				}
				break;	
			case 7:
				System.out.println("Choose the method");
				System.out.println("1. Standard deserialization");
				System.out.println("2. XML deserialization");
				System.out.println("3. End");
				System.out.println("Enter your option");
				option2 = inInt.nextInt();
				System.out.println();
				switch(option2)
				{
				case 1:				
					try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Lab09.ser"))))
					{
						container.clear();
						container = (ClientList<Client>) ois.readObject();
						System.out.println("Deserialization successful.\n");
					}
					catch(Exception ex)
					{
						System.out.println(ex.getMessage());
					}
					break;	
				case 2:
					try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Lab09.xml"))))
					{
						container.clear();
						container = (ClientList<Client>) decoder.readObject();
						System.out.println("Deserialization successful.\n");
					}
					catch(IOException ex)
					{
						System.out.println(ex.getMessage());
					}
					break;
				case 3:
					break;
				default:
					System.out.println("Wrong command.\n");
					break;
				}
				break;
			case 8:
				System.out.println("There are " + container.getSize() + " elements in a container\n");
				break;
			case 0:
				endCheck = false;
				container.clear();
				inInt.close();
				inStr.close();
				break;
			default:
				System.out.println("Wrong command\n");
				break;
			}
		}
		System.out.println("End");
	}
}