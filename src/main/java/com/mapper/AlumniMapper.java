package com.mapper;

import com.entity.Alumni;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @Author: EvenHuang
 * @Date: 2019/6/19 15:29
 */
@Mapper
public interface AlumniMapper {

    String Alumni_Column_List="graduate_id, name, gender, birthday, enrollment_year, graduation_year, work_city, work_unit, address, phonenumber, mail_address, wechat";

    @Insert("insert into alumni(name,gender,birthday,enrollment_year,graduation_year,work_city,work_unit," +
            "address,phonenumber,mail_address,wechat)" +
            " values (#{name},#{gender},#{birthday},#{enrollmentYear},#{graduationYear},#{workCity},#{workUnit}," +
            "#{address},#{phoneNumber},#{mailAddress},#{wechat})")
    @Options(keyProperty = "graduateId",keyColumn = "graduate_id",useGeneratedKeys = true)
    void addAlumni(Alumni alumni);

    @Delete("delete from alumni where graduate_id=#{id}")
    void deleteAlumniById(int id);

    @Update("update alumni set name=#{name},gender=#{gender},birthday=#{birthday},enrollment_year=#{enrollmentYear},"+
            " graduation_year=#{graduationYear},work_city=#{workCity},work_unit=#{workUnit}," +
            " address=#{address},phonenumber=#{phoneNumber},mail_address=#{mailAddress},wechat=#{wechat}" +
            " where graduate_id=#{graduateId}")
    void updateAlumni(Alumni alumni);


    @Select("select "+Alumni_Column_List+" from alumni where graduate_id=#{id}")
    @Results({
            @Result(id = true,property="graduateId", column="graduate_id"),
            @Result(property="name",column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="birthday", column="birthday"),
            @Result(property="enrollmentYear", column="enrollment_year"),
            @Result(property="graduationYear", column="graduation_year"),
            @Result(property="workCity", column="work_city"),
            @Result(property="workUnit", column="work_unit"),
            @Result(property="address", column="address"),
            @Result(property="phoneNumber", column="phonenumber"),
            @Result(property="mailAddress", column="mail_address"),
            @Result(property="wechat", column="wechat")
    })
    Alumni selectAlumniById(int id);


    @Select("select "+Alumni_Column_List+" from alumni")
    @Results({
            @Result(id = true,property="graduateId", column="graduate_id"),
            @Result(property="name",column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="birthday", column="birthday"),
            @Result(property="enrollmentYear", column="enrollment_year"),
            @Result(property="graduationYear", column="graduation_year"),
            @Result(property="workCity", column="work_city"),
            @Result(property="workUnit", column="work_unit"),
            @Result(property="address", column="address"),
            @Result(property="phoneNumber", column="phonenumber"),
            @Result(property="mailAddress", column="mail_address"),
            @Result(property="wechat", column="wechat")
    })
    ArrayList<Alumni> selectAlumnis();


    @Select("select "+Alumni_Column_List+" from alumni where name like CONCAT(CONCAT('%', #{key}), '%')")
    @Results({
            @Result(id = true,property="graduateId", column="graduate_id"),
            @Result(property="name",column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="birthday", column="birthday"),
            @Result(property="enrollmentYear", column="enrollment_year"),
            @Result(property="graduationYear", column="graduation_year"),
            @Result(property="workCity", column="work_city"),
            @Result(property="workUnit", column="work_unit"),
            @Result(property="address", column="address"),
            @Result(property="phoneNumber", column="phonenumber"),
            @Result(property="mailAddress", column="mail_address"),
            @Result(property="wechat", column="wechat")
    })
    ArrayList<Alumni> selectAlumnisByName(String key);
}
