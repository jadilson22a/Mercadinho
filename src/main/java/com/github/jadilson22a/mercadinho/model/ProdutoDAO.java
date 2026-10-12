package com.github.jadilson22a.mercadinho.model;

import java.util.List;

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

	public void salvar(Produto produto) {
		
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		}
	}
	
	public Produto findById(long id) {
		
		try {
			return em.find(Produto.class, id);
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		}
	}
	
	public void atualizar(long id, Produto produto) {
		
		try {
			em.getTransaction().begin();
			Produto produtoEncontrado = em.find(Produto.class, id);
			
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
			
			throw e;
				
		}
	}
	
	public void excluir(long id) {

		try {
			em.getTransaction().begin();
			Produto produtoEncontrado = em.find(Produto.class, id);
			
			if(produtoEncontrado != null) {
				em.remove(produtoEncontrado);
			}
			
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		}
	}
	
	public List<Produto> findAll() {
		
		try {
			return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		}
	}
	
	public Produto findByNome(String nome) {

		try {
			return em.createQuery(
					"select p from Produto p where nome='"+ nome + "'", 
					Produto.class).getSingleResultOrNull();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
			
		}
	}
	
	public void finalizarConexao() {
		em.close();
		emf.close();
	}

}
