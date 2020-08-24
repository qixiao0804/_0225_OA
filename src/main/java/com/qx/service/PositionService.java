package com.qx.service;

import com.qx.model.Position;
import org.apache.ibatis.annotations.Select;

public interface PositionService {

    //职位查找  模糊查询
    Position selectPdf(int id)throws Exception;

}
