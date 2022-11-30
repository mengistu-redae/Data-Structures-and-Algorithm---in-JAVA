package simpleSearchingAlgorithms;

public class LinearOrSequentialSearch {

	public static int linearOrSequentialSearching(int[] a, int key) {
		int i = 0;
		while(i<a.length) {
			if(a[i] == key)
				return i;
			
			i++;
		}
		
		return -1;
	}
}
