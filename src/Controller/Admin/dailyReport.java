package Controller.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;
import Model.DailyReport;
import Model.Doctor;

/**
 * Servlet implementation class dailyReport
 */
@WebServlet("/dailyReport")
public class dailyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dailyReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    	HttpSession session=request.getSession();
//    	ArrayList<DailyReport> dailyReports = new ArrayList<>();
//        try {
//        	Connection conn = DBConnection.getConnection();
//            String query = "SELECT pr.prescription_date, COUNT(*) AS daily_Patients, " +
//                    "SUM(m.unit_price * pr.frequency * pr.duration) + SUM(d.consultation_fee) AS total_cost " +
//                    "FROM Prescription pr " +
//                    "JOIN Doctor d ON pr.doctor_id = d.doctor_id " +
//                    "JOIN Medicine m ON pr.medicine_id = m.medicine_id " +
//                    "GROUP BY pr.prescription_date " +
//                    "ORDER BY pr.prescription_date";    
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//            
//            while (rs.next()) {
//                DailyReport report = new DailyReport();
//                report.setPrescriptionDate(rs.getDate("prescription_date"));
//                report.setDailyPatients(rs.getInt("daily_Patients"));
//                report.setTotalCost(rs.getDouble("total_cost"));
//                dailyReports.add(report);
//            }
//            		
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        session.setAttribute("dailyReports",dailyReports);
//		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/daily.jsp");
//		rd.forward(request, response);
//    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<DailyReport> dailyReports = new ArrayList<>();
        String searchMonth = request.getParameter("searchMonth");

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT pr.prescription_date, COUNT(DISTINCT pr.patient_id) AS daily_Patients, " +
                    "SUM(m.unit_price * pr.frequency * pr.duration) + SUM(d.consultation_fee) AS total_cost " +
                    "FROM Prescription pr " +
                    "JOIN Doctor d ON pr.doctor_id = d.doctor_id " +
                    "JOIN Medicine m ON pr.medicine_id = m.medicine_id ";

            if (searchMonth != null && !searchMonth.isEmpty()) {
                query += "WHERE DATE_FORMAT(pr.prescription_date, '%Y-%m') = ? ";
            }

            query += "GROUP BY pr.prescription_date " +
                     "ORDER BY pr.prescription_date";

            PreparedStatement pstmt = conn.prepareStatement(query);
            
            if (searchMonth != null && !searchMonth.isEmpty()) {
                pstmt.setString(1, searchMonth);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                DailyReport report = new DailyReport();
                report.setPrescriptionDate(rs.getDate("prescription_date"));
                report.setDailyPatients(rs.getInt("daily_Patients"));
                report.setTotalCost(rs.getDouble("total_cost"));
                dailyReports.add(report);
            }
            
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("dailyReports", dailyReports);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/admin/daily.jsp");
        rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
