package Controller.Doctor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Medicine;

/**
 * Servlet implementation class removeMedcineToCart
 */
@WebServlet("/removeMedcineToCart")
public class removeMedcineToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeMedcineToCart() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

        // 1. Get Medicine ID
        String medicineIdStr = request.getParameter("medicineId");
        if (medicineIdStr == null) {
            // Handle error - Medicine ID not provided
            // ... (e.g., display an error message)
            return;
        }

        int medicineIdToRemove;
        try {
            medicineIdToRemove = Integer.parseInt(medicineIdStr);
        } catch (NumberFormatException e) {
            // Handle error - Invalid Medicine ID format
            // ... (e.g., display an error message)
            return;
        }

        // 2. Update the Cart in Session
        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
        if (cart != null) {
            // Remove the medicine ID from the cart list
            cart.remove((Integer) medicineIdToRemove); // Use Integer.valueOf()
           
            if (!cart.isEmpty()) { // Only update cart if not empty
                session.setAttribute("cart", cart);
            } else {
                // If the cart is empty, remove the cart attribute from the session
                session.removeAttribute("cart"); 
            }
            
            // 3. Redirect to the Prescription Page
            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/Prescription.jsp");
    		rd.forward(request, response);
        } else {
            // Handle error - Cart not found in session
            // ... (e.g., display an error message)
        }
    }
	
	}