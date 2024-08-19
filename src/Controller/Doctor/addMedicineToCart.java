package Controller.Doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addMedicineToCart
 */
@WebServlet("/addMedicineToCart")
public class addMedicineToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addMedicineToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String medicine = request.getParameter("medicineId");
//		int medicineId=Integer.parseInt(medicine);
//
//      HttpSession session = request.getSession();
//        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
//
//        if (cart == null) {
//            cart = new ArrayList<>();
//        }
//
//        cart.add(medicineId);
//       session.setAttribute("cart",cart);
//       System.out.print(cart);
//        response.sendRedirect("/ClinicManagementSystem/views/Clinic/doctor/medicine.jsp");
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String medicine = request.getParameter("medicineId");
	    int medicineId = Integer.parseInt(medicine);

	    HttpSession session = request.getSession();
	    List<Integer> cart = (List<Integer>) session.getAttribute("cart");

	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    if (!cart.contains(medicineId)) {
	        cart.add(medicineId);
	    }

	    session.setAttribute("cart", cart);

	    response.sendRedirect("/ClinicManagementSystem/Doctor/medicineViewSearch");
	}


	}


