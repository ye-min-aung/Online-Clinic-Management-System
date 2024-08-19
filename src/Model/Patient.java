package Model;

import java.sql.Date;

public class Patient {
	
	private int patient_id;
	private String patient_name;
	private String patient_password;
	
	private String patient_gender;
	private Date patient_birth_date;
	private String patient_address;
	private String patient_contact_no;
	private Date patient_register_date;
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getPatient_password() {
		return patient_password;
	}
	public void setPatient_password(String patient_password) {
		this.patient_password = patient_password;
	}
	
	public String getPatient_gender() {
		return patient_gender;
	}
	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}
	public Date getPatient_birth_date() {
		return patient_birth_date;
	}
	public void setPatient_birth_date(Date patient_birth_date) {
		this.patient_birth_date = patient_birth_date;
	}
	public String getPatient_address() {
		return patient_address;
	}
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}
	public String getPatient_contact_no() {
		return patient_contact_no;
	}
	public void setPatient_contact_no(String patient_contact_no) {
		this.patient_contact_no = patient_contact_no;
	}
	public Date getPatient_register_date() {
		return patient_register_date;
	}
	public void setPatient_register_date(Date patient_register_date) {
		this.patient_register_date = patient_register_date;
	}
	
}
