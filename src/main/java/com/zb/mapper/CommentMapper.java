package com.zb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zb.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
* @Entity com.zb.entity.Comment
*/
@Repository
public interface CommentMapper extends BaseMapper<Comment> {

    @Update("update comment set likes = #{likes} where id = #{userId}")
    int updateCommentInt(@Param("likes") Integer likes, @Param("userId") Integer userId);

}
