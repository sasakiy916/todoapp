package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDAO;
import model.Todo;

@WebServlet("/Read")
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDAO dao = new TodoDAO();
		List<Todo> list = dao.findAll();
		request.setAttribute("list",list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/read.jsp");
		rd.forward(request, response);
	}
}
