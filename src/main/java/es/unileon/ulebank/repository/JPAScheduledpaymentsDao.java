package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;

@Repository(value = "scheduledPaymentsDao")
public class JPAScheduledpaymentsDao implements ScheduledpaymentsDao {

    private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    @Override
    public List<ScheduledPayment> getScheduledpayments(String id_loan) {
        // TODO Auto-generated method stub
        return em.createQuery(
                "select p from ScheduledPayment p where loanID = '" + id_loan
                        + "'order by p.scheduledPayementID").getResultList();
    }

    @Override
    public void persist(ScheduledPayment transientInstance) {
        // TODO Auto-generated method stub
        em.persist(transientInstance);
    }

    @Override
    public void remove(ScheduledPayment persistentInstance) {
        // TODO Auto-generated method stub
        em.remove(persistentInstance);

    }

    @Override
    public ScheduledPayment merge(ScheduledPayment detachedInstance) {
        // TODO Auto-generated method stub
        // Que se supone que hace el merge
        return null;
    }

    @Override
    public ScheduledPayment findById(String id) {
        // TODO Auto-generated method stub
        return (ScheduledPayment) em.createQuery(
                "select p from Scheduledpayments where scheduledPaymentId = '"
                        + id + "'").getResultList();

    }

}
