package _04_TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
Given a directed graph, design an algorithm to find out whether there is a 
route between two nodes.
*/
public class _01_RouteBetweenNodes {
	public class Graph {
		private Node[] nodes;
	}

	public class Node {
		private Node[] neighbours;
	}

	Set<Node> visitedForDFS = new HashSet<_01_RouteBetweenNodes.Node>();

	public boolean hasRouteBFS(Node source, Node destination) {
		Queue<Node> q = new LinkedList<_01_RouteBetweenNodes.Node>();
		Set<Node> visited = new HashSet<_01_RouteBetweenNodes.Node>();

		q.offer(source);
		visited.add(source);

		while (!q.isEmpty()) {
			Node current = q.poll();
			if (current == destination)
				return true;

			for (Node nei : current.neighbours) {
				if (!visited.contains(nei)) {
					if (nei == destination)
						return true;
					q.add(nei);
					visited.add(nei);
				}
			}
		}

		return false;
	}

	public boolean hasRouteDFS(Node source, Node destination) {
		if (visitedForDFS.contains(source))
			return false;

		if (source == destination)
			return true;

		visitedForDFS.add(source);

		for (Node nei : source.neighbours) {
			if (hasRouteDFS(nei, destination))
				return true;
		}

		return false;
	}
}
