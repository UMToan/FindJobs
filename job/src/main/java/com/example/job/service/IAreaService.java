package com.example.job.service;

import com.example.job.model.AreaModel;

import java.util.List;

public interface IAreaService {
    AreaModel save(AreaModel areaModel);

    void update(Long locationID,AreaModel area);

    void delete (long[] ids);

    List<AreaModel> findAll();

    AreaModel findOne(Long locationID );


}
