import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sentence {
	private String wholeCondition;
	private List<String> conditions;
	private List<String> conclusions;
	private VariableMap vm;
	
	public Sentence(String cond, String concl, VariableMap vm) {
		this.vm = vm;
		
		cond = cond.replace("(", "").replace(")", "");
		wholeCondition = (cond.trim());
		conditions = Arrays.asList(cond.split("E"));
		conditions = conditions.stream().map(String::trim).collect(Collectors.toList());
		conditions.forEach(c -> addToVM(c));
		conditions = conditions.stream().map(c -> removeOp(c)).collect(Collectors.toList());
		
		concl = concl.replace("(", "").replace(")", "");
		conclusions = Arrays.asList(concl.split("E"));
		conclusions = conclusions.stream().map(String::trim).collect(Collectors.toList());
	}
	
	public List<String> validateCondition(String cond) {
		conditions.remove(cond);
		if(conditions.isEmpty()) {
			conclusions.forEach(c -> addToVM(c));
			return conclusions;
		}
		else return null;
	}
	
	public boolean checkConclusion(String concl) {
		List<String> aux = Arrays.asList(concl.split("E"));
		aux = aux.stream().map(String::trim).collect(Collectors.toList());
		if(conclusions.equals(aux)) return true;
		else return false;
	}
	
	public List<String> getConclusions() {
		return conclusions;
	} 
	
	public List<String> getConditions() {
		return conditions;
	}

	public String getWholeCondition() {
		return wholeCondition;
	}
	
	private String removeOp(String c) {
		return c.split("==")[0].split(">=")[0].split("<=")[0].split(">")[0].split("<")[0].split("!=")[0].replaceAll("~", "").trim();
	}
	
	private void addToVM(String c) {
		c = c.trim();
		if(c.contains("==")) {
			String[] result = c.split("==");
			vm.addVariable(result[0].trim(), "==", Double.parseDouble(result[1].trim()));
		}
		else if(c.contains(">=")) {
			String[] result = c.split(">=");
			vm.addVariable(result[0].trim(), ">=", Double.parseDouble(result[1].trim()));
		}
		else if(c.contains("<=")) {
			String[] result = c.split("<=");
			vm.addVariable(result[0].trim(), "<=", Double.parseDouble(result[1].trim()));
		}
		else if(c.contains(">")) {
			String[] result = c.split(">");
			vm.addVariable(result[0].trim(), ">", Double.parseDouble(result[1].trim()));
		}
		else if(c.contains("<")) {
			String[] result = c.split("<");
			vm.addVariable(result[0].trim(), "<", Double.parseDouble(result[1].trim()));
		}
		else if(c.contains("!=")) {
			String[] result = c.split("!=");
			vm.addVariable(result[0].trim(), "!=", Double.parseDouble(result[1].trim()));
		}
		else {
			if(c.contains("~")) vm.addVariable(c.substring(1), "", 0.0);
			else vm.addVariable(c, "", 1.0);
		}
	}
	
}
