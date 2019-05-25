package br.edu.uepb.controleAcademico.util;


import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence_CA");

	 @Produces @RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	 
	 public void finaliza(@Disposes EntityManager manager) {
	      manager.close();
	   }
}