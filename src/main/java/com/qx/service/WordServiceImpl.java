package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.qx.mapper.WorkMapper;
import com.qx.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WordServiceImpl implements WordService {

    @Autowired
    private WorkMapper workMapper;

//    @Override
//    public List<Work> selectAll(Work work) throws Exception {
//        return workMapper.selectAll(work);
//    }

    @Override
    @Transactional
    public int updateByWork(Work work) throws Exception {
        return workMapper.updateByWork(work);
    }

    @Override
    @Transactional
    public int insertByWord(Work work) throws Exception {
        return workMapper.insertByWord(work);
    }

    @Override
    public List<Work> selectPage(Work work,int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        return workMapper.selectAll(work);
    }


    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {


        if(isID!=null&& !isID.equals("")){
            String [] ids = isID.split(",");
            for (String sid:ids) {
                if(sid!=null && !sid.equals("")){
                    int id = Integer.parseInt(sid);
                    int i = workMapper.deleteByid(id);
                    return i;
                }
                return 0;
            }
        }
        return 0;
    }


}
