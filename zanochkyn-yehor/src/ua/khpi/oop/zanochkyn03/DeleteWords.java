package ua.khpi.oop.zanochkyn03;

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
	 * ����� findAndDelete, ���� ��������� �� ������� ������ �����
	 */
	public static void findAndDelete(String str, int count)
	{
		StringBuilder sbStr = new StringBuilder(str.substring(0));
		System.out.println("Default string: " + sbStr);
		int endPos = 0;
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
						if(endPos2 != -1)
							sb.delete(endPos2,sb.length());
						if(i != 0)
							if(sb.length() == count)
							{
								if(endPos2 != -1)
									sbStr.delete(i, endPos-1);
								else
									sbStr.delete(i, endPos+1);
								i = i - 1;
							}
							else	
								i = endPos;
						else
							if(sb.length() == count)
							{
								if(endPos2 != -1)
									sbStr.delete(i, endPos-1);
								else
									sbStr.delete(i, endPos+1);
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
		}
		System.out.println("Edited string: " + sbStr);
	}
	/**
	 * ����� isVowel, ���� �������� ����� ����� �����
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
	 * ����� findPunctMark, ���� ��������� �������, �� ��� � ������������� ����
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