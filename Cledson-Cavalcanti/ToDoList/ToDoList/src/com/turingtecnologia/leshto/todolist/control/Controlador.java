package com.turingtecnologia.leshto.todolist.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.turingtecnologia.leshto.todolist.control.faz.Fazedor;

/**
 * Servlet implementation class Controlador
 */
@WebServlet(description = "Decide qual operação o app deve realizar", urlPatterns = { "/acao" })
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fazer = request.getParameter("fazer");
		String className = "com.turingtecnologia.leshto.todolist.control.faz.";
		try {
			Fazedor fazedor = (Fazedor) Class.forName(className + fazer).newInstance();
			fazedor.fazendo(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Ferrou!");
		}
	}

}
