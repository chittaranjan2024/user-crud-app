package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			 case "/delete":deleteUser(request, response); break;	
			 case "/edit":editUser(request, response);break;
			 case "/view":viewUser(request, response);break;
			 case "/update":updateUser(request, response);break;	 
			 case "/list":listUser(request, response);break;	
			 case "/login":login(request, response);break;
			 case "/loginprocess":loginProcess(request, response);break;
			 case "/logout":logout(request, response);break;
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
		if(isLoggedIn(request, response))
		{
			List<User> users=dao.selectAllUsers();
			request.setAttribute("listuser", users);
			RequestDispatcher dispatcher=request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
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
	
	
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	public void loginProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			PreparedStatement preparedStatement=connection.prepareStatement("select * from users where email=? and passwd=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet result=preparedStatement.executeQuery();
			
			if(result.next())
			{
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("status", "active");
				httpSession.setAttribute("email",email);
				RequestDispatcher dispatcher=request.getRequestDispatcher("welcome.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				HttpSession httpSession=request.getSession();
				httpSession.setAttribute("status", "Inactive");
				RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession httpSession=request.getSession();
		httpSession.invalidate();
		RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	public Boolean isLoggedIn(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		HttpSession httpSession=request.getSession();
		
		
		if(httpSession.getAttribute("status")!=null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			User user=dao.selectUser(id);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher=request.getRequestDispatcher("edit.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	
	
	public void viewUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			User user=dao.selectUser(id);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher=request.getRequestDispatcher("view.jsp");
			dispatcher.forward(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response)
	{
		boolean status=false;
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			User user=dao.selectUser(id);
			user.setName(name);
			user.setEmail(email);
			user.setCountry(country);
			
			System.out.println(user);
			 status=dao.updateUser(user);
			System.out.println(status);
			response.sendRedirect("list");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	
		
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
	{
		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO dao=new UserDAO();
		try(Connection connection=dao.getConnection())
		{
			dao.deleteUser(id);
			response.sendRedirect("list");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
