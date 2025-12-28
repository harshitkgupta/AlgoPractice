package rle;

public class RunLengthEncodingUtil {
	public static void convertToRLE(char arr[]){
		validateEvenLength(arr.length);
		validateOnlyValidCharacter(arr);
		int n = arr.length/2;
		for(int i=0; i <n; i++){
			arr[i+n] = arr[i];
		}
		
	}

	private static void validateOnlyValidCharacter(char[] arr) {
		for(int i=0; i <arr.length/2; i++){
			if(!Character.isAlphabetic(arr[i]))
				throw new IllegalArgumentException("First half of string should be alphanumeric");
		}
		for(int i=0; i <arr.length/2; i++){
			if(Character.isWhitespace(arr[i]))
				throw new IllegalArgumentException("Second half of string should be whitespace");
		}
	}

	private static void validateEvenLength(int length) {
		if(length%2 !=0)
			throw new IllegalArgumentException("length of string should be even");
	}
}
