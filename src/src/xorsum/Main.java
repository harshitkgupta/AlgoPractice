package xorsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	public static void main(String args[]){
		FastReader r = new FastReader();
		int T = r.nextInt();
		for(int i=0;i<T;i++){
			int N = r.nextInt();
			ArrayTrie trie = new ArrayTrie();
			int xor_till_num = 0;
			int final_max_xor=0;
			for(int j=0; j<N; j++){
				int num = r.nextInt();
				xor_till_num ^=num;
				String xor_binary = String.format("%32s", Integer.toBinaryString(xor_till_num)).replace(" ", "0");
				trie.insert(xor_binary);
				String max_xor_binary = trie.query(xor_binary);
				int max_xor = Integer.parseInt(max_xor_binary, 2);
				final_max_xor = Math.max(final_max_xor, max_xor);
			}
			final_max_xor = Math.max(final_max_xor, xor_till_num);
			System.out.println(final_max_xor);
		}
	}
}
class ArrayTrie {
	private static class TrieNode {
		public static final int NUMBER_OF_CHARACTERS = 2;
		TrieNode children [];
		boolean isLeafNode;
		int count;
		
		public TrieNode() {
			children = new TrieNode[NUMBER_OF_CHARACTERS];
			count = 0;
			isLeafNode = false;
		}

		public TrieNode getChild(char ch) {
			return children[getCharIndex(ch)];
		}
		
		public TrieNode setChild(char ch) {
			return children[getCharIndex(ch)] = new TrieNode();
		}

		public static int getCharIndex(char ch) {
			return ch - '0';
		}

		public boolean isLeafNode() {
			return isLeafNode;
		}

		public void setLeafNode(boolean isLeafNode) {
			this.isLeafNode = isLeafNode;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}	
	}

	private TrieNode root;

	public ArrayTrie() {
		root = new TrieNode();
	}

	public String query(String str) {
		StringBuffer sb = new StringBuffer();
		TrieNode head = root;
		boolean firstOneFound = false;
		for(char ch : str.toCharArray()){
			char opp = ch=='0'?'1':'0';
			
			if(head.getChild(opp) == null){
				opp = ch;
			}
			int xor = (ch-'0')^(opp-'0');
			if(xor ==1)
				firstOneFound =true;
			if(firstOneFound){
				sb.append(Integer.toString(xor));
			}
			head = head.getChild(opp);
		}
		if(sb.length()==0)
			sb.append('0');
		return new String(sb);
	}

	public void insert(String str) {
		TrieNode head = root;
		head.setCount(head.getCount()+1);
		for(char ch : str.toCharArray()){
			
			if(head.getChild(ch) == null){
				head.setChild(ch);
			}			
			head = head.getChild(ch);
			head.setCount(head.getCount()+1);
		}
		head.setLeafNode(true);
	}
	
	public boolean searchCompleteWord(String str) {
		TrieNode head = root;
		for(char ch : str.toCharArray()){
			head = head.getChild(ch);
			if(head == null){
				return false;
			}
		}
		return head.isLeafNode();
	}
	
	/**
	 * count number of words starting with str
	 * @param str
	 * @return
	 */
	public int searchPartialWord(String str) {
		TrieNode head = root;
		for(char ch : str.toCharArray()){
			head = head.getChild(ch);
			if(head == null){
				return 0;
			}
		}
		return head.getCount();
	}
}

class FastReader {
	  BufferedReader br;
	  StringTokenizer st;

	  public FastReader() {
	    br = new BufferedReader(new InputStreamReader(System.in));
	  }

	  String next() {
	    while (st == null || !st.hasMoreElements()) {
	      try {
	        st = new StringTokenizer(br.readLine());
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	    return st.nextToken();
	  }

	  int nextInt() {
	    return Integer.parseInt(next());
	  }

	  long nextLong() {
	    return Long.parseLong(next());
	  }

	  double nextDouble() {
	    return Double.parseDouble(next());
	  }

	  String nextLine() {
	    String str = "";
	    try {
	      str = br.readLine();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return str;
	  }
	}
