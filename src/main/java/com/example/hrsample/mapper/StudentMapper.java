package com.example.hrsample.mapper;


import com.example.hrsample.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Insert("insert into student (fio, course, specialty) " +
            "values (#{s.fio}, #{s.course}, #{s.specialty})")
    void save(@Param("s") Student student);

    @Select("select * from student")
    List<Student> getAll();

    @Select("Select s.* from student s join ts on ts.student_id = s.student_id join teacher t on t.teacher_id = ts.teacher_id where t.teacher_id = #{id}")
    List<Student> getAllStudentByTeacher(Long id);

    @Delete("delete from student where student_id = #{studentId}")
    void delete(Student student);

    @Delete("delete from student where student_id=#{id}")
    void deleteStudentById(@Param("id") Long id);

    @Update("update student set fio = #{e.fio}, course =  #{e.course}, specialty = #{e.specialty} where student_id = #{e.studentId}")
    void update(@Param("e") Student student);
}
