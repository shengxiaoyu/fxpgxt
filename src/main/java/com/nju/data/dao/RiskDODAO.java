package com.nju.data.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nju.data.dataobject.RiskDO;

/**
 	* A data access object (DAO) providing persistence and search support for RiskDO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.nju.data.dataobject.RiskDO
  * @author MyEclipse Persistence Tools 
 */

public class RiskDODAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RiskDODAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String CONTENT = "content";
	public static final String CREATOR = "creator";



	protected void initDao() {
		//do nothing
	}
    
    public void save(RiskDO transientInstance) {
        log.debug("saving RiskDO instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    public int getMaxId(){

		if (logger.isDebugEnabled()) {
			logger.debug("get maxID");
		}
		String hql = "select max(id) from RiskDO";
		Session s = this.getSession();
		Query query = s.createQuery(hql);
		Integer maxBh = 0;
		if (query.uniqueResult() != null)
			maxBh = (Integer) query.uniqueResult();
		s.close() ;
		if (logger.isDebugEnabled()) {
			logger.debug("get maxID");
		}
		return maxBh+1;
	
	
    }
	public void delete(RiskDO persistentInstance) {
        log.debug("deleting RiskDO instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RiskDO findById( java.lang.Integer id) {
        log.debug("getting RiskDO instance with id: " + id);
        try {
            RiskDO instance = (RiskDO) getHibernateTemplate()
                    .get("com.nju.data.dataobject.RiskDO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<RiskDO> findByExample(RiskDO instance) {
        log.debug("finding RiskDO instance by example");
        try {
            List<RiskDO> results = (List<RiskDO>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding RiskDO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RiskDO as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<RiskDO> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<RiskDO> findByContent(Object content
	) {
		return findByProperty(CONTENT, content
		);
	}
	
	public List<RiskDO> findByCreator(Object creator
	) {
		return findByProperty(CREATOR, creator
		);
	}
	

	public List findAll() {
		log.debug("finding all RiskDO instances");
		try {
			String queryString = "from RiskDO";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RiskDO merge(RiskDO detachedInstance) {
        log.debug("merging RiskDO instance");
        try {
            RiskDO result = (RiskDO) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RiskDO instance) {
        log.debug("attaching dirty RiskDO instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RiskDO instance) {
        log.debug("attaching clean RiskDO instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RiskDODAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RiskDODAO) ctx.getBean("RiskDODAO");
	}
}