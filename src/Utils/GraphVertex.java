package Utils;

import java.util.ArrayList;
import java.util.List;

public class GraphVertex {
	public String str;
	public List<GraphVertex> others = new ArrayList<GraphVertex>();
	
	public GraphVertex(String str) {
		this.str = str;
	}
	
	GraphVertex(String str, List<GraphVertex> others) {
		this.str = str;
		this.others = others;
	}
	
	public GraphVertex(GraphVertex vertex) {
		this.str = vertex.str;
		this.others = vertex.others;
	}
}
