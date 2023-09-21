package com.example.job.dao;

import com.example.job.mapper.AreaMapper;
import com.example.job.mapper.RowMapper;
import com.example.job.model.AbstractModel;
import com.example.job.model.AreaModel;

import java.util.List;

public class AreaDAO extends AbstractDAO<AreaModel> implements IAreaDAO{
    @Override
    public AreaModel findOne(Long locationID) {
        String sql = "SELECT * FROM area WHERE id = ?";
        List<AreaModel> area = query(sql, new AreaMapper(), locationID);
        return area.isEmpty() ? null : area.get(0);
    }

    @Override
    public List<AreaModel> findAll() {
        String sql = "SELECT * FROM area";
        return query(sql, new AreaMapper());
    }


    @Override
    public Long save(AreaModel areaModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO area(locationName, createdDate, createdBy)");
        sql.append(" VALUES(?,?,?)");
        return Add(
                sql.toString(),
                areaModel.getLocationName(),
                areaModel.getCreatedDate(),
                areaModel.getCreatedBy());
    }

    @Override
    public void update(Long locationID, AreaModel areaModel) {
        StringBuilder sql = new StringBuilder("UPDATE area SET locationName = ? WHERE id = ?");
        Update(sql.toString(), areaModel.getLocationName(), locationID);
    }

    @Override
    public void delete(long id) {
        String sql = "DELETE FROM area WHERE id = ?";
        Delete(sql, id);
    }
}
