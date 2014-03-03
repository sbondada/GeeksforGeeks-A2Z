package bits;

public class IgnoreCasecompare 
{
	public boolean checkSimilarity(String str1,String str2)
	{
		if(str1.length()!=str2.length())
		{
			return false;
		}
		int i=0;
		while(i<str1.length())
		{
			int intstr1=(int)str1.charAt(i);
			int intstr2=(int)str2.charAt(i);
			int temp=0x00000020;  //shifting the 6th bit. (very important to match)
			if(!(intstr1==intstr2 | (intstr1^temp)==intstr2))
			{
				return false;
			}
			i++;
		}
		return true;
	}
	public static void main(String args[])
	{
		String str1="hello";
		String str2="hElLO";
		IgnoreCasecompare icc=new IgnoreCasecompare();
		if(icc.checkSimilarity(str1, str2))
		{
			System.out.println("they are similar");
		}
		else
		{
			System.out.println("they aren't the same");
		}
	}
}
