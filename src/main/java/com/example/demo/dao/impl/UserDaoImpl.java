package com.example.demo.dao.impl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
 
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.config.variable.ApplicationConstant;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	private static final Logger LOG = LogManager.getLogger(UserDaoImpl.class);

	@Autowired
	@Qualifier(ApplicationConstant.BEAN_JDBC_USER)
	private JdbcTemplate jdbcTemplate;
	
    @Override
    public User getUserByUsername(String username) throws Exception {
        LOG.traceEntry();
		String query = "SELECT A.* FROM TBL_USERS A WHERE A.USERNAME = ? ";
		LOG.debug("SQL::{}", query);
		List < User > result = jdbcTemplate.query(query, new Object[] { username }, new UserMapper());
		LOG.debug("RESULT::{}", result);
		LOG.traceExit();
		return result.size() > 0 ? result.get(0) : null;
    }
    
	private class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int row) throws SQLException {
			User result = new User();
			result.setId(rs.getInt("ID"));
			result.setUsername(rs.getString("USERNAME"));
			result.setPassword(rs.getString("PASSWORD"));
			result.setFullname(rs.getString("FULLNAME"));
			result.setAddress(rs.getString("ADDRESS"));
			result.setEmail(rs.getString("EMAIL"));
			result.setPhoneNo(rs.getString("PHONE_NO"));
			result.setStatus(rs.getString("STATUS"));
			result.setLastActivity(rs.getDate("LAST_ACTIVITY"));	
			result.setCreatedDtm(rs.getTimestamp("CREATED_DTM"));
			result.setCreatedBy(rs.getString("CREATED_BY"));
			result.setUpdatedDtm(rs.getTimestamp("LASTUPD_DTM"));
			result.setUpdatedBy(rs.getString("LASTUPD_BY"));
			return result;
		}
	}

	@Override
	public boolean saveUser(User user) throws Exception {
		LOG.traceEntry();
		String query = "INSERT INTO TBL_USERS (USERNAME, PASSWORD, FULLNAME, ADDRESS, EMAIL, PHONE_NO, STATUS, CREATED_DTM, CREATED_BY) " +
		" VALUES ( ?,?,?,?,?,?,?,?,? )";
		LOG.debug("SQL::{}", query);
		int result = jdbcTemplate.update(query,
					new Object[] {user.getUsername(), user.getPassword(), user.getFullname(), 
							user.getAddress(), user.getEmail(), user.getPhoneNo(), user.getStatus(), 
							user.getCreatedDtm(), user.getCreatedBy()});
		LOG.debug("RESULT::{}", result);
		LOG.traceExit();
		return result == 0 ? false : true;
	}

}
