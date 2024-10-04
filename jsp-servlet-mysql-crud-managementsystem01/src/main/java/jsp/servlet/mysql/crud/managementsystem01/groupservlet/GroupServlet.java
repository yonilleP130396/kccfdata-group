package jsp.servlet.mysql.crud.managementsystem01.groupservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.servlet.crud.groupgratefulnessmanagementsystem.dao.*;
import jsp.servlet.mysql.crud.managementsystem01.model.*;
/**
 * Servlet implementation class GroupServlet
 */
@WebServlet("/")
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertStudent(request, response);
                    break;
                case "/delete":
                    deleteStudent(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateStudent(request, response);
                    break;
                case "/logout":
                    usersLogout(request, response);
                    break;
                case "/login":
                    usersLogin(request, response);
                    break;
                case "/list":
                    listStudent(request, response);
                    break;
                default:
                	 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                     dispatcher.forward(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    private void listStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Members > listUser = studentDAO.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Members existingUser = studentDAO.selectStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");
        String posistion = request.getParameter("posistion");
        String remarks = request.getParameter("remarks");
        String photo = request.getParameter("picturelocation");
       
        Members newUser = new Members(name, address, course, gender, posistion, remarks, photo);
        studentDAO.insertStudent(newUser);
        response.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");
        String posistion = request.getParameter("posistion");
        String remarks = request.getParameter("remarks");
        String photo = request.getParameter("picturelocation");

        Members book = new Members(id, name, address, course, gender, posistion, remarks, photo);
        studentDAO.updateStudent(book);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect("list");

    }
    
	
    protected void usersLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Fetch the session if it exists, don't create a new one
        if (session != null) {
            session.invalidate(); 
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response); 
    }
    
    protected void usersLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (studentDAO.validateUser(username,password)) { 
            HttpSession session = request.getSession();
            session.setAttribute("useracountname", username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("sidebar.jsp");
            dispatcher.forward(request, response); 
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    
    
   
    
    
}