package ua.khpi.oop.zanochkyn07;

public class ClientList 
{
	Client array[] = new Client[2];
	
	/*
	 * Метод print, що виводить інформацію про клієнта на екран
	 */
	public void print()
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("ID - " + array[i].getId() + "\nДата регистрации - " + array[i].getDate() + "\nПол - " + array[i].getClientGender() + "\n"); 
			System.out.println("Информация о себе:\nИмя - " + array[i].getInformation().getName() + "\nВозраст - " + array[i].getInformation().getAge() +
					"\nРост - " + array[i].getInformation().getHeight() + "\nЦвет глаз - " + array[i].getInformation().getEyeColour() + 
					"\nХобби - " + array[i].getInformation().getClientHobby() + "\n");
			System.out.println("Требования к партнёру:\nПол - " + array[i].getRequirements().getPartnerGender() +
					"\nМинимальный возраст - " + array[i].getRequirements().getMinAge() + "\nМаксимальный возраст - " + array[i].getRequirements().getMaxAge());
			System.out.println("----------------------------------------");
		}
	}
}
