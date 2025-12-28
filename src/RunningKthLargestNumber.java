import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningKthLargestNumber {
	public static List<Integer> printKthLargest(int arr[]) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new PairComprator());
		int N = arr.length;
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<N; i++){
			int len = (int) Math.ceil(0.9*(i+1));
			int num = arr[i];
			pq.add(new Pair(num,i));
			if(len < pq.size()){
				pq.poll();
			}
			result.add(pq.peek().getFirst());
			System.out.println("\n "+len+" "+pq.size()+" : ");
			pq.stream().forEach(e-> System.out.print("("+e.getFirst()+" "+e.getSecond()+")"));
		}
		return result;
	}	
}
class Pair{
	private int first;
	private int second;
	public Pair(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	public int getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
}
class PairComprator implements Comparator<Pair>{

	@Override
	public int compare(Pair a, Pair b) {
		if(a.getFirst() == b.getFirst())
			return a.getSecond() < b.getSecond() ? -1 : 1;
		return a.getFirst() < b.getFirst() ? -1 : 1;			
	}		
}
