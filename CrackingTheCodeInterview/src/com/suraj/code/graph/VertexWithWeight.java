package com.suraj.code.graph;

public class VertexWithWeight {

	String label;
	int weight;
	public VertexWithWeight() {
		
	}
	public VertexWithWeight(String label) {
		super();
		this.label = label;
		this.weight = 0;
	}
	public VertexWithWeight(String label, int weight) {
		super();
		this.label = label;
		this.weight = weight;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		VertexWithWeight other = (VertexWithWeight) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(label);
		builder.append(",");
		builder.append(weight);
		builder.append("]");
		return builder.toString();
	}
}
