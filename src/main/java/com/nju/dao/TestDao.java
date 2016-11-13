package com.nju.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 传旺 on 2016/6/2.
 */
@Repository
public class TestDao {

//    @Autowired
//    private SessionFactory sessionFactory;

    public List<Object> test(){
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createSQLQuery("SELECT * FROM book");
//        System.out.println(query.list().get(0));
//        return new ArrayList<Object>();
    	return null ;
    }
}
