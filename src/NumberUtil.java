import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtil {
	//prime checking O(sqrt(n)) checking 6n-1 and 6n+1
	public static boolean isPrime(long num){
		if(num <= 1)
			return false;
		if(num == 2 || num == 3)
			return true;
		if(num % 2 == 0 || num % 3 == 0)
			return false;
		for(long i = 5; i*i <= num; i+=6){
			if(num % i == 0 || num % (i+2) == 0)
				return false;
		}
		return true;
	}
	
	//modular exponentation
	public static long pow(long num, long p, long m){
		long result = 1;
		num = num % m;
		while(p > 0){
			if(p & 1 == 1)
				result = (result * num) % m;
			num = (num * num) % m;
			p = p >> 1;
		}
		return result;
	}
	
	public static boolean isPrimeFermat(long num, int k){
		if(num <= 1)
			return false;
		if(num == 2 || num == 3)
			return true;
		if(num % 2 == 0 || num % 3 == 0)
			return false;	
		for(int i = 0; i < k ; k++){
			if(!fermatTest(num))
				return false;
		}
		return true;
	}
	
	private static boolean fermatTest(long num){
		Random random = new Random();
		long a = 2 + random.nextLong() % (num-4);
		return pow(a, num-1, num) == 1;
	}
	
	public static boolean isPrimeMillerRabin(long num, int k){
		if(num <= 1)
			return false;
		if(num == 2 || num == 3)
			return true;
		if(num % 2 == 0 || num % 3 == 0)
			return false;
		long d = num-1;
		while(d % 2 ==0)
			d = d >> 1;
		for(int i = 0; i < k ; k++){
			if(!millerTest(d,num))
				return false;
		}
		return true;
	}

	private static boolean millerTest(long d, long num) {
		Random random = new Random();
		long a = 2 + random.nextLong() % (num-4);
		long x = pow(a, d, num);
		if(x == 1 || x == num-1)
			return true;
		while(d != num-1){
			x = (x * x) % num;
			d = d * 2;
			if(x == 1)
				return false;
			if(x == num-1)
				return true;
		}
		return false;
	}
	
	public static List<Integer> getPrimeSieve(int N){
		boolean isprime[] = new boolean[N+1];
		for(int i = 2; i <= N; i++){
			isprime[i] = true;
		}
		for(int i = 2; i * i <= N; i++){
			if(isprime[i]){
				for(int j = i + i; j <= N ; j += i)
					isprime[j] = false;
			}				
		}
		List<Integer> primeList = new ArrayList<>();
		primeList.add(2);
		for(int i = 3; i <= N; i += 2){
			if(isprime[i])
				primeList.add(i);
		}
		return primeList;
	}
	
	public static List<Integer> getPrimeSegmentedSieve(int N){
		int limit = (int) Math.ceil(Math.sqrt(N));
		List<Integer> primeList = getPrimeSieve(limit);
		int low = limit + 1;
		int high = 2 * limit;
		boolean isprime[] = new boolean [limit];
		while(low < N){
			for(int i = low; i <= high; i++){
				isprime[i-low] = true;
			}
			for (int i = 0; i < primeList.size(); i++)
	        {
				int primeNum = primeList.get(i);
				int loLim = (int) (Math.floor(low/primeNum) * primeNum);
				if(loLim < low)
					loLim += primeNum;
				for(int j = loLim; j <= high; j += primeNum)
					isprime[j - low] = false;
	        }
			for(int i = low; i <= high; i++){
				if(isprime[i-low])
					primeList.add(i);
			}
			low += limit;
			high += limit;
			if(high >= N)
				high = N;
		}
		return primeList;
	}
	
	public static List<Long> getPrimeFactors(long num){
		List<Long> primeFactors = new ArrayList<>();
		if(num <= 1)
			return primeFactors;
		while(num % 2 == 0){
			primeFactors.add(2L);
			num /= 2;
		}
		for(long i = 3; i*i <= num; i+=2){
			while(num % i == 0){
				primeFactors.add(i);
				num /= i;
			}	
		}
		if(num>1)
			primeFactors.add(num);
		return primeFactors;
	}
	static int smallestPrimeFactor[] ;
	public static int[] getLeastPrimeFactor(int N){
		smallestPrimeFactor = new int[N+1];
		for(int i = 1; i <= N; i++)
			smallestPrimeFactor[i] = i;
		for(int i = 4; i <= N; i+=2){
			smallestPrimeFactor[i] = 2;				
		}
		for(int i = 3; i*i <= N; i += 2){
			if(smallestPrimeFactor[i] == i)
				for(int j = i * i; j <= N; j+=i)
					if(smallestPrimeFactor[j] == j)
						smallestPrimeFactor[j] = i;
		}
		return smallestPrimeFactor;
	}
	
	public static List<Integer> getPrimeFactorsSieve(int num){
		List<Integer> primeFactors = new ArrayList<>();
		while(num != 1){
			primeFactors.add(smallestPrimeFactor[num]);
			num /= smallestPrimeFactor[num];
		}
		return primeFactors;
	}
}
