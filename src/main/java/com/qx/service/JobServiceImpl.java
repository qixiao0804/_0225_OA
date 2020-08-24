package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.qx.mapper.JobMapper;

import com.qx.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class JobServiceImpl implements JobService{

    @Autowired
    private JobMapper jobMapper;

//    @Override
//    public List<Job> selectAll(Job job) throws Exception {
//        return jobMapper.selectAll(job);
//    }

    @Override
    @Transactional
    public int updateByJob(Job job) throws Exception {
        return jobMapper.updateByJob(job);
    }

    @Override
    @Transactional
    public int insertJob(Job job) throws Exception {
        return jobMapper.insertJob(job);
    }

    @Override
    @Transactional
    public int deleteByJob(int id) throws Exception {
        return jobMapper.deleteByJob(id);
    }

    @Override
    public List<Job> selectPage(Job job,int page,int limit) throws Exception {
        System.out.println("service"+job.getUid());
        PageHelper.startPage(page,limit);
        return jobMapper.selectAll(job);
    }



    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {


        if(isID!=null&& !isID.equals("")){
            String [] ids = isID.split(",");
            for (String sid:ids) {
                if(sid!=null && !sid.equals("")){
                    int id = Integer.parseInt(sid);
                    int i = jobMapper.deleteByJob(id);
                    return i;
                }
                return 0;
            }
        }
        return 0;
    }

}
