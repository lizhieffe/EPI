package Chap06;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q25 {
	public void findAttackPositions(boolean[][] array) {
		if (array == null || array.length == 0 || array[0].length == 0)
			return;
		boolean firstRowAttacked = false;
		boolean firstColumnAttacked = false;
		for (int i = 0; i < array.length; i++)
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] == false) {
					if (i == 0)
						firstRowAttacked = true;
					else
						array[i][0] = false;
					if (j == 0)
						firstColumnAttacked = true;
					else
						array[0][j] = false;
				}
			}
		for (int i = 1; i < array.length; i++)
			if (array[i][0] == false)
				setRow(array, i, false);
		for (int j = 1; j < array[0].length; j++)
			if (array[0][j] == false)
				setColumn(array, j, false);
		if (firstRowAttacked)
			setRow(array, 0, false);
		if (firstColumnAttacked)
			setColumn(array, 0, false);		
	}
	
	private void setRow(boolean[][] array, int i, boolean val) {
		for (int j = 0; j < array[0].length; j++)
			array[i][j] = val;
	}
	
	private void setColumn(boolean[][] array, int j, boolean val) {
		for (int i = 0; i < array.length; i++)
			array[i][j] = val;
	}
	
	@Test
	public void tc() {
		boolean[][] array = {{true, true, true}, {false, true, true}, {true, true, false}};
		Q25 tc = new Q25();
		tc.findAttackPositions(array);
		assertTrue(array[0][0] == false);
		assertTrue(array[0][1] == true);
		assertTrue(array[1][0] == false);
	}
}
