package Chap19;

import java.util.HashMap;
import java.util.LinkedList;

import Utils.GraphVertex;

public class Q04 {
	public GraphVertex clone(GraphVertex vertex) {
		if (vertex == null)
			return null;
		
		HashMap<GraphVertex, GraphVertex> relations = new HashMap<GraphVertex, GraphVertex>();

		GraphVertex newVertex = new GraphVertex(vertex.str + "ddd");
		relations.put(vertex, newVertex);
		
		LinkedList<GraphVertex> stack = new LinkedList<GraphVertex>();
		stack.add(vertex);
		
		while (stack.size() > 0) {
			GraphVertex cVertex = stack.getLast();
			if (cVertex.others == null || cVertex.others.size() == 0)
				stack.removeLast();
			else {
				boolean finished = true;
				for (GraphVertex tmp : cVertex.others) {
					if (relations.containsKey(tmp) &&
							!relations.get(cVertex).others.contains(relations.get(tmp))) {
						relations.get(tmp).others.add(relations.get(tmp));
					}
					else if (relations.containsKey(tmp))
						continue;
					else {
						GraphVertex newTmp = new GraphVertex(tmp.str + "ddd");
						relations.put(tmp, newTmp);
						GraphVertex aaa = relations.get(cVertex);
						relations.get(cVertex).others.add(newTmp);
						stack.addLast(tmp);
						finished = false;
						break;
					}
				}
				if (finished)
					stack.removeLast();
			}
		}
		
		return newVertex;
	}
	
	public static void main(String[] args) {
		GraphVertex vertex = new GraphVertex("0");
		vertex.others.add(new GraphVertex("1"));
		vertex.others.add(new GraphVertex("2"));
		vertex.others.get(1).others.add(vertex.others.get(0));
		
		System.out.println(new Q04().clone(vertex));
	}
}
