package br.inatel.dm110.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/partnerServlet")
public class PartnerServlet extends HttpServlet {

	static final long serialVersionUID = 8265674317700222667L;
	private static Logger log = 
			Logger.getLogger(PartnerServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String partner = req.getParameter("partner");
		log.info("name: " + partner);
		resp.setContentType("text/html");

		try (PrintWriter out = resp.getWriter()) {
			out.println("<h1>This is a message from the partnerServlet!</h1>");
			if (partner == null) {
				out.println("<h3>I did not inserted any partner!</h3>");
			} else {
				out.println("<h3>Hello, " + partner + "</h3>");
			}
			out.println("Current date: " + new java.util.Date());
			out.println("Class: " + PartnerServlet.class.getName());
			out.println("Operational System : " 
					+ System.getProperty("os.name")
			);
		}
	}
}
