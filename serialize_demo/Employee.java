public class Employee implements java.io.Serializable{

	public String name;
	public String address;
	public transient int SSN;
	public int number;

	public Employee(){

	}

	public Employee(String nm, String addr, int ssn, int num){
		name = nm;
		address = addr;
		SSN = ssn;
		number = num;
	}

	public void mailCheck(){

		System.out.println("Mailing a check to "+name+" "+address);
	}//end method
}//end class