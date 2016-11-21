//用来求最大子序列的值
public class MaxSubSum{
	//In order to test my coding is correct
	public static void main(String[] args){
		int[] a ={-1,3,6,-5,7,-10,5};
		System.out.println(maxSubSum(a));
	}
	
	public static int maxSubSum(int[] a){
		//using sign maxSubSum
		int total = 0;
		//using dynamic sign subSum
		int sum = 0;
		for(int i=0;i<a.length;i++){
			sum+=a[i];
			if(sum>total)
				total = sum;
			if(sum<0)
				sum=0;
		}
		return total;
	}
}