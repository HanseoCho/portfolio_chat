package com.java.DAO;

import java.io.Console;
import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.java.Controller.HomeController;

@Repository
public class Dao implements DaoInterface {
	@Resource(name="sqlSession")
	SqlSession session;	
	private static final Logger logger = LoggerFactory.getLogger(Dao.class);
		@Override
		public Object call(HashMap<String, Object> param) {
			String sql = param.get("sql").toString();
			String sqltype = param.get("sqlType").toString();
			
			if("selectOne".equals(sql)) {
				return session.selectOne(sqltype,param);
			}
			else if("insert".equals(sql)) {
				return session.insert(sqltype,param);
			}
			else if("update".equals(sql)) {
				return session.update(sqltype,param);
			}
			else if("selectList".equals(sql)) {
				return session.selectList(sqltype,param);
			}else {			
				logger.error("sql조건절 추가하자 sql : " + sql);
			}
			
			return null;
		}

}
