package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.DBConnection;

@WebServlet("/patientUpdateProfile")
public class patientUpdateProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public patientUpdateProfile() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String pId = (String) session.getAttribute("patientId");
        String name = request.getParameter("patient_name");
        String password = request.getParameter("patient_password");
      
        String gender = request.getParameter("patient_gender");
        String bd = request.getParameter("patient_birth_date");
        String address = request.getParameter("patient_address");
        String cno = request.getParameter("patient_contact_no");

        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE Patient SET patient_name=?, patient_password=?,patient_gender=?, patient_birth_date=?, patient_address=?, patient_contact_no=? WHERE patient_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
          
            ps.setString(3, gender);
            ps.setString(4, bd);
            ps.setString(5, address);
            ps.setString(6, cno);
            ps.setString(7, pId);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                session.setAttribute("patientName", name);
                session.setAttribute("patientPassword", password);
                
                session.setAttribute("patientGender", gender);
                session.setAttribute("patientBirthDate", bd);
                session.setAttribute("patientAddress", address);
                session.setAttribute("patientContactNo", cno);

                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/patient/patientHome.jsp");
                rd.forward(request, response);
            } else {
                System.out.println("Update failed");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
