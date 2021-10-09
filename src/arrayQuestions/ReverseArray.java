package arrayQuestions;

// Question 1 from DSA Cracker sheet

public class ReverseArray {

	/* Reverses an array iteratively */
	public static void reverseArray(int arr[]) {
		int start = 0, end = arr.length - 1;
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	
	/* Reverses an array recursively */
	public static void reverseArrayRecursively(int arr[], int start, int end) {
		if(start >= end) return;
		
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		
		reverseArrayRecursively(arr, ++start, --end);
	}
	
	/* Reverses a string iteratively. Notice we need to use StringBuilder for manipulation in String */
	public static String reverseString(String str) {
		int start = 0, end = str.length() - 1;
		StringBuilder strCopy = new StringBuilder(str);
		while(start < end) {
			char temp = strCopy.charAt(start);
			strCopy.setCharAt(start, strCopy.charAt(end));
			strCopy.setCharAt(end, temp);
			++start;
			--end;
		}
		return strCopy.toString();
	}
	
	public static void main(String[] args) {
		int arr[] = {4,5,1,2};
		// ReverseArray.reverseArray(arr);
		ReverseArray.reverseArrayRecursively(arr, 0, arr.length-1);
		ReverseArray.printIntArray(arr);
		
		String myString = "randomstring";
		String myReversedString = ReverseArray.reverseString(myString);
		System.out.println(myReversedString);
	}
	
	public static void printIntArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
