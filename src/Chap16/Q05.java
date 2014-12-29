package Chap16;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Q05 {
	public List<List<Integer>> getPowerSets(int[] array) {
		return getPowerSets(array, 0);
	}
	
	private List<List<Integer>> getPowerSets(int[] array, int beg) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (array == null || array.length <= beg) {
			result.add(new ArrayList<Integer>());
			return result;
		}
		List<List<Integer>> tmp = getPowerSets(array, beg + 1);
		for (List<Integer> list : tmp) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(array[beg]);
			result.add(newList);
			result.add(list);
		}
		return result;
	}
	
	@Test
	public void tc1() {
		int[] array = {0, 1, 2};
		Q05 tc = new Q05();
		List<List<Integer>> result = tc.getPowerSets(array);
		assertTrue(result.size() == 8);
	}
}
