package com.qx.service;

import com.qx.mapper.PoiMapper;
import com.qx.model.Poi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PoiServiceImpl implements PoiService {
    @Autowired
    private PoiMapper poiMapper;

    @Override
    public List<Poi> selectAll(Poi poi) throws Exception {
        return poiMapper.selectAll(poi);
    }
}
