package com.zb.controller;

import com.zb.entity.Comment;
import com.zb.entity.LikeRecord;
import com.zb.entity.User;
import com.zb.service.CommentService;
import com.zb.service.LikeRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private LikeRecordService likeRecordService;

    @GetMapping("/comment")
    public String comment(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");

        if(user != null){
            List<LikeRecord> list = likeRecordService.findByUserId(user.getId());
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (LikeRecord likeRecord: list) {
                arrayList.add(likeRecord.getComment());
            }
            model.addAttribute("likeRecordList", arrayList);
        }

        model.addAttribute("list", commentService.findAll());

        return "comment";
    }

    @GetMapping("addLikeAjax")
    @ResponseBody
    public Map<String, Object> addLikeAjax(String likes, String id, HttpSession session){
        Map<String, Object> map = new HashMap<>();
        User user = (User) session.getAttribute("user");
        // 判断记录表是否有点赞记录
        if (likeRecordService.findById(user.getId(), Integer.parseInt(id)) != null){
            int result = commentService.updateByCommentId(Integer.parseInt(likes)+1, Integer.parseInt(id));
            Comment comment = commentService.findByCommentId(Integer.parseInt(id));

            LikeRecord likeRecord = new LikeRecord(user.getId(), Integer.parseInt(id));

            // 点赞记录表插入一条数据
            likeRecordService.insertRecord(likeRecord);
            map.put("comment", comment);
        }else{
            map.put("state", 1);        // 1：代表已经存在此点赞记录
        }

        return map;
    }

    @GetMapping("reduceLikeAjax")
    @ResponseBody
    public Map<String, Object> reduceLikeAjax(String likes, String id, HttpSession session){
        Map<String, Object> map = new HashMap<>();

        int result = commentService.updateByCommentId(Integer.parseInt(likes)-1, Integer.parseInt(id));
        Comment comment = commentService.findByCommentId(Integer.parseInt(id));

        User user = (User) session.getAttribute("user");
        LikeRecord likeRecord = new LikeRecord(user.getId(), Integer.parseInt(id));

        // 删除记录表的数据
        likeRecordService.deleteRecord(user.getId(), Integer.parseInt(id));
        map.put("comment", comment);
        return map;
    }

}
