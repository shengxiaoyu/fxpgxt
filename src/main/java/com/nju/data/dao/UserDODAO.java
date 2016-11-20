package com.nju.data.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nju.data.dataobject.UserDO;

/**
 	* A data access object (DAO) providing persistence and search support for UserDO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.nju.data.dataobject.UserDO
  * @author MyEclipse Persistence Tools 
 */

public class UserDODAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(UserDODAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String PASSWORD = "password";



	protected void initDao() {
		//do nothing
	}
    
    public void save(UserDO transientInstance) {
        log.debug("saving UserDO instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(UserDO persistentInstance) {
        log.debug("deleting UserDO instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public UserDO findById( java.lang.Integer id) {
        log.debug("getting UserDO instance with id: " + id);
        try {
            UserDO instance = (UserDO) getHibernateTemplate()
                    .get("com.nju.data.dataobject.UserDO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<UserDO> findByExample(UserDO instance) {
        log.debug("finding UserDO instance by example");
        try {
            List<UserDO> results = (List<UserDO>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding UserDO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from UserDO as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<UserDO> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<UserDO> findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	

	public List findAll() {
		log.debug("finding all UserDO instances");
		try {
			String queryString = "from UserDO";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public UserDO merge(UserDO detachedInstance) {
        log.debug("merging UserDO instance");
        try {
            UserDO result = (UserDO) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(UserDO instance) {
        log.debug("attaching dirty UserDO instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(UserDO instance) {
        log.debug("attaching clean UserDO instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    public int getMaxId(){
		if (logger.isDebugEnabled()) {
			logger.debug("get maxID");
		}
		String hql = "select max(id) from UserDO";
		Session s = this.getSession();
		Query query = s.createQuery(hql);
		Integer maxBh = 0;
		if (query.uniqueResult() != null)
			maxBh = (Integer) query.uniqueResult();
		// 释放数据库连接！！！
		this.releaseSession(s);
		if (logger.isDebugEnabled()) {
			logger.debug("get maxID");
		}
		return maxBh+1;
	
	}
	public static UserDODAO getFromApplicationContext(ApplicationContext ctx) {
    	return (UserDODAO) ctx.getBean("UserDODAO");
	}
}