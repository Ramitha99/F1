import java.util.Comparator;
/**
 * 
 * @author Ramitha Manathunga
 *
 */
public class CustomComparator implements Comparator < Formula1Driver >{
	
	/*
	 * this is for sort the drivers list
	 * will display the drivers list descending order.
	 * driver with the highest points will appear first.
	 * if points are same, driver with the most first positions will appear first
	 */

	@Override
	public int compare(Formula1Driver o1, Formula1Driver o2) {
		
		if (o1.getPoints() > o2.getPoints())
			return -1;
		else
			if (o1.getPoints() < o2.getPoints())
				return 1;
			else 
				if (o1.getFirstPositions() > o2.getFirstPositions())
					return -1;
				else
					if (o1.getFirstPositions() < o2.getFirstPositions())
						return 1;
					else return 0;
	}

}
