package Model;

import java.sql.Date;

public class Invoice {
	
	
	private String patient_name;
	private String doctor_name;
	private Date prescription_date;
 	private String consultation_fee;
	private double total_cost;
	
	
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}
	public Date getPrescription_date() {
		return prescription_date;
	}
	public void setPrescription_date(Date prescription_date) {
		this.prescription_date = prescription_date;
	}
	public String getConsultation_fee() {
		return consultation_fee;
	}
	public void setConsultation_fee(String consultation_fee) {
		this.consultation_fee = consultation_fee;
	}
	public double getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(double total_cost) {
		this.total_cost = total_cost;
	}
	
	
}
