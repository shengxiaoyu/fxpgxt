package com.nju.data.dao;
// default package

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.nju.data.dataobject.RiskFollowerDO;

/**
 	* A data access object (DAO) providing persistence and search support for RiskFollowerDO entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .RiskFollowerDO
  * @author MyEclipse Persistence Tools 
 */

public class RiskFollowerDODAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(RiskFollowerDODAO.class);
		//property constants
	public static final String _RID = "RId";
	public static final String _UID = "UId";
	public static final String POSSIBILITY = "possibility";
	public static final String INFLUENCE = "influence";
	public static final String GATE = "gate";
	public static final String RISK_FOLLOWERCOL = "riskFollowercol";
	public static final String DESCRIPTION = "description";



	protected void initDao() {
		//do nothing
	}
    public List<RiskFollowerDO> getRecognizedRisks(String begin ,String  end){
    	String hql = "from RiskFollowerDO where beginTime>#BEGIN# and beginTime<#END#" ;
    	hql.replaceAll("#BEGIN#", begin) ;
    	hql.replaceAll("#END#", end) ;
    	List<RiskFollowerDO> result = getHibernateTemplate().find(hql) ;
    	return result;
    }
    public List<RiskFollowerDO> getComeTrueRisks(String begin,String end){
    	String hql = "from RiskFollowerDO where endTime<>null and (endTime > #BEGIN# and endTime<#END#" ;
    	hql.replaceAll("#END#",end) ;
    	hql.replaceAll("#BEGIN#", begin) ;
    	List<RiskFollowerDO> result = getHibernateTemplate().find(hql) ;
    	return result;
    }
    public void save(RiskFollowerDO transientInstance) {
        log.debug("saving RiskFollowerDO instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(RiskFollowerDO persistentInstance) {
        log.debug("deleting RiskFollowerDO instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public RiskFollowerDO findById( java.lang.Integer id) {
        log.debug("getting RiskFollowerDO instance with id: " + id);
        try {
            RiskFollowerDO instance = (RiskFollowerDO) getHibernateTemplate()
                    .get("RiskFollowerDO", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<RiskFollowerDO> findByExample(RiskFollowerDO instance) {
        log.debug("finding RiskFollowerDO instance by example");
        try {
            List<RiskFollowerDO> results = (List<RiskFollowerDO>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding RiskFollowerDO instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from RiskFollowerDO as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<RiskFollowerDO> findByRId(Object RId
	) {
		return findByProperty(_RID, RId
		);
	}
	
	public List<RiskFollowerDO> findByUId(Object UId
	) {
		return findByProperty(_UID, UId
		);
	}
	
	public List<RiskFollowerDO> findByPossibility(Object possibility
	) {
		return findByProperty(POSSIBILITY, possibility
		);
	}
	
	public List<RiskFollowerDO> findByInfluence(Object influence
	) {
		return findByProperty(INFLUENCE, influence
		);
	}
	
	public List<RiskFollowerDO> findByGate(Object gate
	) {
		return findByProperty(GATE, gate
		);
	}
	
	public List<RiskFollowerDO> findByRiskFollowercol(Object riskFollowercol
	) {
		return findByProperty(RISK_FOLLOWERCOL, riskFollowercol
		);
	}
	
	public List<RiskFollowerDO> findByDescription(Object description
	) {
		return findByProperty(DESCRIPTION, description
		);
	}
	

	public List findAll() {
		log.debug("finding all RiskFollowerDO instances");
		try {
			String queryString = "from RiskFollowerDO";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public RiskFollowerDO merge(RiskFollowerDO detachedInstance) {
        log.debug("merging RiskFollowerDO instance");
        try {
            RiskFollowerDO result = (RiskFollowerDO) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(RiskFollowerDO instance) {
        log.debug("attaching dirty RiskFollowerDO instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(RiskFollowerDO instance) {
        log.debug("attaching clean RiskFollowerDO instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static RiskFollowerDODAO getFromApplicationContext(ApplicationContext ctx) {
    	return (RiskFollowerDODAO) ctx.getBean("RiskFollowerDODAO");
	}
}