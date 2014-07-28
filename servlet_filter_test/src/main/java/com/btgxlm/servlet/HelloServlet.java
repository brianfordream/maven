package com.btgxlm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		
		if(name!=null ){
		if(name.equals("yang"))
		{
			PrintWriter pw=new PrintWriter(response.getOutputStream());
			pw.println("<html><body><h1>");
			pw.println("Welcome king "+name);
			pw.println("authro:"+request.getAttribute("author")); 
			pw.println("</h1></body></html>");
			pw.close();
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);;
			PrintWriter pw=new PrintWriter(response.getOutputStream());
			pw.println("<html><body><h1>");
			pw.println("Welcome visitor "+name);
			pw.println("</h1></body></html>");
			pw.close();
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
