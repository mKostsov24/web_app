package com.example.hrsample.mapper;


import com.example.hrsample.model.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {

    @Insert("INSERT into teacher(fio, faculty) " +
            "VALUES(#{t.fio},#{t.faculty})")
    void save(@Param("t") Teacher teacher);

    @Select("select * from teacher")
    List<Teacher> getAll();


    @Delete("delete from teacher where teacher_id = #{teacherId}")
    void delete(Teacher teacher);

    @Delete("delete from teacher where teacher_id=#{id}")
    void deleteTeacherById(@Param("id") Long id);


    @Update("update teacher set fio = #{t.fio}, faculty =  #{t.faculty} where teacher_id = #{t.teacherId}")
    void update(@Param("t") Teacher teacher);

    @Select("Select t.* from teacher t join ts on ts.teacher_id = t.teacher_id join student s on s.student_id = ts.student_id where s.student_id = #{id}")
    List<Teacher> getAllTeacherByStudent(Long id);
}

