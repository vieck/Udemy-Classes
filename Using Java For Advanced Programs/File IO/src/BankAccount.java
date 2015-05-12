import java.io.Serializable;


public class BankAccount implements Serializable {
	String name;
	String email;
	String account;
	int pin;
	public void creatAccount(){
		System.out.format("Creating an account number %s under %s with the email: %s.\n",account,name,email);
	}
}
