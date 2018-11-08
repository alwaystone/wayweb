package com.ways.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ways.user.dao.UserDao;
import com.ways.user.entity.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sessionFactory ;
	@Autowired
    private MongoTemplate mongoTemplate;
 
    @Override
    public List<Map> findAll() {
        return this.mongoTemplate.findAll(Map.class, "banner") ;
    }
	private Session getSession(){
		return sessionFactory.getCurrentSession() ;
	}
	public void insertUser(User user) {
		this.getSession().save(user) ;
		//this.getSession().createQuery("from User").list();
		//this.getSession().flush(); 
		//JSONArray arr = new JSONArray() ;
		//JSONArray arr = JSONArray.fromObject(this.getSession().createSQLQuery("select * from user")) ;
		//System.out.println(arr.toString());
		//List<User> list = (List<User>) this.getSession().createSQLQuery("select * from user") ;
		//String createTimeStr =  DateFormatUtils.format(list.get(0).getCreateTime(), "yyyy-MM-dd HH:mm:ss") ;
		//System.out.println(createTimeStr);
	}
	public List<User> getUserList(Map param) {
		//List<User> list = this.getSession().createSQLQuery("select * from user where id = ?").addEntity(User.class).setParameter(0, "402895075d788dae015d788dd82a0000").list() ;
		List list = this.getSession().createQuery("from User").list() ;
		
		//this.getSession().
		return list ;
		//return list;
	}
	public User getUserById(String id) {
		return (User) this.getSession().createQuery("from User where id=:id").setString("id", id).list().get(0) ;
		//return (User) this.getSession().createSQLQuery("select * from user where id = ?").addEntity(User.class).setParameter(0, "402895075d788dae015d788dd82a0000").list().get(0);
	}
	
	@Override
	public List getUserRoleResources(Map map) {
		String sql ="SELECT m.menu_id,m.menu_name, m.level, m.url,m.parent_id FROM role_menu r LEFT JOIN menu m ON r.menu_id = m.menu_id WHERE r.role_id = 'role1' UNION "+
					"SELECT um.menu_id,um.menu_name, um.level, um.url,um.parent_id FROM user_menu u LEFT JOIN menu um ON u.menu_id = um.menu_id WHERE u.user_id = '"+map.get("user_id")+"'" ;
		List list = this.getSession().createSQLQuery(sql).setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP).list();
		return list;
	}
	@Override
	public int insertMenus(List list) {
		// TODO Auto-generated method stub
		List ids = new ArrayList() ;
		ids.add("menu2") ;
		ids.add("menu1") ;
		//this.getSession().createSQLQuery("insert into menutemp (menu_id) values ('111')").executeUpdate() ;
		
		/*this.getSession().createSQLQuery("insert into menuTemp(menu_id,module,premissionId,label,param) values(:menu_id,:module,:premissionId,:label,:param)")
			.setParameter("menu_id", "qwerqwerqw")
			.setParameter("module", "rett")
			.setParameter("premissionId", "tttt")
			.setParameter("label", "eeee")
			.setParameter("param", "yyyyyyy")
			.executeUpdate();*/
		
		/*List reslist = this.getSession().createSQLQuery("select * from menu where parent_id in :parentid")
			.setParameterList("parentid", ids).list() ;
		System.out.println(reslist);*/
		
		/*Transaction tx = this.getSession().beginTransaction();
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(i) ;
			this.getSession().createSQLQuery("insert into menutemp (menu_id,module,premissionId,label,params,parent_id,sort_id) values (:menu_id,:module,:premissionId,:label,:params,:parent_id,:sort_id)")
				.setParameter("menu_id", map.get("uuid"))
				.setParameter("module", map.get("module"))
				.setParameter("premissionId", map.get("premissionId"))
				.setParameter("label", map.get("label"))
				.setParameter("params", map.get("params"))
				.setParameter("parent_id", map.get("parentId"))
				.setParameter("sort_id", map.get("sortId"))
				.executeUpdate() ;
		}*/
		
		//Transaction tx = this.getSession().beginTransaction();
		this.getSession().doWork(new Work(){
			
			@Override
			public void execute(Connection arg0) throws SQLException {//需要注意的是，不需要调用close()方法关闭这个连接
				//通过JDBC API执行用于批量插入的sql语句
				String sql = "insert into menutemp (menu_id,module,premissionId,label,params,parent_id,sort_id) values (?,?,?,?,?,?,?)";
				PreparedStatement ps = arg0.prepareStatement(sql);
				for(int i=0;i<list.size();i++){
					Map map = (Map) list.get(i) ;
					ps.setObject(1, map.get("uuid")!=null?map.get("uuid"):null);
					ps.setObject(2, map.get("module")!=null?map.get("module"):null);
					ps.setObject(3, map.get("premissionId")!=null?map.get("premissionId"):null);
					ps.setObject(4, map.get("label")!=null?map.get("label"):null);
					ps.setObject(5, map.get("params")!=null?map.get("params"):null);
					ps.setObject(6, map.get("parentId")!=null?map.get("parentId"):null);
					ps.setObject(7, map.get("sortId")!=null?map.get("sortId"):null);
					ps.addBatch();
				}
				ps.executeBatch();
			}
		});
		//tx.commit();
		return 0;
	}

}
