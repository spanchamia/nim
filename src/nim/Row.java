package nim;

import java.util.HashSet;
import java.util.Set;

public class Row implements Comparable<Row> {
	// Number of sticks in the row.
    private int num_sticks;
    
    // Constructor for an empty row.
    public Row() {
    	num_sticks = 0;
    }
    
    public int GetNumSticks() {
    	return num_sticks;
    }
    
    // Constructor for a row with the given number of sticks.
    public Row(int n) {
    	num_sticks = n;
    }
    
    // Enumerates the different types of rows.
    public enum Type {
    	// A row with 0 sticks.
    	T0,
    	
    	// A row with 1 stick.
    	T1,
    	
    	// A row with 2 or more sticks.
    	T2
    }
    
    // Returns the row type.
    public Type GetType() {
    	if (num_sticks == 0) return Type.T0;
    	if (num_sticks == 1) return Type.T1;
    	return Type.T2;
    }
    
    public String GetTypeStr() {
    	switch (GetType()) {
    	case T0: return "0";
    	case T1: return "1";
    	default: return "+";
    	}
    }
    
    public Set<Type> GetHigherLevelTypes() {
    	Set<Type> higher_level_types = new HashSet<Type>();
    	switch (GetType()) {
    	case T0:
    		higher_level_types.add(Type.T1);
    		higher_level_types.add(Type.T2);
    		break;
    	case T1:
    		higher_level_types.add(Type.T2);
    		break;
    	default:
    		higher_level_types.add(Type.T2);
    	}
    	
    	return higher_level_types;
    }
    
    public Set<Type> GetLowerLevelTypes() {
    	Set<Type> lower_level_types = new HashSet<Type>();
    	switch (GetType()) {
    	case T1:
    		lower_level_types.add(Type.T0);
    		break;
    	case T2:
    		lower_level_types.add(Type.T0);
    		lower_level_types.add(Type.T1);
    		break;
    	default:
    		break;
    	}
    	
    	return lower_level_types;
    }

	@Override
	public int compareTo(Row o) {
		return GetNumSticks() - o.GetNumSticks();
	}
}
