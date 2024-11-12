package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.UserDAO;


@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDAO dao;
  
	public void init()
	{
		dao=new UserDAO();
	}
	
    public UserServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getServletPath();
		
		try
		{
			switch(action)
			{
			 case "/new":showNewForm(request, response);break;	
			 case "/insert":insertUser(request, response);	break;
			 case "/delete":break;	
			 case "/edit":break;	
			 case "/update":break;	 
			 case "/list":listUser(request, response);break;	 
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			doGet(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<User> users=dao.selectAllUsers();
		request.setAttribute("listuser", users);
		RequestDispatcher dispatcher=request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
		
	}
	
	public 	void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}
	
	public void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		String password=request.getParameter("password");
		User user=new User(name, email, country,password);
		dao.insertUser(user);
		response.sendRedirect("list");
	}

}
