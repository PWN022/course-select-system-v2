package org.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Course;

/**
 * 课程信息 Mapper 接口
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    // 选课防超卖时锁定课程行，阻止并发读取
    @Select("SELECT * FROM course WHERE id = #{id} FOR UPDATE")
    Course selectByIdForUpdate(@Param("id") Long id);
} 