import java.util.ArrayList;
import java.util.Arrays;

public class VowelPurser {

	public static void main(String[] args) {
		System.out.println(disemvowel("This website is for losers LOL!"));
	}


	public static String disemvowel(String str) {

		// ?i makes the regular expression case insensitive
        //return str.replaceAll("(?i)[aeiou]" , "");

        double sqrt = Math.sqrt(114);
        long result = (long) Math.floor(sqrt);  
        System.out.println(sqrt + " " + result);
        
		ArrayList<String> vowels = new ArrayList<String> (Arrays.asList("a","e","i","o","u","A","E","I","O","U"));

		StringBuilder mutatedString = new StringBuilder();
		for (int i=0; i < str.length(); i++) {
			if (!vowels.contains(String.valueOf(str.charAt(i)))) {
				mutatedString.append(str.charAt(i));
			}
		}
		return mutatedString.toString();
	}
}
