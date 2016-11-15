package com.nju.data.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.nju.data.dataobject.PlanDO;

/**
 	* A data access object (DAO) providing persistence and search support for PlanDO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.nju.data.dataobject.PlanDO
  * @author MyEclipse Persistence Tools 
 */
public class PlanDODAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PlanDODAO.class);
		//property constants
	public static final String NAME = "name";



	protected void initDao() {
		//do nothing
	}
    
    public void save(PlanDO transientInstance) {
        log.debug("saving PlanDO instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PlanDO persistentInstance) {
        log.debug("deleting PlanDO instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PlanDO findById( java.lang.Integer id) {
        log.debug("getting PlanDO instance with id: " + id);
        try {
            PlanDO instance = (PlanDO) getHibernateTemplate()
                    .get("com.nju.data.dataobject.PlanDO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<PlanDO> findByExample(PlanDO instance) {
        log.debug("finding PlanDO instance by example");
        try {
            List<PlanDO> results = (List<PlanDO>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding PlanDO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PlanDO as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<PlanDO> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	

	public List findAll() {
		log.debug("finding all PlanDO instances");
		try {
			String queryString = "from PlanDO";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PlanDO merge(PlanDO detachedInstance) {
        log.debug("merging PlanDO instance");
        try {
            PlanDO result = (PlanDO) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PlanDO instance) {
        log.debug("attaching dirty PlanDO instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PlanDO instance) {
        log.debug("attaching clean PlanDO instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PlanDODAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PlanDODAO) ctx.getBean("PlanDODAO");
	}
}