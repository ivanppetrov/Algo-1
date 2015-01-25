package project1;

import java.util.Arrays;


public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
    	if (number % 2 != 0) {
			return true;
		} else {
			return false;
		}
    }

    @Override
    public boolean isPrime(int number) {
    	if (number % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i <= number; i+=2) {
			if (number % i == 0) {
				return false;
			}
		}
		
		return true;
    }

    @Override
    public int min(int... array) {
    	int min = array[0];		//default value for the minimum element is the first element in the array
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				min = array[i];
			}
		}
		
		return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
    	int[] sorted = new int[array.length];
		int sortedIndex = 0;
		Arrays.sort(array);
		sorted[sortedIndex] = array[0];
		sortedIndex++;
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] != array[i]) {
				sorted[sortedIndex] = array[i];
				sortedIndex++;
			}
		}
		return sorted[k - 1];
    }

    @Override
    public float getAverage(int[] array) {
    	Arrays.sort(array);
		return array[array.length / 2];
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
    	long smallest = upperBound;
		
		while (upperBound > 1) {
			upperBound--;
			if (smallest % upperBound != 0) {
					smallest /= upperBound;
			}
		}
		
		return smallest;
    }

    @Override
    public long getLargestPalindrome(long n) {
    	long palindorme = 0;
		
		while (palindorme == 0) {
			if (isPalindrome(n)) {
				palindorme = n;
			}
			n--;
		}
		
		return palindorme;
    }
    
    //helper function
    public boolean isPalindrome(long n) {
		long reversed = 0, digit = 0, number = n;
		 while (number > 0)
		 {
		      digit = number % 10;
		      reversed = reversed * 10 + digit;
		      number = number / 10;
		 }
		 
		 if (n == reversed) {
			 return true;
		 }
		 return false;
	}

    @Override
    public int[] histogram(short[][] image) {
    	int histogram[] = new int[image.length * image[0].length];
		
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				histogram[image[i][j]]++;
			}
		}
		
		return histogram;
    }

    @Override
    public long doubleFac(int n) {
    	int fac = 1, doubleFac = 1;
		
		for (int i = 1; i <= n; i++) {
			fac *= i;
		}
		
		for (int i = 1; i <= fac; i++) {
			doubleFac *= i;
		}
		
		return doubleFac;
    }

    @Override
    public long kthFac(int k, int n) {
    	long fac = 1, tempFac = n;
		int loops = 0;
		
		while (loops < k) {
			fac = 1;
			for (int i = 1; i <= tempFac; i++) {
				fac *= i;
			}
			tempFac = fac;
			loops++;
		}
		
		return fac;
    }

    @Override
    public int getOddOccurrence(int[] array) {
    	int number = 0;
		int[] histogram = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			histogram[array[i]]++;
		}
		
		for (int i = 0; i < histogram.length; i++) {
			if (i != 0) {
				if (isOdd(histogram[i])){
					number = i;
					break;
				}
			}
		}
		
		return number;
    }

    @Override
    public long pow(int a, int b) {
    	int power = a;
		while (b > 1) {
			power *= a;
			b--;
		}
		
		return power;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
    	int scalar = 0;
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = a.length - 1; i >= 0 ; i--) {
			scalar += a[i] * b[i];
		}
		
		return scalar;
    }

    @Override
    public int maxSpan(int[] array) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean canBalance(int[] array) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        char[] characters = argument.toCharArray();
        String reversed = "";
        
        for (int i = characters.length - 1; i >= 0; i--) {
			reversed += characters[i];
		}
        
        return reversed;
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] splited = arg.split(" ");
        String word, reversed = "";
        
        for (int i = 0; i < splited.length; i++) {
        	word = reverseMe(splited[i]);
        	reversed += word + " ";
        }
        
        return reversed;
    }
    
    @Override
    public String copyEveryChar(String input, int k) {
        char[] characters = input.toCharArray();
        String result = "";
        for (int i = 0; i < characters.length; i++) {
			if (Character.isLetter(characters[i])) {
				for (int j = 0; j < k; j++) {
					result += characters[i];
				}
			} else {
				result += " ";
			}
		}
        return result;
    }


    @Override
    public boolean isPalindrome(String argument) {
        char[] characters = argument.toCharArray();
        String reversed = "";
        int length = characters.length;
        for (int i = 0; i < length/2; i++) {
        	if (characters[i] != characters[length - 1 - i]) {
        		return false;
        	}
		}
        
        return true;
    }

    @Override
    public boolean isPalindrome(int n) {
    	long reversed = 0, digit = 0, number = n;
		 while (number > 0)
		 {
		      digit = number % 10;
		      reversed = reversed * 10 + digit;
		      number = number / 10;
		 }
		 
		 if (n == reversed) {
			 return true;
		 }
		 return false;
    }

    @Override
    public int getPalindromeLength(String input) {
        String[] splited = input.split("\\*");
        char[] firstPart = splited[0].toCharArray(), secondPart = splited[1].toCharArray();
        int firstIndex = firstPart.length - 1, secondIndex = 0;	//indexes for the first and the second array of characters
        int length = 0;  //length of the palindrome
        
        while (firstIndex >= 0 && secondIndex < secondPart.length && isPalindrome(firstPart[firstIndex] + "" + secondPart[secondIndex])) {
        	firstIndex--;
        	secondIndex++;
        	length++;
        }
        
        return length;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String decodeURL(String input) {
        return input.replaceAll("%20", " ").replaceAll("%3A", ":").replaceAll("%3D", "?").replaceAll("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        int sum = 0;
        
        for (int i = 0; i < input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				sum += Character.getNumericValue(input.charAt(i));
			}
		}
        
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        // TODO Auto-generated method stub
        return false;
    }
    
    public static void main(String[] args) {
    	Problems2Impl instance = new Problems2Impl();
    	
    	System.out.println(instance.sumOfNumbers("000 three five -1 1"));
    }

}