package ua.khpi.oop.zanochkyn07;

public class Main 
{
	public static void main(String[] args) 
	{
		 ClientList list = new ClientList();
		 InfoAboutYourself info = new InfoAboutYourself("����", 18, 185, "�����", "����� ����");
		 PartnerRequirements requirements = new PartnerRequirements("�������", 18, 25);
		 list.array[0] = new Client("�������", 1, "01.05.2018", info, requirements);
		 info = new InfoAboutYourself("����", 17, 170, "������", "�������, �����");
		 requirements = new PartnerRequirements("�������", 18, 25);
		 list.array[1] = new Client("�������", 2, "12.12.2020", info, requirements);
		 list.print();
		 list.array[0].getInformation().setAge(99);
		 list.array[1].getRequirements().setMaxAge(30);
		 info = new InfoAboutYourself("���", 17, 170, "�������", "�������, �����");
		 list.array[1].setInformation(info);
		 list.print();
	}
}