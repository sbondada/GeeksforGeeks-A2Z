package bits;

public class SwapValues 
{
	public static void main(String args[])
	{
		int x=12;
		int y=23;
		System.out.println("x "+x+" y "+y);
		x=x^y;
		y=x^y;
		x=x^y;
		System.out.println("x "+x+" y "+y);
	}
}
