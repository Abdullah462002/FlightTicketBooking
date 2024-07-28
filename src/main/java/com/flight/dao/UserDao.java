package com.flight.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.flight.bean.User;
import com.flight.constants.QueryConstants;


@Repository
public class UserDao {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemp;
	
	public User getUser(User us) throws InvalidUserException {
		try {
		String sql =QueryConstants.LOGIN;
		var pass=jdbcTemp.query(sql, new MapSqlParameterSource("name",us.getName()),
				(rs,r)->rs.getString(1));
		return new User(us.getName(),pass.get(0));
		}catch (Exception e) {
			throw new InvalidUserException("Invalid Username ");
		}
	}

}
