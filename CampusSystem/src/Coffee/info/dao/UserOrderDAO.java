package Coffee.info.dao;

import java.sql.Timestamp;
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
 * A data access object (DAO) providing persistence and search support for
 * UserOrder entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Coffee.info.dao.UserOrder
 * @author MyEclipse Persistence Tools
 */

public class UserOrderDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserOrderDAO.class);
	// property constants
	public static final String USERID = "userid";
	public static final String ORDER_BUSINESS = "orderBusiness";
	public static final String ORDER_STATE = "orderState";

	protected void initDao() {
		// do nothing
	}

	public void save(UserOrder transientInstance) {
		log.debug("saving UserOrder instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserOrder persistentInstance) {
		log.debug("deleting UserOrder instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserOrder findById(java.lang.Integer id) {
		log.debug("getting UserOrder instance with id: " + id);
		try {
			UserOrder instance = (UserOrder) getHibernateTemplate().get(
					"Coffee.info.dao.UserOrder", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserOrder instance) {
		log.debug("finding UserOrder instance by example");
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
		log.debug("finding UserOrder instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserOrder as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserid(Object userid) {
		return findByProperty(USERID, userid);
	}

	public List findByOrderBusiness(Object orderBusiness) {
		return findByProperty(ORDER_BUSINESS, orderBusiness);
	}

	public List findByOrderState(Object orderState) {
		return findByProperty(ORDER_STATE, orderState);
	}

	public List findAll() {
		log.debug("finding all UserOrder instances");
		try {
			String queryString = "from UserOrder";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserOrder merge(UserOrder detachedInstance) {
		log.debug("merging UserOrder instance");
		try {
			UserOrder result = (UserOrder) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserOrder instance) {
		log.debug("attaching dirty UserOrder instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserOrder instance) {
		log.debug("attaching clean UserOrder instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public boolean getUserorder(Integer userid, String business){
		Session session = null;
		Transaction tx = null;
		String hql = "select count(*) from UserOrder u where u.userid in ("+ userid +") and u.orderBusiness in ('"+ business +"')";
		long rows = 0;
		try{
			 session = this.getSession();
			 tx = session.beginTransaction();
			 Query query = session.createQuery(hql);
			 rows = (Long)query.uniqueResult();
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
		if (rows > 0 && rows < 2) {
			return true;
		}else{
			return false;
		}
			
	}
	public int doUpdateState(Integer userid, String business,Integer state){
		Session session = null;
		Transaction tx = null;
		String hql = "update UserOrder u set u.orderState = "+ state +" where u.userid in ("+ userid +") and u.orderBusiness in ('"+ business +"')";
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
	public static UserOrderDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UserOrderDAO) ctx.getBean("UserOrderDAO");
	}
}