package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DFS {

	static void dfs(List<Vertex> adjList) {

		Set<Integer> seen = new HashSet<Integer> ();
		List<Integer> path = new ArrayList<Integer> ();
		for (Vertex v: adjList) {
			if (!seen.contains(v.label)) {
				explore(v, seen, path);
				System.out.print(path + " ");
			}
		}
	}

	static void explore(Vertex cur, Set<Integer> seen, List<Integer> comp ) {
		seen.add(cur.label);
		comp.add(cur.label);
		
		for (Vertex nxt: cur.neighbours) {
			if (!seen.contains(nxt.label)) {
				explore(nxt, seen, comp);
			}
		}
	}
}
