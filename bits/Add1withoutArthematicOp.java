package bits;

public class Add1withoutArthematicOp 
{
	public int addOne(int num)
	{
		int one=1;
		int mask=1;
		int carry=0;
		int sum=0;
		int i=0;
		while(mask!=0)
		{
			int temp;
			if(((mask&num) ^ (mask&one))>0)
			{
				temp=1;
			}
			else
			{
				temp=0;
			}
			System.out.println("temp "+temp);
	
			System.out.println("carry "+carry);
			int tempbit=(temp^carry)<<i;
			System.out.println("tempbit "+Integer.toBinaryString(tempbit));
			i++;
			sum=sum|tempbit;
			if(temp==1 && carry==0)
			{
				carry=0;
			}
			else if(!(temp==0 && (mask&num)>0) && temp!=1)
			{
				System.out.println("hi");
				carry=0;
			}
			else
			{
				carry=1;
			}
			mask=mask<<1;
		}
		return sum;
	}
	public static void main(String args[])
	{
		Add1withoutArthematicOp awao=new Add1withoutArthematicOp();
		int num=87;
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));
		int newnum=awao.addOne(num);
		System.out.println(newnum);
		System.out.println(Integer.toBinaryString(newnum));
	}
}
