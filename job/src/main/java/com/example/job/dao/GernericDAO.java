package com.example.job.dao;

import com.example.job.mapper.RowMapper;
import com.example.job.model.AreaModel;

import java.util.List;

public interface GernericDAO <T>{
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    Long Add(String sql, Object... parameters);
    void Update(String sql, Object... parameters);

    AreaModel GetAll(String sql, Object... parameters);
    void Delete(String sql, Object... parameters);
}
