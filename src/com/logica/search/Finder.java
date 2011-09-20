package com.logica.search;


public class Finder {

	final private int[] dataSet;
	private int limit;

	public Finder(int[] dataSet) {
		this.dataSet = dataSet;
	}

	private int findNthSmallest() {
		if(dataSet.length < limit)
			throw new IllegalStateException("Limit must exceed dataset size");
		return findNthSmallest(0, dataSet.length-1);
	}

	private int findNthSmallest(int startPos, int endPos) {
		
		if (endPos - startPos <= limit - 1) {
			//insertionSort and return dataSet[limit-1] algo goes here. Currently hard coding for limit 2
			return (dataSet[startPos] < dataSet[endPos]) ? dataSet[endPos] :
															dataSet[startPos];
		}
		int m;
		do {
			m = lomutofy(startPos, endPos);
		} while(m - startPos < limit - 1);
		
		return findNthSmallest(startPos, m);
	}

	private int lomutofy(int startPos, int endPos) {
		swap(startPos, startPos+1);
//		int pivot = startPos + (int)(Math.random() * (double)(endPos - startPos));
		int pivot = startPos;
		int m = startPos;
		for (int i = startPos + 1; i <= endPos; i++) {
			if (dataSet[i] < dataSet[pivot]) {
				swap(++m, i);
			}
		}
		swap(m, pivot);
		return m;
	}

	private void swap(int a, int b) {
		int temp = dataSet[a];
		dataSet[a] = dataSet[b];
		dataSet[b] = temp;
	}
	
	private void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] dataSet = {0,4,6,3,8,7,2,1,5};
		Finder finder = new Finder(dataSet);
		finder.setLimit(2);
		System.out.println(finder.findNthSmallest());
	}
}
