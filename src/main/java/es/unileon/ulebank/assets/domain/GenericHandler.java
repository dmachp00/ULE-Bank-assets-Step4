package es.unileon.ulebank.assets.domain;

// Generated Jun 15, 2014 6:36:38 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import es.unileon.ulebank.handler.Handler;

/**
 * GenericHandler generated by hbm2java
 */
@Entity
@Table(name = "GENERIC_HANDLER", catalog = "ULEBANK_FINAL")
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("GenericHandler")
public class GenericHandler implements Handler {


    /**
     * Create a new Generic Handler
     *
     * @param id
     *            (The id)
     * @author runix
     */
    public GenericHandler() {

    }

    /**
     * Create a new Generic Handler
     *
     * @param id
     *            (The id)
     * @author runix
     */
    public GenericHandler(String id) {
        this.setId(id);
    }

	private void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Handler another) {
		// TODO Auto-generated method stub
		return 0;
	}

}
