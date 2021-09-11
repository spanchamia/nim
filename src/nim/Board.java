package nim;

import java.util.ArrayList;
import java.util.List;

public class Board {
	// Number of levels on the board.
	private int num_levels;
	private List<Row> rows;
	
	// Constructor.
	public Board(int n) {
		num_levels = n;
		rows = new ArrayList<Row>();
		for (int ii = 0; ii < num_levels; ++ii) {
			rows.add(new Row());
		}
	}
}
