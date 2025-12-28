package accoliteHiring.sumOfDigits;

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long num=0;
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            num = s.nextLong();
            int sum=0;
            while(num>0)
            {
                sum+=num%10;
                num/=10;
            }
            arr.add(sum);
        }
        s.close();
        Collections.sort(arr);
        long ans=0;
        long pow=1;
        long mod=1000000007;
        for(int a : arr)
        {
            ans = (ans+ (pow*a)%mod )%mod;
            pow = (pow*2)%mod;
        }

        System.out.println(ans);
    }
}
