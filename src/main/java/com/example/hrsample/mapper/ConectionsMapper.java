package com.example.hrsample.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ConectionsMapper {
    @Insert("INSERT into ts (student_id, teacher_id) Values (#{sId} , #{tId})")
    void saveConection(Long tId, Long sId);

    @Delete("Delete from ts where (teacher_id = #{tId} and student_id = #{sId})")
    void deleteConection(Long tId, Long sId);
}
