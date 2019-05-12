package Recursion;

/**
 * swap every n-1 till n=0, source to temp and then temp to dest
 * in the meanwhile you print the current state of the recursion of src and dest, which are source and temp
 * and temp and dest respectively
 * @author prajadhav
 *
 */
public class TowersHanoi {
	
	public static void main(String[] args) {
		int n = 3	;
		String src = "src", dest = "dest", tmp = "tmp";
		towersofHanoi(n, src, dest, tmp);
	}

	static void towersofHanoi(int n, String src, String dest, String tmp) {
		
		if (n==0) return;
		
		towersofHanoi(n-1, src, tmp, dest);
		
		System.out.println("Move disk " + n + " from " + src + " to " + dest);
		
		towersofHanoi(n-1, tmp, dest, src);

	}
}
