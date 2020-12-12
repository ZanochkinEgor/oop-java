package ua.khpi.oop.zanochkyn07;

public class Main 
{
	public static void main(String[] args) 
	{
		 ClientList list = new ClientList();
		 InfoAboutYourself info = new InfoAboutYourself("Егор", 18, 185, "Синий", "Видео игры");
		 PartnerRequirements requirements = new PartnerRequirements("Женский", 18, 25);
		 list.array[0] = new Client("Мужской", 1, "01.05.2018", info, requirements);
		 info = new InfoAboutYourself("Катя", 17, 170, "Зелёный", "Вышивка, пение");
		 requirements = new PartnerRequirements("Мужской", 18, 25);
		 list.array[1] = new Client("Женский", 2, "12.12.2020", info, requirements);
		 list.print();
		 list.array[0].getInformation().setAge(99);
		 list.array[1].getRequirements().setMaxAge(30);
		 info = new InfoAboutYourself("Оля", 17, 170, "Красный", "Вышивка, пение");
		 list.array[1].setInformation(info);
		 list.print();
	}
}