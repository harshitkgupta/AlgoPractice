import java.math.BigInteger;
class HelloWorld {
	public static void main(String args[]) {
		System.out.println("Hello world - Java!");
        System.out.println(isPalindrome(null));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abc"));
        System.out.println(isPalindrome("test"));
        System.out.println(isPalindrome("atoyota"));
	}

    public static boolean isPalindrome(String str){
        if(str==null)
            return false;
        if("".equals(str))
            return true;
        boolean flag = true;
        int n = str.length();
        for(int i=0;i<n/2; i++){
            if(str.charAt(i)!=str.charAt(n-i-1)){
                flag = false;
                break;
            }
        }
        return flag;        
    }

    public BigInteger fact(int i){
        if(i<0)
            return new BigInteger("-1");
        if(i==0 || i == 1)
            return new BigInteger("1");

        return factInternal(new BigInteger(i+""));    

    }

    private BigInteger factInternal(BigInteger i){
        if(i==BigInteger.ONE)
            return BigInteger.ONE;
        return i.multiply(factInternal(i.subtract(BigInteger.ONE)));
    }
}
