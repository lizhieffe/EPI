package Chap14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Q10 {
	public int[] sort(int[] array) {
		if (array == null || array.length <= 2)
			return array;
		
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for (int i = 0; i < array.length; i ++) {
			if (!table.containsKey(Integer.toString(array[i])))
				table.put(Integer.toString(array[i]), 1);
			else
				table.put(Integer.toString(array[i]), table.get(Integer.toString(array[i])) + 1);
		}
		
		if (table.size() == 1)
			return array;
		
		HashMap<String, Integer> table1 = new HashMap<String, Integer>(table);

		int sum = 0;
		Iterator<Entry<String, Integer>> it = table.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			
			int tmp = entry.getValue();
			entry.setValue(sum);
			sum += tmp;
		}
		
		sum = 0;
		it = table1.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			
			int tmp = entry.getValue();
			sum += tmp;
			entry.setValue(sum);
		}
		
		int i = 0;
		while (i < array.length) {
			int tmp = array[i];
			if (table.get(Integer.toString(tmp)) >= table1.get(Integer.toString(tmp)))
				i ++;
			else if (i == table.get(Integer.toString(tmp))) {
				i ++;
				table.put(Integer.toString(tmp), i);
			}
			else {
				int j = table.get(Integer.toString(tmp));
				array[i] = array[j];
				array[j] = tmp;
				table.put(Integer.toString(tmp), j + 1);
			}
		}
		
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 5, 7, 9, 1, 3, 5, 5, 7, 9, 11};
		System.out.print(new Q10().sort(array));
	}
}
