package com.example.job.dao;

import com.example.job.model.AreaModel;

import java.util.List;

public interface IAreaDAO extends GernericDAO<AreaModel> {

    AreaModel findOne(Long locationID);

    List<AreaModel> findAll();

    Long save(AreaModel areaModel);

    void update(Long locationID,AreaModel areaModel);

    void delete(long id);
}
