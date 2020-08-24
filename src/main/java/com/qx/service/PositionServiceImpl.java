package com.qx.service;

import com.qx.mapper.PositionMapper;
import com.qx.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PositionServiceImpl implements PositionService{
    @Autowired
    private PositionMapper positionMapper;


    @Override
    public Position selectPdf(int id) throws Exception {
        return positionMapper.selectPdf(id);
    }
}
