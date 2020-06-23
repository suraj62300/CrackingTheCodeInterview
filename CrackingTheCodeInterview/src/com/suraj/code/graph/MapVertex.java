package com.suraj.code.graph;

public class MapVertex {

	String vertex;
	double distance;
	public MapVertex() {
		super();
	}
	public MapVertex(String vertex) {
		super();
		this.vertex = vertex;
		this.distance = 0;
	}
	public MapVertex(String vertex, double distance) {
		super();
		this.vertex = vertex;
		this.distance = distance;
	}
	public String getVertex() {
		return vertex;
	}
	public void setVertex(String vertex) {
		this.vertex = vertex;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapVertex other = (MapVertex) obj;
		if (vertex == null) {
			if (other.vertex != null)
				return false;
		} else if (!vertex.equals(other.vertex))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(vertex);
		builder.append(", ");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}
	
}
