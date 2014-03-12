package bits;

public class CountFlipsToChangeToANum 
{
	public int countFlips(int num1,int num2)
	{
		int xor=num1^num2;
		int count=0;
		while(xor!=0)
		{
			xor=xor&(xor-1);
			count++;
		}
		return count;
	}
	public static void main(String args[])
	{
		CountFlipsToChangeToANum cftc= new CountFlipsToChangeToANum();
		int num1=243;
		System.out.println(Integer.toBinaryString(num1));
		int num2=323;
		System.out.println(Integer.toBinaryString(num2));
		System.out.println(cftc.countFlips(num1, num2));
	}
}
