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
import java.util.stream.Stream;

import com.suraj.code.graph.VertexWithWeight;

public class WeightedGraphSampleWithStringNode {
	
	private Map<VertexWithWeight, List<VertexWithWeight>> adjEdges;
	
	public WeightedGraphSampleWithStringNode(Map<VertexWithWeight, List<VertexWithWeight>> adjEdges) {
		super();
		this.adjEdges = adjEdges;
	}

	public Map<VertexWithWeight, List<VertexWithWeight>> getAdjEdges() {
		return adjEdges;
	}

	public void setAdjEdges(Map<VertexWithWeight, List<VertexWithWeight>> adjEdges) {
		this.adjEdges = adjEdges;
	}

	void addVertex(String label) {
	    adjEdges.putIfAbsent(new VertexWithWeight(label), new ArrayList<>());
	}
	 
	void removeVertex(String label) {
		VertexWithWeight v = new VertexWithWeight(label);
		//convert all value of map into string and iterate through all list and remove the entry of these vertex
		adjEdges.values().stream().forEach(e -> e.remove(v));
		adjEdges.remove(new VertexWithWeight(label));
	}
	
	void addEdge(String label1, String label2, int weight) {
		
		VertexWithWeight v1new = new VertexWithWeight(label1, weight);
		VertexWithWeight v2new = new VertexWithWeight(label2, weight);
	    adjEdges.get(v1new).add(v2new);
	    adjEdges.get(v2new).add(v1new);
	}
	
	void removeEdge(String label1, String label2) {
		VertexWithWeight v1 = new VertexWithWeight(label1);
		VertexWithWeight v2 = new VertexWithWeight(label2);
	    List<VertexWithWeight> eV1 = adjEdges.get(v1);
	    List<VertexWithWeight> eV2 = adjEdges.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	
	List<VertexWithWeight> getAdjEdges(String label){
		return adjEdges.get(new VertexWithWeight(label));
	}
	
	Set<String> depthFirstTraversal(WeightedGraphSampleWithStringNode graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push(root);
	    while (!stack.isEmpty()) {
	        String vertex = stack.pop();
	        if (!visited.contains(vertex)) {
	            visited.add(vertex);
	            for (VertexWithWeight v : graph.getAdjEdges(vertex)) {              
	                stack.push(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	Set<String> breadthFirstTraversal(WeightedGraphSampleWithStringNode graph, String root) {
	    Set<String> visited = new LinkedHashSet<String>();
	    Queue<String> queue = new LinkedList<String>();
	    queue.add(root);
	    visited.add(root);
	    while (!queue.isEmpty()) {
	        String vertex = queue.poll();
	        for (VertexWithWeight v : graph.getAdjEdges(vertex)) {
	            if (!visited.contains(v.getLabel())) {
	                visited.add(v.getLabel());
	                queue.add(v.getLabel());
	            }
	        }
	    }
	    return visited;
	}
	
	public static void main(String[] args) {
		
		Map<VertexWithWeight, List<VertexWithWeight>> adjEdges = new HashMap<VertexWithWeight, List<VertexWithWeight>>();
		
		WeightedGraphSampleWithStringNode graph = new WeightedGraphSampleWithStringNode(adjEdges);
		System.out.println(graph);
	    graph.addVertex("Bob");
	    graph.addVertex("Alice");
	    graph.addVertex("Mark");
	    graph.addVertex("Rob");
	    graph.addVertex("Maria");
	    graph.addEdge("Bob", "Alice", 40);
	    graph.addEdge("Bob", "Rob", 50);
	    graph.addEdge("Alice", "Mark", 60);
	    graph.addEdge("Rob", "Mark", 20);
	    graph.addEdge("Alice", "Maria", 40);
	    graph.addEdge("Rob", "Maria", 30);
	
	    System.out.println(adjEdges);
	    
		Set<String> depthFirstTraversal = graph.depthFirstTraversal(graph, "Bob");
		System.out.println(depthFirstTraversal);
		Set<String> breadthFirstTraversal = graph.breadthFirstTraversal(graph, "Bob");
		System.out.println(breadthFirstTraversal);
		
		graph.removeVertex("Rob");
		//graph.removeEdge("Bob", "Rob");
		System.out.println(adjEdges);
		
		depthFirstTraversal = graph.depthFirstTraversal(graph, "Bob");
		System.out.println(depthFirstTraversal);
		
		breadthFirstTraversal = graph.breadthFirstTraversal(graph, "Bob");
		System.out.println(breadthFirstTraversal);
	}
}

