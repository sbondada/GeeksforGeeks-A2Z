package strings;

public class atoi 
{
	public int stringToInteger(String str)
	{
		char[] strarray=str.toCharArray();
		int temp=0;
		for(int i : strarray)
		{
			temp=(temp*10)+(i-48);
		}
		return temp;
	}
	public static void main(String args[])
	{
		atoi a= new atoi();
		String str="1323342";
		int ap=a.stringToInteger(str);
		System.out.println(ap);
	}
}
