package simpleSortingAlgorithms;

public class InsertionSort {

	/*
	 * INSERTION SORT:
	 * Insert each item into its proper place:
	 * 	~ find the location for an element and 
	 * 	~ move all others up, and insert the element. 
	 *	  i.e. Remove the element first, then 
	 *		   Slide-up the elements before it to make room for insertion, finally
	 *		   Insert the value in the appropriate position.

	 * How many comparisons? 1+2+3+…+(n-1)= O(n2)
	 * How many swaps? 1+2+3+…+(n-1)= O(n2)
	 *  
	 */

	// ascending 
	public static int[] insertionSortAscending(int[] a) {
		
		for(int i=1; i<a.length; i++) {
			
			int temp = a[i];
			int j = i-1;
			
			//Move elements of a[0..i-1], that are greater than the key("temp"), 
			//to one position up of their current position 
			//Therefore,  the while loop must satisfy two conditions: 
			//	~ the value of j must be greater than 0, and 
			//	~ the value at index j-1, must be greater than the value at index j.
			while (j >= 0 && a[j] > temp) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
		
		// return new int[] {};
		return a;
	}

	//descending
	public static int[] insertionSortDescending(int[] a) {

		for(int i=1; i<a.length; i++) {

			int temp = a[i];
			int j = i-1;
			while( j>=0 && (a[j]<temp) ) {
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp;
		}
		// return new int[] {};
		return a;
	}

	
}
