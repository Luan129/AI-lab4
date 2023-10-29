package lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class GreedyBestFirstSearchAlgo {
public Node execute(Node root,String goal) {
	PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return Double.compare(o1.getH(),o2.getH());

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

			List<Node> children = curent.getChildrenNodes();
			for (Node child : children) {
				if (!frontier.contains(child) && !ex.contains(child)) {
					frontier.add(child);
					child.setParent(curent);
			
			}

		}

	}
}
	return null;
}
public Node execute(Node root,String start,String goal) {
	Node node=execute(root, start);
	node.setParent(null);
	Node node1=execute(node,goal);
	return node1;
	
}
}


