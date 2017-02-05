package Coffee.info.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserCertificate entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Coffee.info.dao.UserCertificate
 * @author MyEclipse Persistence Tools
 */

public class UserCertificateDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserCertificateDAO.class);
	// property constants
	public static final String USERID = "userid";
	public static final String CETIFICATE = "cetificate";
	public static final String LEVEL = "level";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(UserCertificate transientInstance) {
		log.debug("saving UserCertificate instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserCertificate persistentInstance) {
		log.debug("deleting UserCertificate instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserCertificate findById(java.lang.Integer id) {
		log.debug("getting UserCertificate instance with id: " + id);
		try {
			UserCertificate instance = (UserCertificate) getHibernateTemplate()
					.get("Coffee.info.dao.UserCertificate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserCertificate instance) {
		log.debug("finding UserCertificate instance by example");
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
		log.debug("finding UserCertificate instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from UserCertificate as model where model."
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

	public List findByCetificate(Object cetificate) {
		return findByProperty(CETIFICATE, cetificate);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all UserCertificate instances");
		try {
			String queryString = "from UserCertificate";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserCertificate merge(UserCertificate detachedInstance) {
		log.debug("merging UserCertificate instance");
		try {
			UserCertificate result = (UserCertificate) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserCertificate instance) {
		log.debug("attaching dirty UserCertificate instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserCertificate instance) {
		log.debug("attaching clean UserCertificate instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UserCertificateDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserCertificateDAO) ctx.getBean("UserCertificateDAO");
	}
}