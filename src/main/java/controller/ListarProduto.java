package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ObjectUtils;
import business.ProdutoService;
import model.Produto;

/**
 * Servlet implementation class InserirCategoria
 */
@WebServlet("/listar-produto")
public class ListarProduto extends HttpServlet {
	@EJB
	private ProdutoService service;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			listaProduto(request, response);
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listaProduto(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String codigoCategoria = request.getParameter("codigo_categoria");
		String nomeProduto = request.getParameter("nome_produto");

		List<Produto> listaProduto;
		if (ObjectUtils.isEmpty(codigoCategoria) && !ObjectUtils.isEmpty(nomeProduto)) {
			throw new RuntimeException(
					"Necessario informar a categoria para retornar a lista de produtos para realizar o filtro pelo nome.");
		} else if (!ObjectUtils.isEmpty(codigoCategoria) && !ObjectUtils.isEmpty(nomeProduto)) {
			listaProduto = service.listarByCodigoCategoriaAndNomeProduto(Integer.valueOf(codigoCategoria), nomeProduto);
		} else {
			listaProduto = service.listarByCodigoCategoria(Integer.valueOf(codigoCategoria));
		}
		request.setAttribute("listaProduto", listaProduto);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listar_produto.jsp");
		dispatcher.forward(request, response);
	}
}