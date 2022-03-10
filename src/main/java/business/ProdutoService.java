package business;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.Produto;
import repository.ProdutoRepository;
import repository.RepositorySession;

@Stateless
public class ProdutoService {
    @EJB
    private RepositorySession repository;
    private ProdutoRepository produtoRepository;

    @PostConstruct
    public void initialize() {
        produtoRepository = repository.getProdutoRepository();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void inserir(Produto produto) {
        produtoRepository.inserir(produto);
    }

    public List<Produto> listarByCodigoCategoria(Integer codigoCategoria) {
        List<Object[]> products = produtoRepository.listarByCodigoCategoria(codigoCategoria);
        return getProducts(products);
    }

    public List<Produto> listarByCodigoCategoriaAndNomeProduto(Integer codigoCategoria, String nomeProduto) {
        List<Object[]> products = produtoRepository.listarByCodigoCategoriaAndNomeProduto(codigoCategoria, nomeProduto);
        return getProducts(products);
    }

    private List<Produto> getProducts(List<Object[]> products) {
        List<Produto> produtos = new ArrayList<>();
        for (Object[] obj : products) {
            Produto produto = new Produto();
            produto.setCodigo((int) obj[0]);
            produto.setNome((String) obj[1]);
            produto.setPreco((Double) obj[2]);
            produtos.add(produto);
        }
        return produtos;
    }
}
