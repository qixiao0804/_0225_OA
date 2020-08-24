package com.qx.mapper;

import com.qx.model.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {

//    //员工查询
//
////    @Select("select staff.*,job.name,department.name " +
////            "from (staff left join department on staff.did= department.id) left join job on staff.jid= job.id ")
//    @Select("<script>select staff.*,job.name as jname,department.name as dname " +
//            "from (staff left join department on staff.did= department.id) left join job on staff.jid= job.id <where>" +
//            "<if test=\"name!=null and name !=''\">staff.name=#{name}</if>" +
//            "<if test=\"sex>0 and sex !=''\">and sex=#{sex}</if> " +
//            "<if test=\"jid!=null and jid !=''\">and staff.jid=#{jid}</if>" +
//            "<if test=\"tel!=null and tel !=''\">and tel=#{tel}</if>" +
//            "<if test=\"did!=null and did !=''\">and staff.did=#{did}</if>" +
//            "<if test=\"cardId!=null and cardId !=''\">and cardId=#{cardId}</if>" +
//            "</where></script>")
////    @Select("select staff.*,job.name,department.name  from staff,department,job where department.id=staff.did and staff.jid=job.id")
//    List<Staff> selectByAll(Staff staff)throws Exception;


    @Update("update staff set " +
            "name=#{name}," +
            "cardId=#{cardId}, " +
            "address=#{address}, " +
            "postCode=#{postCode}, " +
            "tel=#{tel}," +
            "phone=#{phone}," +
            "qqNum=#{qqNum}," +
            "email=#{email}," +
            "sex=#{sex}," +
            "party=#{party}," +
            "birthday=#{birthday}," +
            "race=#{race}," +
            "education=#{education}," +
            "speciality=#{speciality}," +
            "hobby=#{hobby}," +
            "remark=#{remark}," +
            "did=#{did}," +
            "jid=#{jid} " +
            "where id = #{id}")

    int updateByEmp(Staff staff)throws Exception;

    //员工添加
    @Insert("insert into staff (name,cardId,address,postCode,tel,qqNum,email,sex,party,birthday,race,education,speciality,hobby,remark,createDate,did,jid,phone)" +
            "values(#{name},#{cardId},#{address},#{postCode},#{tel},#{qqNum},#{email},#{sex},#{party},#{birthday},#{race}," +
            " #{education},#{speciality},#{hobby},#{remark},#{createDate},#{did},#{jid},#{phone})")
    int insertEmp(Staff staff) throws Exception;


    //员工删除
//    @Delete("<script>delete from staff where <if test=\"id!=null and id !=''\">id=#{id}</if> <if test=\"uid!=null and uid !=''\">uid=#{id}</if> </script>")
    @Delete("delete from staff where id=#{id}")
    int deleteByEmp(Integer id)throws Exception;

    @Delete("delete from staff where uid = #{id}")
    int deleteBUid(Integer uid)throws Exception;



    //员工查询

    //    @Select("select staff.*,job.name,department.name " +
//            "from (staff left join department on staff.did= department.id) left join job on staff.jid= job.id ")
    @Select("<script>select staff.*,job.name as jname,department.name as dname " +
            "from (staff left join department on staff.did= department.id) left join job on staff.jid= job.id <where>" +
            "<if test=\"name!=null and name !=''\">staff.name=#{name}</if>" +
            "<if test=\"sex>0 and sex !=''\">and sex=#{sex}</if> " +
            "<if test=\"jid!=null and jid !=''\">and staff.jid=#{jid}</if>" +
            "<if test=\"tel!=null and tel !=''\">and tel=#{tel}</if>" +
            "<if test=\"did!=null and did !=''\">and staff.did=#{did}</if>" +
            "<if test=\"cardId!=null and cardId !=''\">and cardId=#{cardId}</if>" +
            "</where></script>")
//    @Select("select staff.*,job.name as jname,department.name as dname  from staff,department,job where department.id=staff.did and staff.jid=job.id")
    List<Staff> selectByAll(Staff staff)throws Exception;
}
