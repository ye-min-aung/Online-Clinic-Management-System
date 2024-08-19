package Model;

import java.util.Date;

public class Reception {
	private int reception_id;
	private String reception_name;
	private String reception_password;
	private String reception_address;
	private int is_confirmed; // Add is_confirmed field

	
	public int getIs_confirmed() {
		return is_confirmed;
	}
	public void setIs_confirmed(int is_confirmed) {
		this.is_confirmed = is_confirmed;
	}
	public int getReception_id() {
		return reception_id;
	}
	public void setReception_id(int reception_id) {
		this.reception_id = reception_id;
	}
	public String getReception_name() {
		return reception_name;
	}
	public void setReception_name(String reception_name) {
		this.reception_name = reception_name;
	}
	public String getReception_password() {
		return reception_password;
	}
	public void setReception_password(String reception_password) {
		this.reception_password = reception_password;
	}
	public String getReception_address() {
		return reception_address;
	}
	public void setReception_address(String reception_address) {
		this.reception_address = reception_address;
	}
	public String getReception_gender() {
		return reception_gender;
	}
	public void setReception_gender(String reception_gender) {
		this.reception_gender = reception_gender;
	}
	public Date getReception_birth_date() {
		return reception_birth_date;
	}
	public void setReception_birth_date(Date reception_birth_date) {
		this.reception_birth_date = reception_birth_date;
	}
	private String reception_gender;
	private Date reception_birth_date;
	
}
