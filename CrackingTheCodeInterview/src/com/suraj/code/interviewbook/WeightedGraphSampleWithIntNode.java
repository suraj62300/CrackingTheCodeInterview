package com.suraj.code.interviewbook;

import java.util.LinkedList;

import com.suraj.code.graph.Edge;


class Graphs {
	int vertices;
	LinkedList<Edge>[] adjacencylist;

	@SuppressWarnings("unchecked")
	Graphs(int vertices) {
		this.vertices = vertices;
		adjacencylist = new LinkedList[vertices];
		// initialize adjacency lists for all the vertices
		for (int i = 0; i < vertices; i++) {
			adjacencylist[i] = new LinkedList<>();
		}
	}

	public void addEgde(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].addFirst(edge); // for directed graph
	}

	public void printGraph() {
		for (int i = 0; i < vertices; i++) {
			LinkedList<Edge> list = adjacencylist[i];
			for (int j = 0; j < list.size(); j++) {
				System.out.println("vertex-" + i + " is connected to " + list.get(j).getDestination() + " with weight "
						+ list.get(j).getWeight());
			}
		}
	}
}

public class WeightedGraphSampleWithIntNode {

	public static void main(String[] args) {
		int vertices = 6;
		Graphs graph = new Graphs(vertices);
		graph.addEgde(0, 1, 4);
		graph.addEgde(0, 2, 3);
		graph.addEgde(1, 3, 2);
		graph.addEgde(1, 2, 5);
		graph.addEgde(2, 3, 7);
		graph.addEgde(3, 4, 2);
		graph.addEgde(4, 0, 4);
		graph.addEgde(4, 1, 4);
		graph.addEgde(4, 5, 6);
		graph.printGraph();
	}
}
