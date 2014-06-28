package es.unileon.ulebank.assets.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AccountAuthorizedId implements Serializable {

    private String account;
    private String client;

    public AccountAuthorizedId() {
   
    }

    public AccountAuthorizedId(String account, String client) {
        this.client = client;
        this.account = account;
    }

    @Column(name = "account_number", nullable = false, length = 64)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "client_id", nullable = false, length = 64)
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

}
