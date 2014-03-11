package bits;

public class MultiplyBy3point5 
{
	public int multiplyWith3point5(int num)
	{
		return ((num<<1)+num+(num>>1));
	}
	public static void main(String args[])
	{
		MultiplyBy3point5 mb3p = new MultiplyBy3point5();
		int num=7;
		int newnum=mb3p.multiplyWith3point5(num);
		System.out.println(newnum);
	}
}
