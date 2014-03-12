package bits;

public class ComputeMinMaxWOComp 
{
	public int findmin(int x,int y)
	{
		return(y+((x-y)&((x-y)>>31)));
	}
	public int findmax(int x,int y)
	{
		return (x-((x-y)&((x-y)>>31)));
	}
	public static void main(String args[])
	{
		ComputeMinMaxWOComp cmmwoc= new ComputeMinMaxWOComp();
		int x=23;
		int y=56;
		System.out.println("min "+cmmwoc.findmin(x, y));
		System.out.println("max "+cmmwoc.findmax(x, y));
	}
}
