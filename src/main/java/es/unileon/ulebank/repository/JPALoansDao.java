package es.unileon.ulebank.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.domain.Loans;
import es.unileon.ulebank.client.Client;

/**
 * Home object for domain model class Loans.
 * @see es.unileon.ulebank.domain.Loans
 * @author Hibernate Tools
 */
@Stateless
@Repository(value  ="loanDao")
public class JPALoansDao implements LoansDao {

	private static final Log log = LogFactory.getLog(JPALoansDao.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = false)
	public void persist(Loans transientInstance) {
		log.debug("persisting Loans instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Loans persistentInstance) {
		log.debug("removing Loans instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = false)
	public Loans merge(Loans detachedInstance) {
		log.debug("merging Loans instance");
		try {
			Loans result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Loans findById(String id) {
		log.debug("getting Loans instance with id: " + id);
		try {
			Loans instance = entityManager.find(Loans.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}


    @Override
    public Client getLoanClient(String dni) {
        Query query = entityManager.createQuery("select c from Loans where client_id=" + dni);
        @SuppressWarnings("unchecked")
        Client result = (Client) query.getSingleResult();
        return result;
    }

    @Override
    public Account getLoanAccount(String accountNumber) {
        Query query = entityManager.createQuery("select c from Loans where account_number=" + accountNumber);
        @SuppressWarnings("unchecked")
        Account result = (Account) query.getSingleResult();
        return result;
    }

	@Override
	public List<Loans> getLoanList() {
		Query query =  entityManager.createQuery("select c from Loans c order by c.id");
	    @SuppressWarnings("unchecked")
	    List<Loans> result = query.getResultList();
	    return result;
        
	}

	@Override
	public void saveLoan(Loan loan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Loan findLoan(String loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLoan(Loan loan) {
		// TODO Auto-generated method stub
		
	}
}
