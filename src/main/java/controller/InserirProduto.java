package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.ProdutoService;
import model.Categoria;
import model.Produto;

/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet("/inserir-produto")
public class InserirProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private ProdutoService service;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Double preco = Double.parseDouble(request.getParameter("preco"));
		Integer codigoCategoria = Integer.valueOf(request.getParameter("codigo_categoria"));

		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setPreco(preco);
		Categoria categoria = new Categoria();
		categoria.setCodigo(codigoCategoria);
		produto.setCategoria(categoria);

		try {
			service.inserir(produto);
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
			PrintWriter out = response.getWriter();
			out.print("<html>");
			out.print("<h2> Nao foi possivel inserir o produto!</h2>");
			out.print("<br");
			out.print("<a href = 'index.jsp'> Voltar </a>");
			out.print("</html>");
		}
	}

}
