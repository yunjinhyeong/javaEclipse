package com.exam.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "*.do", loadOnStartup = 1)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() »£√‚µ ");
		// application ∞¥√º ∞°¡ÆøÕº≠ « ø‰«— µ•¿Ã≈Õ ¿˙¿Â
		ServletContext application = config.getServletContext();
		application.setAttribute("aa", "æ»≥Á");
		String hello = (String)application.getAttribute("aa");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() »£√‚µ ");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() »£√‚µ ");
	}
	
	public void destroy() {
		System.out.println("destroy() »£√‚µ ");
	}
}
