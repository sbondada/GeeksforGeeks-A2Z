package bits;

public class TurnOffRightMostSetBIt 
{
	public int turnoffRightmostsetbit(int num)
	{
		int shifter=1;
		while((num&shifter)==0)
		{
			shifter=shifter<<1;
		}
		return (num^shifter);
	}
	public int turnoffrightmostsetbit(int num)
	{
		return (num&(num-1));
	}
	public static void main(String args[])
	{
		TurnOffRightMostSetBIt trmsb = new TurnOffRightMostSetBIt();
		int num=0b1100011011000;
		int offnum=trmsb.turnoffRightmostsetbit(num);
		int roffnum=trmsb.turnoffrightmostsetbit(num);
		System.out.println("orginal num "+Integer.toBinaryString(num));
		System.out.println("R off num "+Integer.toBinaryString(offnum));
		System.out.println("r off num "+Integer.toBinaryString(roffnum));
	}
}
