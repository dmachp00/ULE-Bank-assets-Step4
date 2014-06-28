package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;

public interface ScheduledpaymentsDao {

    public List<ScheduledPayment> getScheduledpayments(String id_loan);

    public void persist(ScheduledPayment transientInstance);

    public void remove(ScheduledPayment persistentInstance);

    public ScheduledPayment merge(ScheduledPayment detachedInstance);

    public ScheduledPayment findById(String id);

}
