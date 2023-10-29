package lab4;

public class TestAStar {
	public static void main(String[] args) {
		Node s=new Node("S", 6);
		Node b = new Node("B",4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		
		GreedyBestFirstSearchAlgo gbfs=new GreedyBestFirstSearchAlgo();
		Node node=gbfs.execute(s,"G");
		NodeUtils nu=new NodeUtils();
		System.out.println("Test task 1");
		System.out.println(nu.printPath(node)); //tu gốc tới goal
		Node node1=gbfs.execute(s, "B","G");
		System.out.println(nu.printPath(node1)); //tu nút bất kì tới goal
		System.out.println("Test task 2");
		AStarSearchAlgo as=new AStarSearchAlgo();
		Node node2=as.execute(s,"G");
		System.out.println(nu.printPath(node2));//tu gốc tới goal
		Node node3=as.execute(s, "A","G");
		System.out.println(nu.printPath(node1)); //tu nút bất kì tới goal	
		System.out.println("Test task 3");
	    System.out.println(as.isAdmissibleH(s,"G"));
		
	}
}
