package Trees;

import java.util.ArrayList;
import java.util.List;

public class IsBST {

	/* Driver program to test all above functions */
	public static void main(String[] args)  
	{    
		Node root = new Node(6); 
		root.left = new Node(3); 
		root.right = new Node(7); 
		root.left.left = new Node(1); 
		root.left.right = new Node(4); 

		/* Print all root-to-leaf paths of the input tree */
		System.out.println(checkIsBST(root));
		System.out.println(kth_smallest_element(root, 4));
	}

	private static boolean checkIsBST(Node root) {
		// here we check the left subtree with -∞ and the right subtree is ∞, 
		// hence we use the min and max values for integers
		return checkIsBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ;
	}

	static boolean checkIsBST(Node root, int min, int max) {
		if (root == null) return true;
		
		if (root.data <= min || root.data > max) {
			return false;
		}
		return checkIsBST(root.left, min, root.data) && checkIsBST(root.right, root.data, max);
	}
	
	static int kth_smallest_element(Node root, int k) {
		List<Integer> arr = new ArrayList<>();
		helper(root,k, arr);
		return(arr.get(k-1));
	}

	private static void helper(Node root, int k,  List<Integer> arr) {
		if(root != null) {
			if (arr.size() == k) return;

			helper(root.left, k, arr);
			arr.add(root.data);
			helper(root.right, k, arr);
		}

	}
}
