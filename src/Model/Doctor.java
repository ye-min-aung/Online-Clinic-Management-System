package Model;

public class Doctor {
	
	private int doctor_id;
	private String doctor_name;
	private String doctor_gender;
	private String doctor_qualification;
	private String doctor_specialization;
	private String doctor_contact_no;
	private String doctor_password;
	private String doctor_email;
	private String consultation_fee;
	private int year_of_experience;
	private String doctor_address;
	private String doctor_image;
	private int is_confirmed; // Add is_confirmed field

	
	public int getIs_confirmed() {
		return is_confirmed;
	}
	public void setIs_confirmed(int is_confirmed) {
		this.is_confirmed = is_confirmed;
	}

	
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public String getDoctor_gender() {
		return doctor_gender;
	}
	public void setDoctor_gender(String doctor_gender) {
		this.doctor_gender = doctor_gender;
	}
	public String getDoctor_qualification() {
		return doctor_qualification;
	}
	public void setDoctor_qualification(String doctor_qualification) {
		this.doctor_qualification = doctor_qualification;
	}
	public String getDoctor_specialization() {
		return doctor_specialization;
	}
	public void setDoctor_specialization(String doctor_specialization) {
		this.doctor_specialization = doctor_specialization;
	}
	public String getDoctor_contact_no() {
		return doctor_contact_no;
	}
	public void setDoctor_contact_no(String doctor_contact_no) {
		this.doctor_contact_no = doctor_contact_no;
	}
	public String getDoctor_password() {
		return doctor_password;
	}
	public void setDoctor_password(String doctor_password) {
		this.doctor_password = doctor_password;
	}
	public String getDoctor_email() {
		return doctor_email;
	}
	public void setDoctor_email(String doctor_email) {
		this.doctor_email = doctor_email;
	}
	public String getConsultation_fee() {
		return consultation_fee;
	}
	public void setConsultation_fee(String consultation_fee) {
		this.consultation_fee = consultation_fee;
	}
	public int getYear_of_experience() {
		return year_of_experience;
	}
	public void setYear_of_experience(int year_of_experience) {
		this.year_of_experience = year_of_experience;
	}
	public String getDoctor_address() {
		return doctor_address;
	}
	public void setDoctor_address(String doctor_address) {
		this.doctor_address = doctor_address;
	}
	public String getDoctor_image() {
		return doctor_image;
	}
	public void setDoctor_image(String doctor_image) {
		this.doctor_image = doctor_image;
	}

}
