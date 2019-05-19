package Graphs;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	private int V;   // No. of vertices 
	private LinkedList<Integer> adj[]; // Adjacency List 

	//Constructor 
	public Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList<Integer>(); 
	} 

	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();

		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) 
			visited[i] = false; 

		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				topologicalSortUtil(i, visited, stack); 

		while (stack.empty()==false) 
			System.out.print(stack.pop() + " "); 


	}

	private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
		// Mark the current node as visited. 
		visited[v] = true; 

		for (Integer i : adj[v]) {
			if (!visited[i]) 
				topologicalSortUtil(i, visited, stack); 
		} 
		stack.push(new Integer(v)); 
	}

	// Function to add an edge into the graph 
	void addEdge(int v,int w) { adj[v].add(w); }


	// Driver method 
	public static void main(String args[]) 
	{ 
		// Create a graph given in the above diagram 
		Graph g = new Graph(6); 
		g.addEdge(5, 2); 
		g.addEdge(5, 0); 
		g.addEdge(4, 0); 
		g.addEdge(4, 1); 
		g.addEdge(2, 3); 
		g.addEdge(3, 1); 

		System.out.println("Following is a Topological " + 
				"sort of the given graph"); 
		g.topologicalSort(); 
	} 

}
