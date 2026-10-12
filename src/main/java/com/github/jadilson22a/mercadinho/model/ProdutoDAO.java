package com.github.jadilson22a.mercadinho.model;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDAO {
	
	public static void salvar(Produto produto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(produto);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static Produto findById(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.find(Produto.class, id);
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void atualizar(long id, Produto produto) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
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
				
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static void excluir(long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
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
				
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static List<Produto> findAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
				
		} finally {
			em.close();
			emf.close();
		}
	}
	
	public static Produto findByNome(String nome) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mercadinhoPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			return em.createQuery(
					"select p from Produto p where nome='"+ nome + "'", 
					Produto.class).getSingleResultOrNull();
		} catch (RuntimeException e) {
			
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			
			throw e;
			
		} finally {
			em.close();
			emf.close();
		}
	}

}
