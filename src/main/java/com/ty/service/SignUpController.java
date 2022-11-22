package com.ty.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.dao.InsertInfo;
import com.ty.dto.User;

@WebServlet("/signup")
public class SignUpController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phnumber = req.getParameter("phonenumber");
		String password = req.getParameter("pass");
		
		User user = new User();
		user.setId(Integer.parseInt(Id));
		user.setName(name);
		user.setEmail(email);
		user.setPhoneNumber(Long.parseLong(phnumber));
		user.setPassword(password);
		
		InsertInfo dao = new InsertInfo();
		dao.insertUserinfo(user);
	}
}
