package conversion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ConvertMasse
 */
public class ConvertMasse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertMasse() {
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
		double number = Double.parseDouble(request.getParameter("number"));
		String unit1 = request.getParameter("unit1");
		String unit2 = request.getParameter("unit2");
		
		Double r = convertMasse(number, unit1, unit2);
		request.setAttribute("unity", unit2);
		request.setAttribute("responsevalue", r);
		request.getRequestDispatcher("/poid.jsp").forward(request, response);
		
	}
	
	private double convertMasse(double quantity, String unit1, String unit2) {
        double convertedValue = 0.0;
        
        if (unit1.equals("gramme")) {
            if (unit2.equals("kilogramme")) {
                convertedValue = quantity / 1000;
            } else if (unit2.equals("livre")) {
                convertedValue = quantity * 0.00220462;
            } else if (unit2.equals("once")) {
                convertedValue = quantity * 0.035274;
            } else { // unité de destination est gramme
                convertedValue = quantity;
            }
        } else if (unit1.equals("kilogramme")) {
            if (unit2.equals("gramme")) {
                convertedValue = quantity * 1000;
            } else if (unit2.equals("livre")) {
                convertedValue = quantity * 2.20462;
            } else if (unit2.equals("once")) {
                convertedValue = quantity * 35.274;
            } else { // unité de destination est kilogramme
                convertedValue = quantity;
            }
        } else if (unit1.equals("livre")) {
            if (unit2.equals("gramme")) {
                convertedValue = quantity / 0.00220462;
            } else if (unit2.equals("kilogramme")) {
                convertedValue = quantity / 2.20462;
            } else if (unit2.equals("once")) {
                convertedValue = quantity * 16;
            } else { // unité de destination est livre
                convertedValue = quantity;
            }
        } else if (unit1.equals("once")) {
            if (unit2.equals("gramme")) {
                convertedValue = quantity / 0.035274;
            } else if (unit2.equals("kilogramme")) {
                convertedValue = quantity / 35.274;
            } else if (unit2.equals("livre")) {
                convertedValue = quantity / 16;
            } else { // unité de destination est once
                convertedValue = quantity;
            }
        }
        return convertedValue;
    }
}


