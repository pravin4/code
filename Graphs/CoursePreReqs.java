package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CoursePreReqs {

	public static void main(String[] args) {
		List<List<Integer>> prerequisites = new ArrayList<>();

		List<Integer> eItems = new ArrayList<>();
		eItems.add(1);
		eItems.add(0);
		prerequisites.add(eItems);
		
		eItems = new ArrayList<>();
		eItems.add(2);
		eItems.add(0);
		prerequisites.add(eItems);
		
		eItems = new ArrayList<>();
		eItems.add(3);
		eItems.add(1);
		prerequisites.add(eItems);
		
		eItems = new ArrayList<>();
		eItems.add(3);
		eItems.add(2);
		prerequisites.add(eItems);


		List<Integer> result = course_schedule(4, prerequisites);
		System.out.println(result);
	}

	static List<Integer> course_schedule(int n, List<List<Integer>> prerequisites) {
		List<Integer>[] adjList = new ArrayList[n];
		List<Integer> courseOrder = new ArrayList<Integer>();
		int[] inDegree = new int[n];

		// initialize the adjacency list
		for (int i=0; i<n; i++) {
			adjList[i]= new ArrayList<Integer>();
		}

		// setup the adjacency list and the indegree of each vertex/course
		for (List<Integer> preReq: prerequisites){
			int courseId = preReq.get(0);
			int preReqCourseId = preReq.get(1);
			adjList[preReqCourseId].add(courseId);
			inDegree[courseId]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		// do a BFS with adding the indegree of 0 as the first element
		for (int i=0; i<inDegree.length; i++){
			if (inDegree[i] == 0)
				queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			int courseId = queue.poll();
			courseOrder.add(courseId);
			// get all the edges from the adjacency list for each course, decrease the in degree and continue
			for(int i=0; i < adjList[courseId].size(); i++){
				int neighborCourseId = adjList[courseId].get(i);
				inDegree[neighborCourseId]--;
				// add to the queue if and only if the indegree becomes 0 which means all prereqs are satisfied
				if (inDegree[neighborCourseId] == 0){
					queue.add(neighborCourseId);
				}
			}
		}
		
		// if all the courses are found return that order
		if (courseOrder.size() == n) return courseOrder;
		else {
			List<Integer> list=new ArrayList<Integer>();
			list.add(-1);
			return list;
		}
	}
}
