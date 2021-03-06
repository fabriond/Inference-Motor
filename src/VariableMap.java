import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Triple;

public class VariableMap {
	//(idade, >=, 20)
	List<Triple<String, String, Double>> triples; // rules
	Map<String, Double> userTable; // User values
	
	public void printMap() {
		for(Triple<String, String, Double> t : triples) {
			System.out.println(t);
		}
	}
	
	public VariableMap(Map<String, Double> userTable) {
		this.userTable = userTable;
		this.triples = new ArrayList<>();
	}
	
	public void addUserInfo(Triple<String, String, Double> t) {
		if(t.getMiddle().equals(">")) this.userTable.put(t.getLeft(), t.getRight()+0.001);
		else if(t.getMiddle().equals("<")) this.userTable.put(t.getLeft(), t.getRight()-0.001);
		else if(t.getMiddle().equals("!=")) {
			if(t.getRight().equals(0.0)) this.userTable.put(t.getLeft(), -Double.MAX_VALUE);
			else this.userTable.put(t.getLeft(), 0.0);
		}
		else this.userTable.put(t.getLeft(), t.getRight());
	}
	
	public void addVariable(Triple<String, String, Double> triple) {
		triples.add(triple);
	}
	
	public Boolean checkTriple(Triple<String, String, Double> checking){
		String name = checking.getLeft();
		for(Triple<String, String, Double> t : triples) {
			if(t.equals(checking)) {
				if(userTable.containsKey(name)) 
					return consume(t, userTable.get(name));
			}
		}
		return false;
	}
	
	private boolean consume(Triple<String, String, Double> t, double userVal) {
		double tableVal = t.getRight();

		switch(t.getMiddle()) {
			case "==":
				if(userVal == tableVal) return true;
				break;
			case ">=":
				if(userVal >= tableVal) return true;
				break;
			case "<=":
				if(userVal <= tableVal) return true;
				break;
			case ">":
				if(userVal > tableVal) return true;
				break;
			case "<":
				if(userVal < tableVal) return true;
				break;
			case "!=":
				if(userVal != tableVal) return true;
				break;
			case "":
				if(userVal == tableVal) return true;
				break;
		}
		return false;
	}
	/*
	public Boolean checkVariable(String name) {
		//System.out.println(name);
		if(stringValue.containsKey(name)) {
			if(userTable.containsKey(name)) {
				double tableVal = stringValue.get(name);
				double userVal = userTable.get(name);
				System.out.println(tableVal+" "+stringOperation.get(name)+" "+userVal);
				switch(stringOperation.get(name)) {
					case "==":
						if(userVal == tableVal) return true;
						break;
					case ">=":
						if(userVal >= tableVal) return true;
						break;
					case "<=":
						if(userVal <= tableVal) return true;
						break;
					case ">":
						if(userVal > tableVal) return true;
						break;
					case "<":
						if(userVal < tableVal) return true;
						break;
					case "!=":
						if(userVal != tableVal) return true;
						break;
					case "":
						if(userVal == 1.0) return true;
						break;
				}
				return false;
			} else {
				return false;
			}
		}
		return null;
	}
	*/
	
}
