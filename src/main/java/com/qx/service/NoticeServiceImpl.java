package com.qx.service;


import com.github.pagehelper.PageHelper;
import com.qx.mapper.NoticeMapper;

import com.qx.model.Inform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

//    @Override
//    public List<Inform> selectAll(Inform inform) throws Exception {
//        return noticeMapper.selectAll(inform);
//    }

    @Override
    @Transactional
    public int updateByNot(Inform inform) throws Exception {
        return noticeMapper.updateByNot(inform);
    }

    @Override
    @Transactional
    public int insertNot(Inform inform) throws Exception {
        return noticeMapper.insertNot(inform);
    }
    @Transactional

    @Override
    public int deleteByInform(int id) throws Exception {
        return noticeMapper.deleteByInform(id);
    }

    @Override
    public List<Inform> selectByPage(Inform inform,int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        return noticeMapper.selectAll(inform);
    }


    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {


        if(isID!=null&& !isID.equals("")){
            String [] ids = isID.split(",");
            for (String sid:ids) {
                if(sid!=null && !sid.equals("")){
                    int id = Integer.parseInt(sid);
                    int i = noticeMapper.deleteByInform(id);
                    return i;
                }
                return 0;
            }
        }
        return 0;
    }

}
