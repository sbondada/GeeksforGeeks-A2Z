package strings;

public class WildCardStringMatch 
{
	public boolean match(String a,int i,String b,int j)
	{
		if(i<a.length() && j<b.length())
		{
			if(a.charAt(i)=='?' || a.charAt(i)==b.charAt(j))
			{
				System.out.println(a.charAt(i));
				return match(a, i+1, b, j+1);
			}
			else if(a.charAt(i)=='*')
			{
				System.out.println(a.charAt(i));
                return (match(a,i+1,b,j) || match(a, i, b, j+1) || match(a,i+1,b,j+1));
			}
			else
			{
				return false;
			}
		}
		else
		{
			if(i==a.length() && j==b.length())
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public static void main(String args[])
	{
		WildCardStringMatch wcsm = new WildCardStringMatch();
		String a="ab?cd*";
		String b="abecdefg";
		System.out.println(wcsm.match(a,0,b,0));
	}
}