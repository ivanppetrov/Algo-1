package palindromes.solution;

public class Palindoromes {
	
	private static boolean isPalindrome(String text) {
		String firstHalf = null, secondHalf = null;
		int halfTextLength = text.length() / 2;
		if (text.length() % 2 == 0) {
			firstHalf = text.substring(0, halfTextLength);
			secondHalf = text.substring(halfTextLength);
		} else {
			firstHalf = text.substring(0, halfTextLength);
			secondHalf = text.substring(halfTextLength + 1);
		}
		
		return firstHalf.equalsIgnoreCase(new StringBuilder(secondHalf).reverse().toString());
	}
	
	public static String getAllPalindromes(String text) {
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < text.length(); i++) {
			if (isPalindrome(text)) {
				result.append(text);
				result.append("\n");
			}
			text = text.substring(1) + text.charAt(0);
		}
		
		return result.length() == 0 ? "NONE" : result.toString();
	}
}
