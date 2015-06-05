package encrypted.solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Decyprion {
	private static final String SEPARATOR = "~";
	public static String decryptMessage(String message) {
		//separate the message by half and swap the two pieces
		String firstHalf = message.substring(0, message.length() / 2);
		String secondHalf = message.substring(message.length() / 2);
		String swappedMessage = secondHalf + firstHalf;
		
		//get length of the alphabet and the key
		int indexOfFirstSeparator = swappedMessage.indexOf(SEPARATOR);
		int indexOfLastSeparator = swappedMessage.lastIndexOf(SEPARATOR);
		
		int lenAlphabet = Integer.parseInt(swappedMessage.substring(0, indexOfFirstSeparator));
		int lenKey = Integer.parseInt(swappedMessage.substring(indexOfLastSeparator + 1));
		
		//get the alphabet, key and encrypted message
		String alphabet = swappedMessage.substring(indexOfFirstSeparator + 1, indexOfFirstSeparator + 1 + lenAlphabet);
		String key = swappedMessage.substring(indexOfLastSeparator - lenKey, indexOfLastSeparator);
		String encryptedMessage = swappedMessage.substring(indexOfFirstSeparator + 1 + lenAlphabet, indexOfLastSeparator - lenKey);
		int lenEncrMessage = encryptedMessage.length();
		
		//get repeated key
		StringBuilder longKey = new StringBuilder();
		int keyIterator = 0;
		for (int i = 0; i < lenEncrMessage; i++) {
			if (keyIterator == lenKey) {
				keyIterator = 0;
			}
			longKey.append(key.charAt(keyIterator++));
		}
		
		//map alphabet to respective indices
		Map<Character, Integer> alphabetIndices = new HashMap<Character, Integer>();
		
		for (int i = 0; i < lenAlphabet; i++) {
			alphabetIndices.put(alphabet.charAt(i), i);
		}
		
		//get encrypted message and longKey indices;
		int[] encrMessageIndices = new int[lenEncrMessage];
		int[] longKeyIndices = new int[lenEncrMessage];
		
		for (int i = 0; i < lenEncrMessage; i++) {
			encrMessageIndices[i] = alphabetIndices.get(encryptedMessage.charAt(i));
			longKeyIndices[i] = alphabetIndices.get(longKey.charAt(i));
		}
		
		//calculating original message indices
		/**because length of the alphabet is lenAlphabet we can have maximum index of lenAlphabet - 1
		 */
		int[] originalMessageIndices = new int[lenEncrMessage];
		
		for (int i = 0; i < lenEncrMessage; i++) {
			int index = lenAlphabet + encrMessageIndices[i] - longKeyIndices[i];
			
			if (index > lenAlphabet - 1) {
				index = encrMessageIndices[i] - longKeyIndices[i];
			}
			
			originalMessageIndices[i] = index;
		}
		
		//get the original message
		StringBuilder originalMessage = new StringBuilder();
		
		for (int i = 0; i < lenEncrMessage; i++) {
			for (Entry<Character, Integer> entry : alphabetIndices.entrySet()) {
				if (entry.getValue() == originalMessageIndices[i]) {
					originalMessage.append(entry.getKey());
				}
			}
		}
		return originalMessage.toString();
	}
}
