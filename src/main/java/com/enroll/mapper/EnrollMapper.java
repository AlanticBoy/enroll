package com.enroll.mapper;


import com.enroll.POJO.Enrollment;

import java.util.List;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:22 2018/8/18
 * @ModefiedBy:
 */
public interface EnrollMapper {
    int insertAItem(Enrollment enrollment);
    List<Map<String,String>> selectByEntainment(String entainment);
}
