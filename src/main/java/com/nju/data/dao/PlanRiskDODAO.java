package com.nju.data.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nju.data.dataobject.PlanRiskDO;

/**
 	* A data access object (DAO) providing persistence and search support for PlanRiskDO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.nju.data.dataobject.PlanRiskDO
  * @author MyEclipse Persistence Tools 
 */

public class PlanRiskDODAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(PlanRiskDODAO.class);
		//property constants
	public static final String _PID = "PId";
	public static final String _RID = "RId";



	protected void initDao() {
		//do nothing
	}
    public int getMaxId(){

		if (logger.isDebugEnabled()) {
			logger.debug("开始：从数据库中获取最大xh");
		}
		String hql = "select max(id) from PlanRiskDO";
		Session s = this.getSession();
		Query query = s.createQuery(hql);
		Integer maxBh = 0;
		if (query.uniqueResult() != null)
			maxBh = (Integer) query.uniqueResult();
		// 释放数据库连接！！！
		this.releaseSession(s);
		if (logger.isDebugEnabled()) {
			logger.debug("结束：从数据库中获取最大xh");
		}
		return maxBh+1;
	
	
    }
    public void save(PlanRiskDO transientInstance) {
        log.debug("saving PlanRiskDO instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(PlanRiskDO persistentInstance) {
        log.debug("deleting PlanRiskDO instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public PlanRiskDO findById( java.lang.Integer id) {
        log.debug("getting PlanRiskDO instance with id: " + id);
        try {
            PlanRiskDO instance = (PlanRiskDO) getHibernateTemplate()
                    .get("com.nju.data.dataobject.PlanRiskDO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<PlanRiskDO> findByExample(PlanRiskDO instance) {
        log.debug("finding PlanRiskDO instance by example");
        try {
            List<PlanRiskDO> results = (List<PlanRiskDO>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding PlanRiskDO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from PlanRiskDO as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<PlanRiskDO> findByPId(Object PId
	) {
		return findByProperty(_PID, PId
		);
	}
	
	public List<PlanRiskDO> findByRId(Object RId
	) {
		return findByProperty(_RID, RId
		);
	}
	

	public List findAll() {
		log.debug("finding all PlanRiskDO instances");
		try {
			String queryString = "from PlanRiskDO";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public PlanRiskDO merge(PlanRiskDO detachedInstance) {
        log.debug("merging PlanRiskDO instance");
        try {
            PlanRiskDO result = (PlanRiskDO) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(PlanRiskDO instance) {
        log.debug("attaching dirty PlanRiskDO instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(PlanRiskDO instance) {
        log.debug("attaching clean PlanRiskDO instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static PlanRiskDODAO getFromApplicationContext(ApplicationContext ctx) {
    	return (PlanRiskDODAO) ctx.getBean("PlanRiskDODAO");
	}
}