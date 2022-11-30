package simpleSearchingAlgorithms;

public class BinarySearch {

	/*
	 * This searching algorithms works only on an ordered list. 
	 * It uses principle of divide-and-conquer 
	 * 
	 * Though additional cost has to do with keeping list in order, it is more 
	 * efficient than linear search
	 */
	public static int binarySearch(int[] a, int key) {
		int left = 0;
		int right = a.length-1;
		int mid;
		do {
			mid = (left+right)/2;
			if(key == a[mid]) return mid;			
			else if(key < a[mid]) right = mid;
			else if(key > a[mid]) left = mid;
				
		}while(left<right);
		
		return -1;
	}
}
