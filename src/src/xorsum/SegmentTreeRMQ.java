package xorsum;

public class SegmentTreeRMQ {
	private int tree[];
	private int leafCount;
	public SegmentTreeRMQ(int[] array) {
		this.leafCount = array.length;
		int heightOfTree = (int) (Math.ceil(Math.log(leafCount)/Math.log(2)));
		int size = 2*(int)Math.pow(heightOfTree,2) -1;
		this.tree = new int[size];
		constructSTUtil(array, 0, leafCount-1, 0);
	}
	
	private int getMid(int start, int end){
		return start + (end-start)/2 ;
	}
	
	private int getLeftIndex(int index){
		return 2*index + 1;
	}
	
	private int getRightIndex(int index){
		return 2*index + 2;
	}
	
	private int constructSTUtil(int[] array, int startRange, int endRange, int currentTreeIndex) {
		if(startRange == endRange){
			tree[currentTreeIndex] = array[startRange];
			return array[startRange];
		}
		int midRange = getMid(startRange, endRange);
		int leftTreeMin = constructSTUtil(array, startRange, midRange, getLeftIndex(currentTreeIndex));
		int rightTreeMin = constructSTUtil(array,midRange +1, endRange, getRightIndex(currentTreeIndex));
		tree[currentTreeIndex] = Math.min(leftTreeMin,rightTreeMin);
		return tree[currentTreeIndex];
	}
	
	private int getMinimumUtil(int startRange, int endRange, int startQuery, int endQuery, int currentIndex){
		if(startRange > endQuery || endRange < startQuery)
			return Integer.MAX_VALUE;
		if(startQuery <= startRange && endRange <= endQuery)
			return tree[currentIndex];
		int midRange = getMid(startRange, endRange);
		int leftTreeMin = getMinimumUtil(startRange, midRange, startQuery, endQuery, getLeftIndex(currentIndex));
		int rightTreeMin = getMinimumUtil(midRange+1, endRange, startQuery, endQuery, getRightIndex(currentIndex));
		return Math.min(leftTreeMin, rightTreeMin);
	}
	
	public Integer getMinimumInRange(int startQuery, int endQuery){
		return getMinimumUtil(0, leafCount-1, startQuery, endQuery, 0);
	}
	
	public void updateValue(int arrIndex, int newValue){
		updateValueUtil(0, leafCount-1, arrIndex, newValue, 0);
	}
	
	private void updateValueUtil(int startIndex, int endIndex, int arrIndex, int newValue, int treeIndex) {
		if(arrIndex<startIndex || arrIndex >endIndex)
			return;
		tree[treeIndex] = Math.min(tree[treeIndex], newValue);
		int midIndex = getMid(startIndex, endIndex);
		if(startIndex == endIndex)
			return;
		updateValueUtil(startIndex, midIndex, arrIndex, newValue, getLeftIndex(treeIndex));
		updateValueUtil(midIndex+1, endIndex, arrIndex, newValue, getRightIndex(treeIndex));
	}
	public static void main(String args[]) 
    {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        SegmentTreeRMQ tree = new SegmentTreeRMQ(arr);
 
        // Build segment tree from given array
       
 
        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range
 
        // Print minimum value in arr[qs..qe]
        System.out.println("Minimum of values in range [" + qs + ", "
                           + qe + "] is = " + tree.getMinimumInRange(qs, qe));
    }
}
