package xorsum;

public class SegmentTree {
	private int tree[];
	private int leafCount;
	public SegmentTree(int[] array) {
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
	
	private void validateRange(int start, int end){
		if(end < start)
			throw new IllegalArgumentException("end index can't be greater than start index");
		validateArrayIndex(start);
		validateArrayIndex(end);
	}
	
	private void validateArrayIndex(int index){
		if(index < 0 || index > leafCount-1)
			throw new IllegalArgumentException("array index is outside the size");
	}
	
	private int constructSTUtil(int[] array, int startRange, int endRange, int currentTreeIndex) {
		if(startRange == endRange){
			tree[currentTreeIndex] = array[startRange];
			return array[startRange];
		}
		int midRange = getMid(startRange, endRange);
		tree[currentTreeIndex] = constructSTUtil(array, startRange, midRange, getLeftIndex(currentTreeIndex))
							+ constructSTUtil(array,midRange +1, endRange, getRightIndex(currentTreeIndex));
		return tree[currentTreeIndex];
	}
	
	private int getSumUtil(int startRange, int endRange, int startQuery, int endQuery, int currentIndex){
		if(startRange > endQuery || endRange < startQuery)
			return 0;
		if(startQuery <= startRange && endRange <= endQuery)
			return tree[currentIndex];
		int midRange = getMid(startRange, endRange);
		return getSumUtil(startRange, midRange, startQuery, endQuery, getLeftIndex(currentIndex))
				+getSumUtil(midRange+1, endRange, startQuery, endQuery, getRightIndex(currentIndex));
	}
	
	public Integer getSum(int startQuery, int endQuery){
		validateRange(startQuery, endQuery);
		return getSumUtil(0, leafCount-1, startQuery, endQuery, 0);
	}
	
	public void updateValue(int arrIndex, int newDiff){
		validateArrayIndex(arrIndex);
		updateValueUtil(0, leafCount-1, arrIndex, newDiff, 0);
	}
	
	public void updateRange(int arrStartIndex, int arrEndIndex, int newDiff){
		validateRange(arrStartIndex, arrEndIndex);
		updateRangeUtil(0,leafCount-1, arrStartIndex, arrEndIndex, newDiff, 0);
	}
	
	private void updateValueUtil(int startIndex, int endIndex, int arrIndex, int newDiff, int treeIndex) {
		if(arrIndex<startIndex || arrIndex >endIndex)
			return;
		tree[treeIndex] += newDiff;
		int midIndex = getMid(startIndex, endIndex);
		if(startIndex == endIndex)
			return;
		updateValueUtil(startIndex, midIndex, arrIndex, newDiff, getLeftIndex(treeIndex));
		updateValueUtil(midIndex+1, endIndex, arrIndex, newDiff, getRightIndex(treeIndex));
	}
	private void updateRangeUtil(int startIndex, int endIndex, int arrStartIndex, int arrEndIndex, int newDiff, int treeIndex) {
		if(arrEndIndex<startIndex || endIndex < arrStartIndex)
			return;
		if(startIndex == endIndex){
			tree[treeIndex] += newDiff;
			return;
		}
		int midIndex = getMid(startIndex, endIndex);
		int leftChildIndex = getLeftIndex(treeIndex);
		int rightChildIndex = getRightIndex(treeIndex);
		updateRangeUtil(startIndex, midIndex, arrStartIndex, arrEndIndex, newDiff, leftChildIndex);
		updateRangeUtil(midIndex+1, endIndex, arrStartIndex, arrEndIndex, newDiff, rightChildIndex);
		tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];
	}
	 // Driver program to test above functions
    public static void main(String args[])
    {
        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr);
 
        // Build segment tree from given array
 
        // Print sum of values in array from index 1 to 3
        System.out.println("Sum of values in given range = " +
                           tree.getSum( 1, 3));
 
        // Add 10 to all nodes at indexes from 1 to 5.
        tree.updateRange(1, 5, 10);
 
        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range = " +
                           tree.getSum(1, 3));
    }
}
