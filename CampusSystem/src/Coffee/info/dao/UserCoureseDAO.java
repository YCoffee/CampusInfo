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
 * UserCourese entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see Coffee.info.dao.UserCourese
 * @author MyEclipse Persistence Tools
 */

public class UserCoureseDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(UserCoureseDAO.class);
	// property constants
	public static final String USERID = "userid";
	public static final String COURSE = "course";
	public static final String CREDIT = "credit";
	public static final String STATE = "state";

	protected void initDao() {
		// do nothing
	}

	public void save(UserCourese transientInstance) {
		log.debug("saving UserCourese instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserCourese persistentInstance) {
		log.debug("deleting UserCourese instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserCourese findById(java.lang.Integer id) {
		log.debug("getting UserCourese instance with id: " + id);
		try {
			UserCourese instance = (UserCourese) getHibernateTemplate().get(
					"Coffee.info.dao.UserCourese", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserCourese instance) {
		log.debug("finding UserCourese instance by example");
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
		log.debug("finding UserCourese instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserCourese as model where model."
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

	public List findByCourse(Object course) {
		return findByProperty(COURSE, course);
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all UserCourese instances");
		try {
			String queryString = "from UserCourese";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserCourese merge(UserCourese detachedInstance) {
		log.debug("merging UserCourese instance");
		try {
			UserCourese result = (UserCourese) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserCourese instance) {
		log.debug("attaching dirty UserCourese instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserCourese instance) {
		log.debug("attaching clean UserCourese instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public boolean getUsercoures(Integer userid, String course){
		Session session = null;
		Transaction tx = null;
		String hql = "select count(*) from UserCourese u where u.userid in ("+ userid +") and u.course in ('"+ course +"')";
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

	public List getCourse(){
		Session session = null;
		Transaction tx = null;
		String hql = "select uc.id, uc.userid, u.username, uc.course, uc.credit, uc.state from UserCourese uc,User u where uc.userid=u.id order by uc.course";
		List courseList = new ArrayList();
		try{
			 session = this.getSession();
			 tx = session.beginTransaction();
			 Query query = session.createQuery(hql);
			 courseList = query.list();
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
		return courseList;
			
	}
	public int updateState(String userid, String course, Short state){
		Session session = null;
		Transaction tx = null;
		String hql = "update UserCourese set state = "+ state +" where course in ('"+ course +"') and userid in ("+ userid +")";
		//System.out.println(hql);
		int s = 0;
		try{
			 session = this.getSession();
			 tx = session.beginTransaction();
			 Query query = session.createQuery(hql);
			 s = query.executeUpdate();
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
		return s;
		
	}
	public static UserCoureseDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (UserCoureseDAO) ctx.getBean("UserCoureseDAO");
	}
}