package simpleSortingAlgorithms;

public class SelectionSort {
	
	/*
	 * SELECTION SORT:
	 * Loop through the array from i=0 to n-1. 
	 * 	~ Select the smallest element in the array from i to n, then
	 * 	~ Swap this value with value at position i.
	 * 
	 * How many comparisons? n((n-1)+(n-2)+…+1) = O(n2) 
	 * How many swaps? n = O(n)
	 * 
	 */

	// ascending 
	public static int[] selectionSortAscending(int[] a) {
		
		for(int i=0; i<a.length; i++) {
			int min = i; //temporal position of the minimum element
			for(int j=i+1; j<a.length; j++) {
				if(a[j] < a[min]) //finding the position of minimum element
					min = j; 
			}
			
			//swapping
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		// return new int[] {};
		return a;
	}

	//descending
	public static int[] selectionSortDescending(int[] a) {
		for(int i=0; i<a.length; i++) {
			int max = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j] > a[max])
					max = j;
			}
			
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
		}
		
		// return new int[] {};
		return a;
	}

}
