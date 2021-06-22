package org.licc.repository;

import org.licc.domain.User;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author licc
 * @date 2021/6/22
 */
public class CustomInsertImpl implements CustomInsert<User>{

    private final JdbcAggregateTemplate jdbcAggregateTemplate;

    public CustomInsertImpl(JdbcAggregateTemplate jdbcAggregateTemplate) {
        this.jdbcAggregateTemplate = jdbcAggregateTemplate;
    }

    @Override
    public void insert(User user) {
        jdbcAggregateTemplate.insert(user);
    }
}
