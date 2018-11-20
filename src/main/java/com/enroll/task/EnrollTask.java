package com.enroll.task;

import com.enroll.mapper.EnrollMapper;
import com.enroll.utils.ExcelWithoutResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  17:47 2018/8/18
 * @ModefiedBy:
 */
public class EnrollTask {

    @Test
    public void exportEnrollInformation() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_mybatis.xml");
        EnrollMapper enrollMapper = (EnrollMapper) context.getBean("enrollMapper");
        Map<Integer, List<Map<String, String>>> map = new HashMap<>();
        List<Map<String, String>> list_for_Java = enrollMapper.selectByEntainment("Java");
        List<Map<String, String>> list_for_qian = enrollMapper.selectByEntainment("qianduan");
        List<Map<String, String>> list_for_C = enrollMapper.selectByEntainment("C#");
        List<Map<String, String>> list_for_python = enrollMapper.selectByEntainment("Python");
        map.put(0, list_for_Java);
        map.put(1, list_for_qian);
        map.put(2, list_for_C);
        map.put(3, list_for_python);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date()));
        System.out.println(map);
        ExcelWithoutResponse.ExportNoResponse(map);
        /*AbstractBeanDefinitionReader*/
    }

}
