package br.com.casacriativa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.casacriativa.bd.IdeiasDao;
import br.com.casacriativa.modelo.Ideias;

@WebServlet("/adiciona-ideia")
public class AdicionaIdeiaServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		// busca o writer
		PrintWriter out = response.getWriter();
		
		// buscando os parâmetros no request
		String nomeIdeia = request.getParameter("nomeIdeia");
		String categoriaIdeia = request.getParameter("categoriaIdeia");
		String descricaoIdeia = request.getParameter("descricaoIdeia");
	
		// monta um objeto ideia
		Ideias ideia = new Ideias();
		ideia.setNomeIdeia(nomeIdeia);
		ideia.setCategoriaIdeia(categoriaIdeia);
		ideia.setDescricaoIdeia(descricaoIdeia);
		
		// salva o ideia
		IdeiasDao dao = new IdeiasDao();
		dao.adicionaIdeia(ideia);
		
		// refresh na pagina index.jsp
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv=\"refresh\" content=\"0; URL='index.jsp '\"/>");
		out.println("<head>");
	}
}
