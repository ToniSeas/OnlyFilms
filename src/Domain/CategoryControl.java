package Domain;

import java.util.ArrayList;

public class CategoryControl {

	private ArrayList<String> categorys;
	private ArrayList<Integer> counters;

	public CategoryControl() {
		this.categorys = new ArrayList<>();
		this.counters = new ArrayList<>();
	} // Fin del constructor

	public void addSumCategory(String categoria) {
		int index=0;
		
		if (this.categorys.contains(categoria)) {
			index = this.categorys.indexOf(categoria);
			int count=this.counters.get(index);
			this.counters.set(index,  count+ 1);

		} else {

			this.categorys.add(categoria);
			this.counters.add(1);

		} // if / else
		
	} // Fin de addSumCategory

	public String getMostVisited() {

		if (this.categorys.size() > 0) {
			
			int indexMostVisited = 0;

			for (int i = 1; i < this.counters.size(); i++) {

				int c1 = this.counters.get(indexMostVisited);
				int c2 = this.counters.get(i);

				if (c1 < c2) {
					indexMostVisited = i;
				} // if

			} // for i

			return this.categorys.get(indexMostVisited);
			
		} else {
			
			return "null";
			
		} // if / else

	} // Fin de getMostVisited

} // Fin de clase
