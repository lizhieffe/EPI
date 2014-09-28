package Chap19;

import java.util.Comparator;


class DistanceComparator implements Comparator<Distance> {

	public int compare(Distance arg0, Distance arg1) {
		if (arg0.distance < arg1.distance)
			return -1;
		else if (arg0.distance == arg1.distance)
			return 0;
		else
			return 1;
	}
	
}