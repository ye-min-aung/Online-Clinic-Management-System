package Model;

import java.sql.Date;

public class DailyReport {
	    private Date prescriptionDate;
	    private int dailyPatients;
	    private double totalCost;
	    
		public Date getPrescriptionDate() {
			return prescriptionDate;
		}
		public void setPrescriptionDate(Date prescriptionDate) {
			this.prescriptionDate = prescriptionDate;
		}
		public int getDailyPatients() {
			return dailyPatients;
		}
		public void setDailyPatients(int dailyPatients) {
			this.dailyPatients = dailyPatients;
		}
		public double getTotalCost() {
			return totalCost;
		}
		public void setTotalCost(double totalCost) {
			this.totalCost = totalCost;
		}
	
}
