package model;

import java.io.Serializable;
import java.util.List;

public class Item implements Serializable{
	private String qualifier;
	private List<String> explain;

	public String getQualifier() {
		return qualifier;
	}
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	public List<String> getExplain() {
		return explain;
	}
	public void setExplain(List<String> explain) {
		this.explain = explain;
	}
}