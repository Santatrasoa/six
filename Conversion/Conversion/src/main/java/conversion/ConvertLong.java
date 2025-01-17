package conversion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*
;
/**
 * Servlet implementation class ConvertLong
 */
public class ConvertLong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertLong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String unit1 = request.getParameter("unit1");
		String unit2 = request.getParameter("unit2");

		String valueToChange = request.getParameter("numberLong");
		Double number = Double.parseDouble(valueToChange);
		String result = conversion(unit1, unit2, number);

		request.setAttribute("unity", unit2);
		request.setAttribute("responsevalue", result);
		request.getRequestDispatcher("/longueur.jsp").forward(request, response);
		
	}

	public String conversion(String unit1, String unit2, Double number) {
		double a=number;

		if (unit1.equals("km"))
		{
			if (unit2.equals("m"))
			{
				a = (double)(number/1000);
			}
			else if (unit2.equals("cm"))
			{
				a = (double)(number/100000);
			}
			else if (unit2.equals("mm"))
			{
				a = (double)(number/1000000);
			}
			else if (unit2.equals("nm"))
			{
				a = (double) (number/Math.pow(10, 12));
			}
		}
		else if (unit1.equals("m"))
		{
			if (unit2.equals("km"))
			{
				a = (double)(number*1000);
			}
			else if (unit2.equals("cm"))
			{
				a = (double)(number/100);
				System.out.println(number + " : " + (double)(100/number));
				
			}
			else if (unit2.equals("mm"))
			{
				a = (double)(number/1000);
			}
			else if (unit2.equals("nm"))
			{
				a = (double) (number/Math.pow(10, 9));
			}
		}
		
		else if (unit1.equals("cm"))
		{
			if (unit2.equals("km"))
			{
				a = (double)(number*100000);
			}
			else if (unit2.equals("m"))
			{
				a = (double)(number*100);
			}
			else if (unit2.equals("mm"))
			{
				a = (double)(number/10);
			}
			else if (unit2.equals("nm"))
			{
				a = (double) (number/Math.pow(10, 7));
			}
		}
		
		else if (unit1.equals("mm"))
		{
			if (unit2.equals("km"))
			{
				a = (double)(number*1000000);
			}
			else if (unit2.equals("m"))
			{
				a = (double)(number*1000);
			}
			else if (unit2.equals("cm"))
			{
				a = (double)(number*10);
			}
			else if (unit2.equals("nm"))
			{
				a = (double) (number/Math.pow(10, 6));
			}
		}
		
		
		else if (unit1.equals("nm"))
		{
			if (unit2.equals("km"))
			{
				a = (double) (number*Math.pow(10, 12));
			}
			else if (unit2.equals("m"))
			{
				a = (double) (number*Math.pow(10, 9));
			}
			else if (unit2.equals("cm"))
			{
				a = (double) (number*Math.pow(10, 7));
			}
			else if (unit2.equals("mm"))
			{
				a = (double) (number*Math.pow(10, 6));
			}
		}
		
		String result = Double.toString(a);
		return result;
	}

}
