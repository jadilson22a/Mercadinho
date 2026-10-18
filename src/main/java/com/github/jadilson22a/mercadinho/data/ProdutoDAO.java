package com.github.jadilson22a.mercadinho.data;

import java.util.List;

import javax.swing.SwingUtilities;

import com.github.jadilson22a.mercadinho.entities.ProdutoInterface;
import com.github.jadilson22a.mercadinho.model.Produto;
import com.github.jadilson22a.mercadinho.view.ErroView;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public ProdutoDAO() {
		this.emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		this.em = emf.createEntityManager();
	}

	public void salvar(ProdutoInterface produto) {
		
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
				
		}
	}
	
	public ProdutoInterface findById(long id) {
		
		try {
			return (ProdutoInterface) em.find(Produto.class, id);
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
			return null;
				
		}
	}
	
	public void atualizar(long id, ProdutoInterface produto) {
		
		try {
			em.getTransaction().begin();
			ProdutoInterface produtoEncontrado = (ProdutoInterface) em.find(Produto.class, id);
			
			if(produtoEncontrado != null) {
				produtoEncontrado.setNome(produto.getNome());
				produtoEncontrado.setQuantidade(produto.getQuantidade());
				produtoEncontrado.setUm(produto.getUm());
			}
			
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
				
		}
	}
	
	public void excluir(long id) {

		try {
			em.getTransaction().begin();
			ProdutoInterface produtoEncontrado = (ProdutoInterface) em.find(Produto.class, id);
			
			if(produtoEncontrado != null) {
				em.remove(produtoEncontrado);
			}
			
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
				
		}
	}
	
	public List<ProdutoInterface> findAll() {
		
		try {
			return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList()
					.stream()
					.map(p -> (ProdutoInterface) p)
					.toList();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
			return null;
				
		}
	}
	
	public ProdutoInterface findByNome(String nome) {

		try {
			return em.createQuery(
					"select p from Produto p where p.nome= :nome", 
					Produto.class)
					.setParameter("nome", nome)
					.setMaxResults(1)
					.getSingleResultOrNull();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			SwingUtilities.invokeLater(() -> {new ErroView(e.getMessage());});
			return null;
			
		}
	}
	
	public void finalizarConexao() {
		em.close();
		emf.close();
	}

}
