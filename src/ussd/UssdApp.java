package ussd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UssdApp
 */
@WebServlet("/UssdApp")
public class UssdApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String menuText;
	 String sessionId;
	 String serviceCode;
	 String phoneNumber;
	 String text;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UssdApp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		sessionId   = request.getParameter("sessionId");
		serviceCode = request.getParameter("serviceCode");
		phoneNumber = request.getParameter("phoneNumber");
		text        = request.getParameter("text");
		handleResponse();
		PrintWriter out = response.getWriter();
		out.println(menuText);
	}
	
	public void handleResponse() {	
		String accountNumber;
		String balance;
		
		switch(text) {
		case (""): 
		    menuText  = "CON What would you like to check \n 1. My Account \n 2. My phone number";
		    break;
		case ("1"):
		    menuText = "CON Choose the account information you want to view \n 1. Account number \n 2. Account balance";
			break;
		case ("2") :
		    menuText = "END Your phone number is " +phoneNumber;
		    break;
	    case ("1*1"):
		    accountNumber  = "ACC1001";
	    	menuText = "END Your account number is "+ accountNumber;
		    break;
	    case ("1*2" ):
		    balance  = "KES 10,000";
		    menuText = "END Your balance is "+ balance;
		    break;
		}
	}

}
