package edu.princeton.cs.algs4.test;

public class TestHeap {

	public static void main(String[] args) {

		int[] pq = { 9, 3, 4, 2, 1, 5, 6, 7 };
		int n = pq.length;
		printArray(heapMaxInsert(pq));
		System.exit(1);
		for (int k = 1; k >= 1; k--) {
			testSink(pq, k, n);
		}
		while (n > 1) {
			int tmp = pq[n - 1];
			pq[n - 1] = pq[0];
			pq[0] = tmp;
			n--;
			testSink(pq, 1, n);
		}
		System.out.println(pq[0]);

	}

	public static void testSink(int[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && pq[j - 1] < pq[j])
				j = j + 1;
			if (pq[k - 1] > pq[j - 1])
				break;
			int tmp = pq[k - 1];
			pq[k - 1] = pq[j - 1];
			pq[j - 1] = tmp;
			k = j;
		}
	}

	public static int[] heapMaxInsert(int[] pq) {
		int n = pq.length;
		int[] heap = new int[n];
		for (int i = 0; i < n; i++) {
			heap[i] = pq[i];
			int index = i;
			while (index > 0) {
				int parent = (index - 1) / 2;
				if (heap[parent] < heap[index]) {
					int tmp = heap[parent];
					heap[parent] = heap[index];
					heap[index] = tmp;
				}
				index = parent;
			}
		}
		return heap;
	}

	public static void printArray(int[] arr) {
		int level = 1;
		int i = 0;
		while (i < arr.length) {
			level++;
			i = 2 * i + 1;
		}
		for (i = 1; i <= level; i++) {
			int length = new Double(Math.pow(2.0, i - 1.0)).intValue();
			int first = length - 1;
			for (int k = 0; k < level - i - 1; k++) {
				System.out.print(" ");
			}
			for (int k = 0; k < length && (first + k) < arr.length; k++) {
				System.out.print(arr[first + k]);
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
