package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Add() {
		super();
		list = new List();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("/add");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		String[] added = request.getParameterValues(page);

		if (added != null) {
			out.println(
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			out.println("<title>Store</title>");
			out.println(
					"<link rel=\"stylesheet\" href=\"css/blueprint/screen.css\" type=\"text/css\" media=\"screen, projection\">");
			out.println("<link rel=\"stylesheet\" href=\"css/blueprint/print.css\" type=\"text/css\" media=\"print\">");
			out.println(
					"<link rel=\"stylesheet\" href=\"css/blueprint/plugins/fancy-type/screen.css\" type=\"text/css\" media=\"screen, projection\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<div class=\"container\">");
			out.println("<div class=\"span-4 colborder\">");
			out.println("<hr><h3><a href=\"Books.html\">Books</a></h3>");
			out.println("<h3><a href=\"Music.html\">Music</a></h3>");
			out.println("<h3><a href=\"Computers.html\">Computers</a></h3>");
			out.println("</div>");
			out.println("<div class=\"span-15\">");
			out.println("<hr>");
			out.println("<h4>The following item has been added to your shopping cart successfully</h4>");
			for (int i = 0; i < added.length; i++) {
				out.println("- " + list.getMap().get(added[i]).getName() + "<br/>");
			}
			out.println("<br/>");
			out.println(
					"<h4><a href=\"cart\">[View Cart]</a> <a href=\"Books.html\">[Go to Books Page]</a> <a href=\"Music.html\">[Go to Music Page]</a> <a href=\"Computers.html\">[Go to Computers Page]</a></h4>");
			out.println("</div>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

			for (int i = 0; i < added.length; i++) {
				list.getMap().get(added[i]).setAdded(true);
			}
			session.setAttribute("list", list);

		} else {
			switch (page) {
			case "book":
				response.sendRedirect("Books.html");
				break;
			case "laptop":
				response.sendRedirect("Computers.html");
				break;
			case "cd":
				response.sendRedirect("Music.html");
				break;
			}
		}

	}
}
