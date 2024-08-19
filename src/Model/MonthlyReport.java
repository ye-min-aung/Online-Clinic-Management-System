package Model;

public class MonthlyReport {
    private String month;
    private int totalPatients;
    private double totalCost;

    public MonthlyReport() {}

    public MonthlyReport(String month, int totalPatients, double totalCost) {
        this.month = month;
        this.totalPatients = totalPatients;
        this.totalCost = totalCost;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalPatients() {
        return totalPatients;
    }

    public void setTotalPatients(int totalPatients) {
        this.totalPatients = totalPatients;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}