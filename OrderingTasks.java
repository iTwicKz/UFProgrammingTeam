// /http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1246

import java.util.Scanner;
import java.util.ArrayList;

public class OrderingTasks{
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		int numTasks = input.nextInt();
		int numEdges = input.nextInt();
		String orderStr = "";

		Node[] vertices = new Node[numTasks];
		for(int i = 0; i < numTasks; i++){
			vertices[i] = new Node(i);
		}

		for(int tasks = 0; tasks < numTasks; tasks++){
			int num = input.nextInt();
			int num2 = input.nextInt();

			vertices[num].setEdges(num, num2);
		}

		boolean oneRemoved = true;
		boolean keep = true;
		boolean[] verticesRemoved = new boolean[vertices.length];
		while(oneRemoved){
			keep = false;
			for(int i = 0; i < vertices.length; i++){
				if(vertices[i].getDependent()) keep = true;
				if(!verticesRemoved[i]){
					if(!vertices[i].getDependent()){
						//remove node
						verticesRemoved[i] = true;
						orderStr = (i+1) + " " + orderStr;
						for(int j = 0; j < vertices.length; j++){
							oneRemoved = vertices[j].checkEdge(i);
						}
					}
				
				}	
			}
		}
		System.out.println(orderStr);

	}
}

class Node{
	private int index;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private Edge tempEdge;
	boolean dependent;
	int edgeCount;

	public Node(){
	}

	public Node(int index){
		this.index = index;
		this.dependent = false;
	}

	public void setEdges(int start, int end){
		dependent = true;
		edges.add(new Edge(start, end));
	}

	public boolean checkEdge(int end){
		boolean removed = false;
		for(int i = 0; i < edges.size(); i++){
			if((edges.get(i)).getEnd() == end){
				edges.remove(i);
				removed = true;
			}
			if(edges.size() == 0){
				boolean dependent = false;
			}
		}
		return removed;
	}

	public boolean getDependent(){
		return dependent;
	}
}

class Edge{
	private int start;
	private int end;

	public Edge(){
	}

	public Edge(int start, int end){
		this.start = start;
		this.end = end;
	}

	public int getStart(){
		return start;
	}

	public int getEnd(){
		return end;
	}
}