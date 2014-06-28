package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.domain.Loans;
import es.unileon.ulebank.client.Client;

public interface LoansDao {

    public void persist(Loans transientInstance);

    public void remove(Loans persistentInstance);

    public Loans merge(Loans detachedInstance);

    public Loans findById(String id);

    public Client getLoanClient(String dni);

    public Account getLoanAccount(String accountNumber);
    
    public List<Loans> getLoanList();

    public void saveLoan(Loan loan);

    public Loan findLoan(String loanId);

    public void addLoan(Loan loan);
    
}
