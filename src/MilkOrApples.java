package java8lambdabasics;

public class MilkOrApples {
	
	public static void main(String args[])
	{
		int milk[]={1,2,1};
		int apples[] = {100,9,50};
		int dp[][]=new int[3][1001];
		for(int j=0;j<=1000;j++)
			dp[2][j]=apples[2];
		for(int i=0;i<=1;i++)
			dp[i][0]=apples[i];
		for(int i=1;i>=1;i--)		
		{
			for(int j=0;j<=100;j++)
			{
				if(j!=0)
				dp[i][j]= Math.max(dp[i][j],dp[i+1][j-1]+apples[i]);
				//if(j+-1+milk[i]<=3)
				if(j-1+milk[i]>=0)
					dp[i][j]=Math.max(dp[i][j],dp[i+1][j-1+milk[i]]);
			}	
		}
		for(int i=0;i<=2;i++)		
		{
			for(int j=0;j<=8;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("");
		}
		
	}

}
