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
 * A data access object (DAO) providing persistence and search support for
 * UserRelation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Coffee.info.dao.UserRelation
 * @author MyEclipse Persistence Tools
 */

public class UserRelationDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserRelationDAO.class);
	// property constants
	public static final String MY_ID = "myId";
	public static final String OTHER_ID = "otherId";
	public static final String RELATEION = "relateion";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(UserRelation transientInstance) {
		log.debug("saving UserRelation instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserRelation persistentInstance) {
		log.debug("deleting UserRelation instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserRelation findById(java.lang.Integer id) {
		log.debug("getting UserRelation instance with id: " + id);
		try {
			UserRelation instance = (UserRelation) getHibernateTemplate().get(
					"Coffee.info.dao.UserRelation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserRelation instance) {
		log.debug("finding UserRelation instance by example");
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
		log.debug("finding UserRelation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserRelation as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMyId(Object myId) {
		return findByProperty(MY_ID, myId);
	}

	public List findByOtherId(Object otherId) {
		return findByProperty(OTHER_ID, otherId);
	}

	public List findByRelateion(Object relateion) {
		return findByProperty(RELATEION, relateion);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all UserRelation instances");
		try {
			String queryString = "from UserRelation";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserRelation merge(UserRelation detachedInstance) {
		log.debug("merging UserRelation instance");
		try {
			UserRelation result = (UserRelation) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserRelation instance) {
		log.debug("attaching dirty UserRelation instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserRelation instance) {
		log.debug("attaching clean UserRelation instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List findRelationByMyId(Integer myId) {
		List list = new ArrayList();
		Session session = null;
		Transaction tx = null;
		String hql = "select ur.otherId,ur.relateion,ur.state,u.username " +
				"from UserRelation ur, User u where ur.otherId = u.id and ur.myId = " + myId + "and ur.state = 0";
		try {
			session = this.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			list = query.list();	//更新，修改，删除用executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			if (session.isOpen() && session != null) {
				session.close();
			}
		}
		return list;
	}
	public int removeRelation(String myId,String otherids) {
		
		int rows = -1;
		Session session = null;
		Transaction tx = null;
		String hql = "update UserRelation ur set ur.state = 1 where ur.otherId in (" + otherids + ") and ur.myId = " + myId;
		try {
			session = this.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			rows = query.executeUpdate();	//更新，修改，删除用executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally{
			if (session.isOpen() && session != null) {
				session.close();
			}
		}
		return rows;
	}
	public static UserRelationDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserRelationDAO) ctx.getBean("UserRelationDAO");
	}
}