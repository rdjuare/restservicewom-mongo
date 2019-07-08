package domain.model.repository;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;import domain.model.entities.Order;

/**
 *
 * @author Luis Vergara
 */
@Singleton
@Startup
public class InMemOrderRepository implements OrderRepository<Order, String> {
	@PersistenceContext(unitName = "mongo-ogm")
	private EntityManager em;

	 @Inject
	    Logger logger;
	/**
	 * Initializep
	 * 
	 * @throws Exception
	 */
	public InMemOrderRepository() throws Exception {
	}

	@Override
	public boolean add(Order entity) {
		logger.info("Persisting Order" + entity.getId() + entity.getBeanOrigin());
		em.merge(entity);
		return true;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.falabella.login.domain.repository.Repository#remove(java.lang.Object)
	 */
	@Override
	public void remove(String id) {
		Query query = em.createQuery("FROM Order where id=:id");
		query.setParameter("id", id);
		Order order = (Order) query.getSingleResult();
		em.getTransaction().begin();
		em.remove(order);
		em.getTransaction().commit();

	}

	@Override
	public void update(Order order) {
	
		em.merge(order);
	
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Order> getAll(String id) throws Exception {
		
		Query query = em.createQuery("FROM Order");
	    List<Order> orders = query.getResultList();
	    return orders;

	}

	@Override
	public Order get(String id) throws Exception {
		Query query = em.createQuery("FROM Order where id=:id");
		query.setParameter("id", id);
		Order order = (Order) query.getSingleResult();
		return order;
	}
}
