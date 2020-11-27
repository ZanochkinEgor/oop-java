package ua.khpi.oop.zanochkyn04;

/**
 * ���� DeleteWords, ���� ������� �� ����� ������ �������, 
 * �� ����������� �� ���������� �����.
 * 
 * @author Zanochkyn Yehor
 * @version 1.0 22/10/20
 */
public class DeleteWords 
{
	/**
	 * ����� findAndDelete, ���� ��������� �� ������� ������ �����.
	 */
	public static void findAndDelete(String str, int count, boolean debug)
	{
		StringBuilder sbStr = new StringBuilder(str);
		System.out.println("\nDefault string: " + sbStr);
		int endPos = 0;
		if(debug)
			System.out.println("\nCurrent text: " + sbStr + "\n");
		for (int i = 0; i < sbStr.length(); i++)
		{
			endPos = findPunctMark(sbStr,i);
			if(!Character.isDigit(sbStr.charAt(i)))
			{
				if(Character.isAlphabetic(sbStr.charAt(i)))
				{
					if (isVowel(sbStr.charAt(i)) == false) 
					{
						StringBuilder sb = new StringBuilder(sbStr.substring(i, endPos));
						int endPos2 = findPunctMark(sb,0);
						boolean flag = false;
						if(endPos2 == -1)
							flag = true;
						while(endPos2 != -1)
						{
							sb.delete(endPos2,sb.length());
							endPos--;
							endPos2 = findPunctMark(sb,0);
						}
						if(debug)
							System.out.println("Current word: " + sb);
						if(endPos == sbStr.length()-1)
							if(sb.length() == count)
							{
								sbStr.delete(i, endPos);
								i = i - 1;
							}
							else	
								i = endPos;
						else
							if(sb.length() == count)
							{
								if(flag)
									sbStr.delete(i, endPos+1);
								else	
									sbStr.delete(i, endPos);
								i = i - 1;
							}
							else	
								i = endPos;
					} 
					else
						i = endPos;
				}	
			}
			else
				i = endPos;
			if(debug)
				System.out.println("Current text: " + sbStr);
		}
		System.out.println("\nEdited string: " + sbStr);
	}
	/**
	 * ����� isVowel, ���� �������� ����� ����� �����.
	 */
	public static boolean isVowel(char c) 
	{
        switch (Character.toLowerCase(c)) 
        {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
                return true;
            default:
                return false;
        }
    }
	/**
	 * ����� findPunctMark, ���� ��������� �������, �� ��� � ������������� ����.
	 */
	public static int findPunctMark(StringBuilder a, int num)
	{
		int endPos = a.indexOf(" ", num);
		if(endPos == -1)
			endPos = a.indexOf(".", num);
		if(endPos == -1)
			endPos = a.indexOf("!", num);
		if(endPos == -1)
			endPos = a.indexOf("?", num);
		if(endPos == -1)
			endPos = a.indexOf(",", num);
		if(endPos == -1)
			endPos = a.indexOf(";", num);
		if(endPos == -1)
			endPos = a.indexOf(":", num);
		if(endPos == -1)
			endPos = a.indexOf("-", num);
		if(endPos == -1)
			endPos = a.indexOf("\\", num);
		if(endPos == -1)
			endPos = a.indexOf("/", num);
		if(endPos == -1)
			endPos = a.indexOf("|", num);
		if(endPos == -1)
			endPos = a.indexOf(")", num);
		if(endPos == -1)
			endPos = a.indexOf("(", num);
		if(endPos == -1)
			endPos = a.indexOf("@", num);
		if(endPos == -1)
			endPos = a.indexOf("#", num);
		if(endPos == -1)
			endPos = a.indexOf("$", num);
		if(endPos == -1)
			endPos = a.indexOf("%", num);
		return endPos;
	}
}