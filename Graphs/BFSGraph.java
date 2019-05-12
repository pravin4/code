package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * BFS traversal of a graph, first prints the distance from start to target node
 * also prints path of the start to target nodex`x`x`
 * @author prajadhav
 *
 */
public class BFSGraph {

	public static void main(String[] args) {
		Vertex start = new Vertex(1);
		start.setNeighbours(new int[] {2,3});
		Vertex next = start.getConnectedNode(2);
		next.setNeighbours(new int[] {4});
		
		Vertex next1 = start.getConnectedNode(3);
		next1.setNeighbours(new int[] {5,6});
		
		Vertex next2 = next1.getConnectedNode(5);
		next2.setNeighbours(new int[] {7});
		
		Vertex next3 = next1.getConnectedNode(6);
		next3.setNeighbours(new int[] {8});
		
		Vertex next4 = next2.getConnectedNode(7);
		next4.setNeighbours(new int[] {8});
		
		System.out.println(BFS(start, new Vertex(8)));
	}

	static List<Integer> BFS(Vertex start, Vertex target) {

		Queue<Vertex> bfsQueue = new LinkedList<Vertex> ();
		Set<Integer> seen = new HashSet<Integer> ();
		int[] distance = new int[10];
		Vertex[] prev = new Vertex[10];
		
		// add the start node to the queue
		bfsQueue.add(start);
		seen.add(start.label);
		distance[start.label] = 0;

		while (!bfsQueue.isEmpty()) {			
			Vertex currentNode = bfsQueue.poll();

			if (currentNode.label == target.label) {
				//return distance[target.label]; // returns the distance if found
				return buildPath(prev, target); // builds the path when found
			}
			
			if (currentNode.neighbours != null) {
				for (Vertex child : currentNode.neighbours) {
					if (!seen.contains(child.label)) { // only add if not already visited
						seen.add(child.label);
						bfsQueue.add(child);
						distance[child.label] = distance[currentNode.label] + 1; // distance at each level in graph
						prev[child.label] = currentNode; //records the path that is traversed
					}
				}
			}
		}
		return null;
	}

	// builds the path that is created from the loop above
	private static List<Integer> buildPath(Vertex[] prev, Vertex target) {		
		List<Integer> path = new ArrayList<Integer> ();		
		Vertex cur = target;
		while (prev[cur.label] != null) {
			// loops over from the target to the path and adds it to the list
			path.add(cur.label);
			cur = prev[cur.label];
		}
		path.add(cur.label);
		Collections.reverse(path); // prints in reverse order since we are traversing up
		return path;
	}
}
