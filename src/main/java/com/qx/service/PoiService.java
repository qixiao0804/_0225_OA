package com.qx.service;

import com.qx.model.Poi;

import java.util.List;

public interface PoiService {

    List<Poi> selectAll(Poi poi)throws Exception;
}
