package com.androjavatech4u.controllers;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.androjavatech4u.entities.User;

@Controller
public class UserController 
{

@Autowired
JdbcTemplate jdbc;

@RequestMapping(value = "/login", method = RequestMethod.GET)	
public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session)
{	
String email=request.getParameter("email");
String pass=request.getParameter("pass");
User user=new User();
user.setEmail(email);
user.setPass(pass);
ModelAndView modelAndView=new ModelAndView("index");
modelAndView.addObject("userobj",user);
return modelAndView;
}

@RequestMapping(value = "/register1", method = RequestMethod.GET)	
public ModelAndView doRegister(HttpServletRequest request,HttpServletResponse response,HttpSession session)
{	
String name=request.getParameter("name");
String email=request.getParameter("email");
String mobile=request.getParameter("mobile");
String pass=request.getParameter("pass");
User user=new User();
user.setName(name);
user.setPass(pass);
user.setEmail(email);
user.setMobile(mobile);

String query="insert into user values(?,?,?,?)";
jdbc.execute(query, new PreparedStatementCallback<Boolean>() 
{
	@Override
	public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		ps.setString(1,user.getName());
		ps.setString(2,user.getEmail());
		ps.setString(3,user.getMobile());
		ps.setString(4,user.getPass());
		return ps.execute();
	}
});

//jdbc.execute("insert into user values('"+name+"','"+email+"','"+mobile+"','"+pass+"')");

ModelAndView modelAndView=new ModelAndView("index");
//modelAndView.addObject("userobj",user);
session.setAttribute("email",email);
session.setAttribute("pass",pass);
return modelAndView;
}

}
