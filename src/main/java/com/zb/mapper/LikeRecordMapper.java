package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.entity.LikeRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @Entity com.zb.entity.LikeRecord
*/
@Repository
public interface LikeRecordMapper extends BaseMapper<LikeRecord> {

    @Select("select * from likerecord where userid = #{userId}")
    List<LikeRecord> findByUserid(@Param("userId") Integer userId);
}
