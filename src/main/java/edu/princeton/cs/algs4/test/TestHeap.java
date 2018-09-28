package edu.princeton.cs.algs4.test;

public class TestHeap {

	public static void main(String[] args) {

		int[] pq = { 3, 4, 2, 1, 5, 6, 7 };
		int n = pq.length;
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
}
