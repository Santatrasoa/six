package conversion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ConvertT
 */
public class ConvertT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertT() {
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
		String unit1 = request.getParameter("unit1");
		String unit2 = request.getParameter("unit2");
		String number = request.getParameter("number");
		
		
		String result = convert(unit1, unit2, number);
		request.setAttribute("unity", unit2);
		request.setAttribute("responsevalue", result);
		request.getRequestDispatcher("/temperature.jsp").forward(request, response);
	}

	public String convert(String unit1, String unit2, String number)
	{
		Double d = Double.parseDouble(number);
		Double res = d;
		if (unit1.equals("Celsuis"))
		{
			if (unit2.equals("Kelvin"))
			{
				res = d + 273.15;
			}
			if (unit2.equals("Fahrenheit"))
			{
				res = (9/4)*d+32;
			}
			if (unit2.equals("Rankine"))
			{
				res = (d+273.15)*(5/9);
			}
			
		}
		else if (unit1.equals("Kelvin"))
		{
			if (unit2.equals("Celsius"))
			{
				res = d - 273.15;
			}
			if (unit2.equals("Fahrenheit"))
			{
				res = (9/5)*(d-273.15) + 32;
			}
			if (unit2.equals("Rankine"))
			{
				res = (9/5)*d;
			}
		}

		else if (unit1.equals("Fahrenheit"))
		{
			if (unit2.equals("Kelvin"))
			{
				res = (5/9)*(d-32) + 273.15;
			}
			if (unit2.equals("Celsius"))
			{
				res = (5/9)*(d-32);
			}
			if (unit2.equals("Rankine"))
			{
				res = 459.67 + d;
			}
		}

		else if (unit1.equals("Rankine"))
		{
			if (unit2.equals("Celsius"))
			{
				res = (5/9) * (d - 459.67);
			}
			if (unit2.equals("Fahrenheit"))
			{
				res = d - 459.67;
			}
			if (unit2.equals("Kelvin"))
			{
				res = (5/9)*d;
			}
		}
		
		String result = Double.toString(res);
		
		return result;
	
	}
	
}
