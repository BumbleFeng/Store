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
@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List list;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Cart() {
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
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		list = (List) session.getAttribute("list");

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">");
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
		out.println("<h2>Items Currently in Your Cart</h2>");
		out.println("<hr>");
		out.println("<div class=\"span-8\">");
		int a = 0;
		double total = 0;
		if (list != null) {
			for (Item i : list.getMap().values()) {
				if (i.isAdded()) {
					out.println((a++ + 1) + ". " + i.getName() + "<br/>");
					total += i.getPrice();
				}
			}
		}
		if (a == 0) {
			out.println("<h3>Empty</h3>");
		}
		out.println("<br/>");
		out.println("</div>");
		out.println("<div class=\"span-2\">");
		if (list != null) {
			for (Item i : list.getMap().values()) {
				if (i.isAdded()) {
					out.println("$" + i.getPrice() + "<br/>");
				}
			}
		}
		out.println("</div>");
		out.println("<div class=\"span-4\">");
		out.println("<form name=\"form\" method=\"post\">");
		if (list != null) {
			for (Item i : list.getMap().values()) {
				if (i.isAdded()) {
					out.println("<a onclick=\"form.action='cart?remove=" + i.getId()
							+ "';form.submit();\">[remove from cart]</a><br/>");
				}
			}
		}
		out.println("</form>");
		out.println("</div>");
		out.println("<hr>");
		out.println("<div class=\"span-8\">");
		out.println("<b>TOTAL:</b>");
		out.println("</div>");
		out.println("<div class=\"span-2\">");
		out.println("<b>$" + String.format("%.2f", total) + "</b");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("remove");
		HttpSession session = request.getSession();
		list = (List) session.getAttribute("list");
		list.getMap().get(id).setAdded(false);
		doGet(request, response);
	}

}
