package com.enroll.controller;


import com.enroll.POJO.Enrollment;
import com.enroll.mapper.EnrollMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  11:56 2018/8/18
 * @ModefiedBy:
 */
@Controller
@RequestMapping("/submit")
public class SubmitController {

    @Autowired
    private EnrollMapper enrollMapper;

    private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    @RequestMapping(value = "/dubug", method = {RequestMethod.POST, RequestMethod.GET})
    public void debug(HttpServletResponse response) {
        //设定编码
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        try {
            PrintWriter writer = response.getWriter();
            ObjectMapper mapper=new ObjectMapper();
            writer.write(mapper.writeValueAsString("Go Back Ret"));
            writer.close();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping("/submits")
    public void submits(Enrollment enrollment, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Integer count = 0;
        String addr = request.getRemoteAddr();
        String host = request.getRemoteHost();
        JSONObject object = new JSONObject();
        //设定编码
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        System.out.println("  addr  " + addr + "   host  " + host);
        Map<String, Object> map = new HashMap<>();
        if (list.contains(addr)) {
            map.put("retMsg", "不能多次报名！");
        } else {
            if (StringUtils.isEmpty(enrollment.getName())) {
                map.put("retMsg", "姓名不能为空");
            } else if (StringUtils.isEmpty(enrollment.getSegment())) {
                map.put("retMsg", "班级不能为空");
            } else if (StringUtils.isEmpty(enrollment.getEntainment())) {
                map.put("retMsg", "兴趣方向不能为空");
            } else {
                int record = enrollMapper.insertAItem(enrollment);
                System.out.println(" after insert  " + record);
                if (record == 0) {
                    map.put("retMsg", "保名失败，请联系群主");
                } else if (record == 1) {
                    map.put("retMsg", "报名成功");
                }
            }
            list.add(addr);
        }
        object.accumulate("data", map);
        writer.write(object.toString());
        writer.flush();
    }

}
