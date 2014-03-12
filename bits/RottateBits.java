package bits;

public class RottateBits 
{
	public int circularRightShift(int num,int shift) 
	{
		return (num>>>shift)|(num<<(32-shift));
	}
	public int circularLeftShift(int num,int shift) 
	{
		return (num<<shift)|(num>>>(32-shift));
	}
	public static void main(String args[])
	{
		RottateBits rb = new RottateBits();
		int num=643;
		System.out.println(Integer.toBinaryString(num));
		int shift=3;
		System.out.println(Integer.toBinaryString(rb.circularRightShift(num, shift)));
		System.out.println(Integer.toBinaryString(rb.circularLeftShift(num, shift)));
	}
}
