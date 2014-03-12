package bits;

public class PerformModulusDivision 
{
	public int performModulus(int num,int divisor)
	{
		int mask=1;
		int newmask=1;
		while ((divisor&mask)==0)
		{
			newmask=newmask|mask;
			mask=mask<<1;
		}
		return (num&newmask);

	}
	public static void main(String args[])
	{
		PerformModulusDivision pmd = new PerformModulusDivision();
		int num=537;
		int divisor=16;
		int remainder=pmd.performModulus(num, divisor);
		System.out.println("Remainder "+remainder);
		System.out.println("mod remainder "+num%divisor);
	}
}
