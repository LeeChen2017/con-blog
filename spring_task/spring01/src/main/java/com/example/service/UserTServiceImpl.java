package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User
 */
@Service
public class UserTServiceImpl implements UserTService {

    private JdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUserByRole(Long id, Integer role) {
        int update = jdbcTemplate.update("update xxl_job_user set role = " + role + " where id = " + id);
    }
}
