package ch.bfh.bti7081.s2015.red.PatientApp.Model;

public class Contact {
	private String name;
	private String phone_number;

	public Contact(String _name, String _phone_number)
	{
		this.name = _name;
		this.phone_number = _phone_number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
}
