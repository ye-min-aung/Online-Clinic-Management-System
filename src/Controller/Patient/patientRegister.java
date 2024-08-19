package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.DBConnection;

@WebServlet("/Patient/register")
public class patientRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public patientRegister() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pname = request.getParameter("patient_name");
        String ppassword = request.getParameter("patient_password");
       
        String pgender = request.getParameter("patient_gender");
        String pbd = request.getParameter("patient_birth_date");
        String paddress = request.getParameter("patient_address");
        String pcno = request.getParameter("patient_contact_no");

        try {
            DBConnection conn = new DBConnection();
            Connection con = conn.getConnection();
            String sql = "INSERT INTO Patient(patient_name, patient_password,patient_gender, patient_birth_date, patient_address, patient_contact_no) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pname);
            ps.setString(2, ppassword);
           
            ps.setString(3, pgender);
            ps.setString(4, pbd);
            ps.setString(5, paddress);
            ps.setString(6, pcno);
            ps.executeUpdate();
            
           // ResultSet rs = ps.getGeneratedKeys();
            
                RequestDispatcher rd = request.getRequestDispatcher("/views/welcome/All.jsp");
                rd.forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
