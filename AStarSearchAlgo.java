package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgo {
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getG() + o1.getH(), (o2.getG() + o2.getH()));

			}

		});
		frontier.add(root);
		ArrayList<Node> ex = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node curent = frontier.poll();
			if (curent.getLabel().equals(goal)) {
				return curent;
			} else {
				ex.add(curent);

				List<Edge> children = curent.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double PastCothNew = curent.getG() + child.getWeight();
					if (!frontier.contains(end) && !ex.contains(end)) {
						end.setG(PastCothNew);
						frontier.add(end);
						end.setParent(curent);
					} else if (frontier.contains(end)) {
						if (end.getG() > PastCothNew) {
							end.setG(PastCothNew);
//					frontier.add(end);
							end.setParent(curent);
						}
					}

				}

			}

		}
		return null;
	}

	public Node execute(Node root, String start, String goal) {
		Node node = execute(root, start);
		node.setParent(null);
		node.setG(0);
		Node node1 = execute(node, goal);
		return node1;

	}

	public boolean isAdmissibleH(Node root, String goal) {
		// lấy ra all node
		Queue<Node> frontier = new LinkedList<Node>();
		ArrayList<Node> ex = new ArrayList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				ex.add(current);
			} else {
				ex.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					if (!frontier.contains(child) && !ex.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
		}
		for (Node n : ex) {
			Node node = execute(root, n.getLabel(), goal);
//			NodeUtils nu=new NodeUtils();
//			System.out.println(nu.printPath(node));
//			System.out.println(n.getH());
//			System.out.println(node.getG());
			if (n.getH() <= node.getG() && n.getH() >= 0) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}

		}
		return false;

	}
}
