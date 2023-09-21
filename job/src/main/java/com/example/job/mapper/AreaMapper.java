package com.example.job.mapper;

import com.example.job.model.AreaModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaMapper implements RowMapper<AreaModel>{

    @Override
    public AreaModel mapRow(ResultSet rs) {
        try{
            AreaModel area = new AreaModel();
            area.setId(rs.getLong("id"));
            area.setLocationName(rs.getString("locationName"));
            area.setCreatedDate(rs.getTimestamp("createdDate"));
            area.setCreatedBy(rs.getString("createdBy"));
            if(rs.getTimestamp("modifiedDate") != null){
                area.setModifiedDate(rs.getTimestamp("modifiedDate"));
            }
            if(rs.getString("modifiedBy") != null){
                area.setModifiedBy(rs.getString("modifiedBy"));
            }
            return area;
        } catch (SQLException e){
            return null;
        }

    }
}
