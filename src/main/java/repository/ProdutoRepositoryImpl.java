package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Produto;

public class ProdutoRepositoryImpl implements ProdutoRepository {
    private EntityManager em;

    public ProdutoRepository setEntityManager(EntityManager em) {
        this.em = em;
        return this;
    }

    @Override
    public void inserir(Produto produto) {
        em.persist(produto);
    }

    @Override
    public List<Object[]> listarByCodigoCategoria(Integer codigoCategoria) {
        TypedQuery<Object[]> tp = em.createQuery(
                "SELECT p.codigo, p.nome, p.preco, c.nome FROM Produto p INNER JOIN Categoria c ON c.codigo =:categoriaId and p.categoria =:categoriaId",
                Object[].class);
        tp.setParameter("categoriaId", codigoCategoria);
        return tp.getResultList();
    }

    @Override
    public List<Object[]> listarByCodigoCategoriaAndNomeProduto(Integer codigoCategoria, String nomeProduto) {
        TypedQuery<Object[]> tp = em.createQuery(
                "SELECT p.codigo, p.nome, p.preco, c.nome FROM Produto p INNER JOIN Categoria c ON c.codigo =:categoriaId and p.categoria =:categoriaId and p.nome LIKE CONCAT('%',:nomeProduto, '%')",
                Object[].class);
        tp.setParameter("categoriaId", codigoCategoria);
        tp.setParameter("nomeProduto", nomeProduto);
        return tp.getResultList();
    }
}