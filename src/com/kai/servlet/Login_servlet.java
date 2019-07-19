package com.kai.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kai.model.DBHelper;
import com.kai.model.User;

/**
 * Servlet implementation class Login_servlet
 */
@WebServlet(
		urlPatterns = { "/Login_servlet" }, 
		initParams = { 
				@WebInitParam(name = "default", value = "this is a default value")
		})
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login_servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		//response.getWriter().append("login access ").append(account).append(password);
		
		//request.getRequestDispatcher("LogoinSuccessful.jsp").forward(request, response);
		DBHelper dbHelper = new DBHelper();
		try {
			dbHelper.iscurrect(account, password);
			if (true) {
		        request.getRequestDispatcher("LoginSuccessful.jsp").forward(request, response);
			}else {
		        request.getRequestDispatcher("LoginFailed.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
