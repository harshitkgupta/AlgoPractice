package SorocoHiring.CrossTheStreet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class CrossTheStreet {
	static int arr[][];
	static int M, N;
	static Map<String, Long> dist = new HashMap<String, Long>();

	static long minCost(int n, int m) {
		if (n < 0 || m < 0 || n >= N || m >= M)
			return Integer.MAX_VALUE;
		if (m == 0 && n == 0)
			return arr[0][0];
		if (dist.get(n + "#" + m) == null) {
			long c = arr[n][m] + Long.min(Long.min(minCost(n, m + 1), minCost(n + 1, m)),
					Long.min(minCost(n - 1, m), minCost(n, m - 1)));
			dist.put(n + "#" + m, c);
		}
		return dist.get(n + "#" + m);
	}

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		M = s.nextInt();
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.nextInt();
			}
		}
		// System.out.println(minCost(N-1,M-1));

		Graph g = new Graph();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i + 1 < N)
					g.addEdge(i + "#" + j, (i + 1) + "#" + j, Math.abs(arr[i][j] - arr[i + 1][j]));
				if (j + 1 < M)
					g.addEdge(i + "#" + j, i + "#" + (j + 1), Math.abs(arr[i][j] - arr[i][j + 1]));

				if (i - 1 >= 0)
					g.addEdge(i + "#" + j, (i - 1) + "#" + j, Math.abs(arr[i][j] - arr[i - 1][j]));
				if (j - 1 >= 0)
					g.addEdge(i + "#" + j, i + "#" + (j - 1), Math.abs(arr[i][j] - arr[i][j - 1]));
			}
		}
		s.close();
		g.shortestDistance("0#0");
		System.out.println(g.getDistance(N-1, M-1));
	}
}

class Graph<T1, T2 extends Comparable<T2>> {
	static class Edge<T1,T2 extends Comparable<T2>>{
		T1 dest;
		T2 weight;

		public Edge(T1 dest, T2 weight) {
			this.dest = dest;
			this.weight = weight;
		}
	}
	
	static class VertexDistance<T1,T2 extends Comparable<T2>> implements Comparable<VertexDistance<T1,T2>>{
		T1 node;
		T2 distance;
		
		public VertexDistance(T1 node, T2 distance) {
			super();
			this.node = node;
			this.distance = distance;
		}

		@Override
		public int compareTo(VertexDistance<T1, T2> o) {
			return distance.compareTo(o.distance);
		}
		
	}

	Map<T1, Set<Edge<T1,T2>>> adjList;
	Set<T1> vertex;
	Map<T1, T2> dist;

	public Graph() {
		adjList = new HashMap<T1, Set<Edge<T1,T2>>>();
		vertex = new HashSet<T1>();
		dist = new HashMap<T1, T2>();
	}

	public void addEdge(T1 source, T1 dest, T2 weight) {
		Edge<T1,T2> e = new Edge<T1,T2>(dest, weight);
		Set<Edge<T1,T2>> p = adjList.get(source);
		if (p == null)
			p = new HashSet<Edge<T1,T2>>();
		p.add(e);
		adjList.put(source, p);
		vertex.add(source);
		vertex.add(dest);
	}

	public void shortestDistance(T1 source) {

		Set<T1> visited = new HashSet<T1>();
		setInitailDistance(source);
		
		
		Queue<VertexDistance<T1,T2>> pq = new PriorityQueue<VertexDistance<T1,T2>>();
		
		pq.add(new VertexDistance<String,Long>(source, 0L));
		
		while (!pq.isEmpty()) {
			VertexDistance<String,Long> vd = pq.poll();
			String node = vd.node;
			if(!visited.contains(node))
			{
				visited.add(vd.node);
				Set<Edge<String,Long>> p = adjList.get(node);
				if(p!=null)
				for(Edge e: p) {
	
					if (dist.get(e.dest) == Long.MAX_VALUE || dist.get(e.dest) > e.weight + dist.get(node.node))
					{	dist.put(e.dest, e.weight + dist.get(node.node));
						System.out.println("Source "+node.node+" Dest "+e.dest+"  weight "+e.weight+" sdistance "+dist.get(e.source)+"  distance "+dist.get(e.dest));
					}
					if(!visited.contains(e.dest))
						l.add(new VertexDistance(e.dest, dist.get(e.dest)));
				}
			}
		}
	}

	private void setInitailDistance(T1 source) {
		for (T1 v : vertex)
			dist.put(v, Long.MAX_VALUE);
		dist.put(source, 0L);
	}
	
	public long getDistance(int i, int j)
	{
		return dist.get(i+"#"+j);
	}

}
