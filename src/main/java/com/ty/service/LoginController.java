package com.ty.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.InsertInfo;
import com.ty.dto.User;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("pass");
		
		InsertInfo dao = new InsertInfo();
		User user =  dao.validateUserByEmail(email, password);
		if (user!=null) {
			RequestDispatcher dispatcher= req.getRequestDispatcher("home");
			dispatcher.forward(req, resp);
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
			dispatcher.forward(req, resp);
		}
		
	}
}
