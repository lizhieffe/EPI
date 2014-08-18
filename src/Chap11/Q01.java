package Chap11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q01 {
	
	public int[] sort(ArrayList<int[]> inputs) {
		if (inputs == null || inputs.size() == 0)
			return new int[0];
		
		PriorityQueue<DataPair> heap 
				= new PriorityQueue<DataPair>(inputs.size(), new Q01Comparator());
		
		int size = 0;
		int[] cIndex = new int[inputs.size()];

		for (int i = 0; i < inputs.size(); i ++) {
			if (inputs.get(i).length > 0) {
				heap.add(new DataPair(inputs.get(i)[cIndex[i] ++], i));
				size = size + inputs.get(i).length;
			}
		}
		
		int[] result = new int[size];
		int index = 0;
		
		while (heap.size() > 0) {
			DataPair data = heap.poll();
			int val = data.val;
			int from = data.from;
			
			result[index ++] = val;
			if (cIndex[from] < inputs.get(from).length)
				heap.add(new DataPair(inputs.get(from)[cIndex[from] ++], from));
		}
		
		return result;
	}
	
	private class Q01Comparator implements Comparator <DataPair> {

		@Override
		public int compare(DataPair arg0, DataPair arg1) {
			if (arg0.val < arg1.val)
				return -1;
			else if (arg0.val == arg1.val)
				return 0;
			return 1;
		}
		
	}
	
	private class DataPair {
		int val;
		int from;
		DataPair (int val, int from) {
			this.val = val;
			this.from = from;
		}
	}
	
	public static void main(String[] args) {
		int[] a1 = {1, 3, 5, 7, 9};
		int[] a2 = {2, 4, 6, 7, 9};
		int[] a3 = {-1, 0, 2, 4};
		ArrayList<int[]> inputs = new ArrayList<int[]>();
		inputs.add(a1);
		inputs.add(a2);
		inputs.add(a3);
		
		Q01 service = new Q01();
		int[] result = service.sort(inputs);
		System.out.println(result);
	}
}
