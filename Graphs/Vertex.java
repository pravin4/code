package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	List<Vertex> neighbours;
	public int label;

	Vertex(int label) {
		this.label = label;
	}

	public void setNeighbours(int[] arr) {
		this.neighbours = new ArrayList<Vertex> (); 
		for (int i : arr) {
			this.neighbours.add(new Vertex(i));
		}
	}

	public Vertex getConnectedNode(int i) {
		for (Vertex v: this.neighbours) {
			if (v.label == i) return v;
		}
		return null;
	}

}
