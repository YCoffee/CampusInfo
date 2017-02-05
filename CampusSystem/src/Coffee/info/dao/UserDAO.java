package Coffee.info.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see Coffee.info.dao.User
 * @author MyEclipse Persistence Tools
 */

public class UserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(UserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String ROLE = "role";

	protected void initDao() {
		// do nothing
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(
					"Coffee.info.dao.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public int userDelete(String userIds){
			Session session = null;
			Transaction tx = null;
			String hql = "delete from User u where u.id in("+ userIds +")";
			int rows = 0;
			try{
				 session = this.getSession();
				 tx = session.beginTransaction();
				 Query query = session.createQuery(hql);
				 rows = query.executeUpdate();
				 tx.commit();
			}catch(Exception e){
				e.printStackTrace();
				tx.rollback();
			}
			finally{
				if (session != null && session.isOpen()) {
					session.close();
				}
			}	
		return rows;
	}
	public List<User> findRelationForMyID(int myid){
		List<User> list = new ArrayList<User>();
		Session session = null;
		Transaction tx = null;
		String hql = "select u from User u where u.id !=" + myid;
			try {
				session = this.getSession();
				tx = session.beginTransaction();
				Query query = session.createQuery(hql);
				list = query.list();
				tx.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
			} finally{
				if (session.isOpen() && session != null) {
					session.close();
					}
			}
			return list;
}	
	public List<User> findByname(String username){
		List<User> list = new ArrayList<User>();
		Session session = null;
		Transaction tx = null;
		String hql = "select u from User u where u.username = '"+ username +"'";
			try {
				session = this.getSession();
				tx = session.beginTransaction();
				Query query = session.createQuery(hql);
				list = query.list();
				tx.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tx.rollback();
			} finally{
				if (session.isOpen() && session != null) {
					session.close();
					}
			}
			return list;
}	
	
	public static UserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserDAO) ctx.getBean("UserDAO");
	}
}