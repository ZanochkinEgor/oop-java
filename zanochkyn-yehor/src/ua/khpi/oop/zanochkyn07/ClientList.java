package ua.khpi.oop.zanochkyn07;

public class ClientList 
{
	Client array[] = new Client[2];
	
	/*
	 * ����� print, �� �������� ���������� ��� �볺��� �� �����
	 */
	public void print()
	{
		for(int i = 0; i < array.length; i++)
		{
			System.out.println("ID - " + array[i].getId() + "\n���� ����������� - " + array[i].getDate() + "\n��� - " + array[i].getClientGender() + "\n"); 
			System.out.println("���������� � ����:\n��� - " + array[i].getInformation().getName() + "\n������� - " + array[i].getInformation().getAge() +
					"\n���� - " + array[i].getInformation().getHeight() + "\n���� ���� - " + array[i].getInformation().getEyeColour() + 
					"\n����� - " + array[i].getInformation().getClientHobby() + "\n");
			System.out.println("���������� � �������:\n��� - " + array[i].getRequirements().getPartnerGender() +
					"\n����������� ������� - " + array[i].getRequirements().getMinAge() + "\n������������ ������� - " + array[i].getRequirements().getMaxAge());
			System.out.println("----------------------------------------");
		}
	}
}
