
public class TestSolution {
	
    public static int maxGap(int[] numbers)
    {
      for (int i=0; i<numbers.length; i++) {
        for (int j=0; j<i; j++) {
          if (numbers[i] > numbers[j]) {
            int temp = numbers[j];
            numbers[j] = numbers[i];
            numbers[i] = temp;
          }
        }
      }
      int max = 0;
      for (int i=0; i < numbers.length; i++) {
        max = Math.max(max, numbers[i] - numbers[i+1]);
      }
      return max;
    }
    
    public static String solve(final String str) {

        StringBuilder s1 = new StringBuilder(str);
        int lowerCount = 0;
        int upperCount = 0;
        for (int i=0; i<s1.length(); i++) {
          Character c = s1.charAt(i);
          if (Character.isLowerCase(c)) {
        	  lowerCount++;
          } else 
          {
        	  upperCount++;
          }
        }
        if (upperCount > lowerCount) {
          return str.toUpperCase();
        } else {
          //return str.toLowerCase();
        }
        return str.chars().filter(Character::isLowerCase).count() >= str.chars().filter(Character::isUpperCase).count()
        ? str.toLowerCase()
        : str.toUpperCase();
      }
    
    public static String maskify(String str) {
        if (str.length()<4) {
            return str;
          }
        str = str.replaceAll("\\s", "e"); 
        return (str.replaceAll("\\w(?=\\w{4})", "#"));
     }
    
    
    public static void main(String[] args) {
    	System.out.println(maskify("Nananananananananananananananana Batman!%"));
	}

}
