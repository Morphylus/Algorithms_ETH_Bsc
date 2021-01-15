package graphs;

public class Node implements Comparable<Node>{
	
	int value;
	int priority;
	
	public Node(int value, int priority) {
		this.value = value;
		this.priority = priority;
	}
	
	public int compareTo(Node a) {
		if(a.priority == priority) {
			return 0;
		} else if(priority > a.priority) {
			return 1;
		}
		return -1;
	}
	
	public int getValue() {
		return value;
	}

}
