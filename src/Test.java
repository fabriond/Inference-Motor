import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
	static Map<String, Double> userVariables;
	static Map<String, Double> userVariables2;
	static {
		userVariables = new HashMap<String, Double>();
		userVariables.put("glicemiaJejum", 140.0);
		userVariables.put("glicemia2h", 110.0);
		userVariables.put("idade", 45.0);
	}
	
	public static void main(String[] args) throws IOException {
		Motor.setMap(new VariableMap(userVariables));
		//Motor.listRules();
		Motor.readDatabase();
		Motor.askQuestions();
	}
}
