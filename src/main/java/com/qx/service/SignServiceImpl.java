package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.qx.mapper.SignMapper;
import com.qx.model.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;

//    @Override
//    public List<Sign> selectBySign(Sign sign) throws Exception {
//        return signMapper.selectBySign(sign);
//    }

    @Override
    public Sign selectByName(Sign sign) throws Exception {
        return signMapper.selectByName(sign);
    }

    @Override
    @Transactional
    public int insertBySign(Sign sign) throws Exception {
        return signMapper.insertBySign(sign);
    }

    @Override
    public List<Sign> selectBypage(Sign sign,int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        return signMapper.selectBypage(sign);
    }


    @Override
    public List<Sign> selectBypage1(Sign sign,int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        return signMapper.selectBypage1(sign);
    }

}
