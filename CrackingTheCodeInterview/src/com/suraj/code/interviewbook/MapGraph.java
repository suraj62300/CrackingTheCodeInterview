package com.suraj.code.interviewbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.suraj.code.graph.MapVertex;

public class MapGraph {

	private Map<MapVertex, List<MapVertex>> adjVertices;

	public MapGraph(Map<MapVertex, List<MapVertex>> adjVertices) {
		super();
		this.adjVertices = adjVertices;
	}

	public Map<MapVertex, List<MapVertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<MapVertex, List<MapVertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}

	public void addVertex(String label) {
	    adjVertices.putIfAbsent(new MapVertex(label), new ArrayList<MapVertex>());
	}
	
	void removeVertex(String label) {
		MapVertex v = new MapVertex(label);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new MapVertex(label));
	}
	
	void addEdge(String label1, String label2, int weight) {
		MapVertex v1 = new MapVertex(label1);
		MapVertex v2 = new MapVertex(label2, weight);
		adjVertices.get(v1).add(v2);
	//	adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(String label1, String label2) {
		MapVertex v1 = new MapVertex(label1);
		MapVertex v2 = new MapVertex(label2);
	    List<MapVertex> eV1 = adjVertices.get(v1);
	    List<MapVertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	List<MapVertex> getAdjVertices(String label){
		return adjVertices.get(new MapVertex(label));
	}
	
	double getDistance(String vertex1, String vertex2) {
	
		MapVertex v1 = new MapVertex(vertex1);
		MapVertex v2 = new MapVertex(vertex2);
		double distance = 0;
		Stack<MapVertex> stack = new Stack<MapVertex>();
		do {
			List<MapVertex> lists = adjVertices.get(v1);
			for(MapVertex list:lists) {
				if(list.equals(v2)) {
					distance = distance + list.getDistance();
					return distance;
				} else {
					stack.push(list);
				}
			}
			v1 = stack.pop();
			distance = v1.getDistance();
		} while(!stack.isEmpty());
		return 0;
	}
	
	Set<String> depthFirstTraversal(MapGraph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (MapVertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.getVertex());
	            }
	        }
	    }
	    return visited;
	}
	
	Set<String> breadthFirstTraversal(MapGraph graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (MapVertex v : graph.getAdjVertices(vertex)) {
	            if (!visited.contains(v.getVertex())) {
	                visited.add(v.getVertex());
	                queue.add(v.getVertex());
	            }
	        }
	    }
	    return visited;
	}

	public static void main(String[] args) {
		
		Map<MapVertex, List<MapVertex>> adjVertices = new HashMap<MapVertex, List<MapVertex>>();
		MapGraph graph = new MapGraph(adjVertices);
		graph.addVertex("Mumbai");
		graph.addVertex("Delhi");
		graph.addVertex("Kolkata");
		graph.addVertex("Chennai");
		graph.addEdge("Mumbai", "Delhi", 1424);
		graph.addEdge("Mumbai", "Kolkata", 2210);
		graph.addEdge("Mumbai", "Chennai", 1336);
	//	graph.addEdge("Delhi", "Chennai", 2201);
		graph.addEdge("Delhi", "Kolkata", 1531);
		graph.addEdge("Chennai", "Kolkata", 1670);
		graph.addEdge("Delhi", "Mumbai", 1424);
		graph.addEdge("Kolkata", "Mumbai", 2210);
		graph.addEdge("Chennai", "Mumbai", 1336);
	//	graph.addEdge("Chennai", "Delhi", 2201);
		graph.addEdge("Kolkata", "Delhi", 1531);
		graph.addEdge("Kolkata", "Chennai", 1670);
		
		System.out.println(adjVertices);
		
		Set<String> depthFirstTraversal = graph.depthFirstTraversal(graph, "Mumbai");
		System.out.println(depthFirstTraversal);
		Set<String> breadthFirstTraversal = graph.breadthFirstTraversal(graph, "Mumbai");
		System.out.println(breadthFirstTraversal);
		
		System.out.println(graph.getDistance("Delhi", "Chennai"));
		/*graph.removeVertex("Mumbai");
		System.out.println(adjVertices);*/
	}
	
}
