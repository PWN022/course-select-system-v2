package org.example.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.springboot.entity.Score;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreMapper extends BaseMapper<Score> {

    // 按课程和学期统计各等级人数
    @Select("<script>" +
            "SELECT grade, COUNT(*) AS count FROM score " +
            "WHERE course_id = #{courseId} " +
            "<if test='semester != null and semester != \"\"'>AND semester = #{semester}</if> " +
            "GROUP BY grade" +
            "</script>")
    List<Map<String, Object>> countByGrade(@Param("courseId") Long courseId,
                                            @Param("semester") String semester);
} 