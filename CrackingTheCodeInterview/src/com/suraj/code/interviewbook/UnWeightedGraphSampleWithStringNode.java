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

import com.suraj.code.graph.Vertex;

public class UnWeightedGraphSampleWithStringNode {
	
	private Map<Vertex, List<Vertex>> adjVertices;
	
	public UnWeightedGraphSampleWithStringNode(Map<Vertex, List<Vertex>> adjVertices) {
		super();
		this.adjVertices = adjVertices;
	}

	public Map<Vertex, List<Vertex>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
		this.adjVertices = adjVertices;
	}

	void addVertex(String label) {
	    adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
	}
	 
	void removeVertex(String label) {
	    Vertex v = new Vertex(label);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex(label));
	}
	
	void addEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    adjVertices.get(v1).add(v2);
	    adjVertices.get(v2).add(v1);
	}
	
	void removeEdge(String label1, String label2) {
	    Vertex v1 = new Vertex(label1);
	    Vertex v2 = new Vertex(label2);
	    List<Vertex> eV1 = adjVertices.get(v1);
	    List<Vertex> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	List<Vertex> getAdjVertices(String label) {
	    return adjVertices.get(new Vertex(label));
	}
	
	Set<String> depthFirstTraversal(UnWeightedGraphSampleWithStringNode graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (Vertex v : graph.getAdjVertices(vertex)) {              
	                stack.push(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	Set<String> breadthFirstTraversal(UnWeightedGraphSampleWithStringNode graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (Vertex v : graph.getAdjVertices(vertex)) {
	            if (!visited.contains(v.getLabel())) {
	                visited.add(v.getLabel());
	                queue.add(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	public static void main(String[] args) {
		
		
		Map<Vertex, List<Vertex>> adjVertices = new HashMap<Vertex, List<Vertex>>();
		UnWeightedGraphSampleWithStringNode graph = new UnWeightedGraphSampleWithStringNode(adjVertices);
		System.out.println(graph);
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice");
	    graph.addEdge("Bob", "Rob");
	    graph.addEdge("Alice", "Mark");
	    graph.addEdge("Rob", "Mark");
	    graph.addEdge("Alice", "Maria");
	    graph.addEdge("Rob", "Maria");
	
	    System.out.println(adjVertices);
		
		Set<String> depthFirstTraversal = graph.depthFirstTraversal(graph, "Bob");
		Set<String> breadthFirstTraversal = graph.breadthFirstTraversal(graph, "Bob");
		System.out.println(depthFirstTraversal);
		System.out.println(breadthFirstTraversal);
	}
}

