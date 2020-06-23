package com.suraj.code.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

class Edge {
    String source;
    String destination;
    double weight;
    int sourceIndex;

    public Edge(String source, String destination, double weight, int sourceIndex) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        this.sourceIndex = sourceIndex;
    }
}

class Graph {
    int vertices;
    LinkedList<Edge> [] adjacencylist;

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        //initialize adjacency lists for all the vertices
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(String source, String destination, double weight, int sourceIndex) {
    	Edge edge = new Edge(source, destination, weight, sourceIndex);
        adjacencylist[sourceIndex].addFirst(edge); //for directed graph
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println(list.get(j).source+ " is connected to " +
                        list.get(j).destination + " with weight " +  list.get(j).weight);
            }
        }
    }
}

public class WeightedGraph {
	
	public static void main(String[] args) {
	  
	  Scanner s = new Scanner(System.in);
      String storageUnit = s.nextLine();
      String[] storageUnitList = storageUnit.split(",");
      int vertices = storageUnitList.length;
      Map<String, Integer> map =  new HashMap<String, Integer>();
      for(int i=0; i<vertices; i++) {
    	  map.put(storageUnitList[i], i);
      }
      
      Graph graph = new Graph(vertices);
      
      for(int i=0; i<storageUnitList.length-1; i++){
          String relatedStorage = s.nextLine();
          String[] relatedStoragetList = relatedStorage.split(" ");
          graph.addEgde(relatedStoragetList[0], relatedStoragetList[3], Double.parseDouble(relatedStoragetList[2]), map.get(relatedStoragetList[0]));
          graph.addEgde(relatedStoragetList[3], relatedStoragetList[0], 1/Double.parseDouble(relatedStoragetList[2]), map.get(relatedStoragetList[3]));
      }
      graph.printGraph();
      s.close();
    }
}

