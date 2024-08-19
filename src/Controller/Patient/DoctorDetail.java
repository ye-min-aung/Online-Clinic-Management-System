package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.DBConnection;

@WebServlet("/Patient/DoctorDetail")
public class DoctorDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM Doctor WHERE doctor_id=" + doctorId;

            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String dName = rs.getString("doctor_name");
                String dQualification = rs.getString("doctor_qualification");
                String dSpecialization = rs.getString("doctor_specialization");
                String dContactNo = rs.getString("doctor_contact_no");
                String dConsultationFee = rs.getString("consultation_fee");
                int dExp = rs.getInt("year_of_experience");
                String dImage = rs.getString("doctor_image"); // Assuming 'doctor_image' is your column name

                request.setAttribute("dName", dName);
                request.setAttribute("dQualification", dQualification);
                request.setAttribute("dSpecialization", dSpecialization);
                request.setAttribute("dContactNo", dContactNo);
                request.setAttribute("dConsultationFee", dConsultationFee);
                request.setAttribute("dExp", dExp);
                request.setAttribute("dImage", dImage); // Set the image filename as a request attribute

                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/patient/doctorProfile.jsp");
                rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
