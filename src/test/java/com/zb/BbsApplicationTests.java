package com.zb;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zb.entity.User;
import com.zb.mapper.LikeRecordMapper;
import com.zb.mapper.UserMapper;
import com.zb.service.LikeRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BbsApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private LikeRecordService likeRecordService;

    @Test
    void contextLoads() {
        System.out.println(likeRecordService.findByUserId(1));
    }

}
