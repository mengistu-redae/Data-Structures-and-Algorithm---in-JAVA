package simpleSortingAlgorithms;

public class BubbleOrExchangeSort {
	
	/*
	 * Also called Exchange sort 
	 * simplest algorithm to implement and the slowest algorithm on very large inputs.
	 * 
	 * Loop through array from i=0 to n and swap adjacent elements if they are out of order.
	 * 
	 * Compare each element (except the last one) with its neighbor to the right 
	 * If they are out of order, swap them. This puts the largest element at the very end. The last 
	 * element is now in the correct and final place. Repeat this.
	 * 
	 * How many comparisons?  n((n-1)+(n-2)+…+1)= O(n2)
	 * How many swaps?  n((n-1)+(n-2)+…+1)= O(n2)
	 * 
	 */
	
	public static int[] bubleOrExchangeSortAscending(int[] a) {
		for(int i = a.length-1 ; i>0 ; i--) {
			for(int j=0; j<i; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			
		}
		
		return a;
	}

	public static int[] bubleOrExchangeSortDescending(int[] a) {
		for(int i = a.length-1; i>0; i--) {
			for(int j = 0; j<i; j++) {
				if(a[j]<a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		return a;
	}
}
