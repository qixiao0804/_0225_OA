package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.qx.mapper.EmailMapper;
import com.qx.mapper.EmployeeMapper;
import com.qx.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Override
    @Transactional
    public int insertByEmail(Email email) throws Exception {
        return emailMapper.insertByEmail(email);
    }

    @Override
    public List<Email> selectByPage(int page,int limit) throws Exception {
        PageHelper.startPage(page,limit);
        return emailMapper.selectByAll();
    }

    @Override
    @Transactional
    public int deleteByEmail(Integer id) {
        return emailMapper.deleteByEmail(id);
    }

//    @Override
//    public int selectByPage() throws Exception {
//        return emailMapper.selectByPage();
//    }
}
