import java.util.HashMap;
import java.util.Map;

public class VariableMap {
	//(idade, >=)
	//(idade, 20)
	Map<String, String> stringOperation; // S -> O
	Map<String, Double> stringValue; // S -> V
	Map<String, Double> userTable; // User values
	
	public VariableMap(Map<String, Double> userTable) {
		this.userTable = userTable;
		this.stringOperation = new HashMap<String, String>();
		this.stringValue = new HashMap<String, Double>();
	}
	
	public void addVariable(String var, String op, Double value) {
		this.stringOperation.put(var, op);
		this.stringValue.put(var, value);
	}
	
	public boolean checkVariable(String name) {
		if(stringValue.containsKey(name) && userTable.containsKey(name)) {
			double tableVal = stringValue.get(name);
			double userVal = userTable.get(name);
			
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
		}
		return false;
	}
	
}
