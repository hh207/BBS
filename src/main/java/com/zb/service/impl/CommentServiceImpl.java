package com.zb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.entity.Comment;
import com.zb.service.CommentService;
import com.zb.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
implements CommentService{

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findAll() {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("likes");
        return commentMapper.selectList(queryWrapper);
    }

    @Override
    public Comment findByCommentId(Integer commentId) {
        return commentMapper.selectById(commentId);
    }

    @Override
    public int updateByCommentId(Integer likes, Integer userId) {
        return commentMapper.updateCommentInt(likes, userId);
    }
}
