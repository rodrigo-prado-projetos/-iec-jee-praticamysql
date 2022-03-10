package repository;

import java.util.List;

import model.Produto;

public interface ProdutoRepository {
    void inserir(Produto produto);

    List<Object[]> listarByCodigoCategoria(Integer codigoCategoria);

    List<Object[]> listarByCodigoCategoriaAndNomeProduto(Integer codigoCategoria, String nomeProduto);
}
