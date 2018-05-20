import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Test {
	static Map<String, Double> userVariables;
	static {
		userVariables = new HashMap<String, Double>();
		userVariables.put("glicemiaJejum", 150.0);
		userVariables.put("glicemia2h", 30.0);
		userVariables.put("idade", 45.0);
		userVariables.put("testeGlicêmico", 0.0);
		userVariables.put("Ttg", 0.0); // (Teste de tolerancia a glicose)
		userVariables.put("Gja", 0.0); // (Glicose em jejum alterada)
		userVariables.put("Tdg", 0.0); // (Tolerancia diminuída a glicose)
		userVariables.put("Dm2", 0.0); // (Diabetes 2)
		userVariables.put("Mev", 0.0); // (Mudança no estilo de vida)
	}
	
	public static void main(String[] args) throws IOException {
		Motor.setMap(new VariableMap(userVariables));
		//Motor.listRules();
		Motor.readDatabase();
		Motor.askQuestions();
	}
}
