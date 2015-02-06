
public class Scope {
	//Global Variable
	String globalVariable = "I am a global variable";
	public String electrician = "Tesla";
	public String physicist = "Feynman";
	
	protected String electricity(){
		String scientist = electrician;
		return scientist;
	}
	protected String physics(){
		String scientist = physicist;
		return scientist;
	}
	public static void main(String[] args) {
		Scope scopeObject = new Scope();
		String scientistOne = scopeObject.electricity();
		String scientistTwo = scopeObject.physics();
		System.out.println(scientistOne+" is an electrician.");
		System.out.println(scientistTwo+" is a physicist.");
	}
}
