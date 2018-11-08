package com.ways.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ways.user.dao.UserLoginDao;
@Repository("userLoginDao")
public class UserLoginDaoImpl implements UserLoginDao {
	@Autowired
	private SessionFactory sessionFactory ;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession() ;
	}
	@Override
	public Map getLoginInfo(Map map) {
		//LoginUser loginUser = sessionFactory.
		String sql = "select lu.user_id as user_id,lu.login_name as login_name from login_user lu where lu.login_name='"+map.get("username")+"' and lu.password='"+map.get("password")+"'" ;
		Map resultMap = (Map) this.getSession().createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).uniqueResult();
		return resultMap ;
	}
}
