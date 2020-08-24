package com.qx.service;

import com.github.pagehelper.PageHelper;
import com.qx.mapper.*;
import com.qx.model.Email;
import com.qx.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;
    @Autowired
    private EmailMapper emailMapper;
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private WorkMapper workMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl()");
    }

    @Override
    public User findByLogin(String loginname, String password) throws Exception {
        return mapper.selectByLogin(loginname, password);
    }

//    @Override
//    public List<User> findAll(User user ,int page,int limit) throws Exception {
//        PageHelper.startPage(page,limit);
//        return mapper.selectByLike(user);
//    }

//    @Override
//    public List<User> findPage(int pageNum, int pageSize) throws Exception {
//        PageHelper.offsetPage(pageNum,pageSize);
//        List<User> users = mapper.selectAll();
//        return users;
//    }

    @Override
    public List<User> selectByLike(User user, int page, int limit) throws Exception {
        PageHelper.startPage(page, limit);
        return mapper.selectByLike(user);
    }

    @Override
    @Transactional
    public int updateByUser(User user) throws Exception {
        return mapper.updateByUser(user);
    }


    @Override
    @Transactional
    public int addUser(User user) throws Exception {
        return mapper.insertUser(user);
    }

    @Override
    @Transactional
    public int deleteByUser(int id) throws Exception {
        int i = emailMapper.deleteByUid(id);
        int i1 = employeeMapper.deleteBUid(id);
        int i2 = workMapper.deleteByWord(id);
        int i3 = signMapper.deleteBySign(id);

        int i4 = mapper.deleteByUser(id);

        if (i + i1 + i2 + i3 + i4 >= 1) {
            return 1;
        }
        return 0;
    }


    @Override
    @Transactional
    public int deleteByAll(String isID) throws Exception {
        if (isID != null && !isID.equals("")) {
            String[] ids = isID.split(",");
            for (String sid : ids) {
                if (sid != null && !sid.equals("")) {
                    int id = Integer.parseInt(sid);
                    int i = emailMapper.deleteByUid(id);
                    int i1 = employeeMapper.deleteBUid(id);
                    int i2 = workMapper.deleteByWord(id);
                    int i3 = signMapper.deleteBySign(id);

                    int i4 = mapper.deleteByUser(id);

                    if (i + i1 + i2 + i3 + i4 >= 1) {
                        return 1;
                    }
                    return 0;
                }
            }
        }

        return 0;
    }


    @Override
    public User selectByName(User user) throws Exception {
        return mapper.selectByName(user);
    }
}
