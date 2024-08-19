package Model;

public class Report {
	private String date;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPatients() {
		return patients;
	}
	public void setPatients(int patients) {
		this.patients = patients;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	private int patients;
	private double totalCost;
	
}
