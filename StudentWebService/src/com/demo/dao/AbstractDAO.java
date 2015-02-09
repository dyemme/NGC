package com.demo.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 * Class defining and implementing the base set of common database operations.
 */
public abstract class AbstractDAO<T> {

	/** Class scope logging instance. */
	@SuppressWarnings("unused")
	private final static Logger logger = Logger.getLogger(AbstractDAO.class);

	/** Class representing a domain object. */
	protected Class<T> cls;

	/** Reference to an instance of the SessionFactory object. */
	@Autowired
	protected SessionFactory sessionFactory;

	/** local session factory bean used for getting hibernate configuration */
	@Autowired
	@Qualifier("sessionFactory")
	private LocalSessionFactoryBean lsfb;

	/** tells the dao if it is in a test mode */
	protected boolean testMode;

	/**
	 * Default constructor.
	 *
	 * @param cls - a class representing a domain object
	 */
	public AbstractDAO(final Class<T> cls) {
		super();
		this.cls = cls;
	}
	
	/**
	 * Constructor requiring a SessionFactory.
	 *
	 * @param cls - a class representing a domain object
	 * @param sessionFactory - an instance of the SessionFactory
	 */
	public AbstractDAO(final Class<T> cls, final SessionFactory sessionFactory) {
		super();
		this.cls = cls;
		this.sessionFactory = sessionFactory;
	}
	/**
	 * Deletes the given object.
	 *
	 * @param obj - the object to persist
	 */
	public void delete(T obj) {
		Session s = this.currentSession();
		s.delete(obj);
		s.flush();
		s.evict(obj);
	}

	/**
	 * This method deletes a record by its ID.
	 *
	 * @param id id of the record
	 */
	public void deleteById(final Long id) {
		T obj = this.load(id);
		this.delete(obj);
	}
	/**
	 * Loads and returns the object identified by the given ID.
	 *
	 * @param id - the primary key of the desired object
	 * @return T - the domain object identified by the given ID
	 */
	@SuppressWarnings("unchecked")
	public T load(final String id) {
		return id != null ? (T)this.currentSession().load(this.cls, id) : null;
	}
	/**
	 * Loads and returns the object identified by the given ID.
	 *
	 * @param id - the primary key of the desired object
	 * @return T - the domain object identified by the given ID
	 */
	@SuppressWarnings("unchecked")
	public T load(final Long id) {
		return id != null ? (T)this.currentSession().load(this.cls, id) : null;
	}
	/**
	 * Returns the current session from the session factory.
	 *
	 * @return a Session object representing the current session
	 */
	public Session currentSession() {
		return this.sessionFactory.getCurrentSession();
	}


}
