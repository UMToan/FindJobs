package com.example.job.service;

import com.example.job.dao.AreaDAO;
import com.example.job.model.AreaModel;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.List;


public class AreaService implements IAreaService{

    AreaDAO areaDAO = new AreaDAO();
    @Override
    public AreaModel save(AreaModel areaModel) {
        areaModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        Long locationID =areaDAO.save(areaModel);
        return areaDAO.findOne(locationID);
    }

    @Override
    public void update(Long locationID,AreaModel area) {
        //AreaModel oldArea = areaDAO.findOne(area.getId());
        area.setLocationName(area.getLocationName());
        area.setCreatedDate(area.getCreatedDate());
        area.setCreatedBy(area.getCreatedBy());
        area.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        area.setModifiedBy("");
        areaDAO.update(locationID,area);
    }

    @Override
    public void delete(long[] ids) {
        for(long id: ids){
            areaDAO.delete(id);
        }
    }

    @Override
    public List<AreaModel> findAll() {
        return areaDAO.findAll();
    }

    @Override
    public AreaModel findOne(Long locationID) {
        return areaDAO.findOne(locationID);
    }


}
