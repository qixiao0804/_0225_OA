package com.qx.mapper;

import com.qx.model.Job;
import com.qx.model.Poi;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PoiMapper {


    @Select("select * from job ")
    List<Poi> selectAll(Poi poi)throws Exception;



}
