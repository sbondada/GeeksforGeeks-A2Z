package arrays;

public class ArrayAcessing 
{
	public String ConvertBase(String no,int base ,int chardiff)
	{
		char[] noarray=no.toCharArray();
		int inc=0;
		int resultno=0;
		char temp;
		for(int i =noarray.length-1;i>=0;i--)
		{
			temp=noarray[i];
			if(temp>47 && temp<58)
			{
				resultno+=(int) ((temp-48)*Math.pow(base,inc));
			}
			else if ((temp|(int)Math.pow(2,5))>96 && (temp|(int)Math.pow(2,5))<123)
			{
				resultno+=(int) ((temp-chardiff)*Math.pow(base,inc));
			}
			inc++;
		}
		return Integer.toString(resultno);
	}
	public static void main(String args[])
	{
		ArrayAcessing aa= new ArrayAcessing();
		String str="BA";
		String result=aa.ConvertBase(str,26,65);
		System.out.println(result);
	}
}

//points to remember
//1. need to compute the values only in base 10 so convert the base 26 to base 10
//2. least significant bit is always to the right
//3. check for the character case