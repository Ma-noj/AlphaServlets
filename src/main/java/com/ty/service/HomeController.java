package com.ty.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.InsertInfo;
import com.ty.dto.User;

@WebServlet("/home")
public class HomeController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InsertInfo dao = new InsertInfo();
		List<User> userdetalies = dao.findAll();
		req.setAttribute("users", userdetalies);
		RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
		dispatcher.forward(req, resp);
	}
}
