
public class StringReverse {

	public static String reverseString(String string) {

		char[] arr = string.toCharArray();
		// char[] arr2 = new char[string.length()];
		char temp;
		int i = 0;
		int j = string.length() - 1;
		for (i = 0; i <= j; i++) {
			if (arr[i] != arr[j]) {
				break;
			}

			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			j--;
		}

		if (i >= j)
			System.out.println("yesysysysysy");
		return String.valueOf(arr);

	}

	public static void main(String[] args) {
		System.out.println("tharun - reverse is " + reverseString("malayalam"));
	}

}
