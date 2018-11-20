package com.enroll.test;

import com.enroll.aspect.AopConfiguration;
import com.enroll.aspect.MathCalculator;
import com.enroll.task.EnrollTask;
import com.enroll.utils.ExcelWithoutResponse;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.*;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  16:02 2018/8/21
 * @ModefiedBy:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext_mybatis.xml")
public class Factorys {

    @Test
    public void test() {
        /*Locale*/
        System.out.println(Locale.getDefault().getCountry());
        for (Locale loacle : Locale.getAvailableLocales()) {
            System.out.print("  " + loacle.getCountry());
        }
        System.out.println();
        for (Locale loacle : Locale.getAvailableLocales()) {
            System.out.print("  " + loacle.getDisplayCountry());
        }
        System.out.println();
        for (Locale loacle : Locale.getAvailableLocales()) {
            System.out.print("  " + loacle.getDisplayLanguage());
        }
        System.out.println();
        for (Locale loacle : Locale.getAvailableLocales()) {
            System.out.print("  " + loacle.getLanguage());
        }
        System.out.println();

    }


    @Test
    public void testTime() {

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());

        Calendar calendar1 = Calendar.getInstance(TimeZone.getTimeZone("America/Argentina/Catamarca"));
        System.out.println(calendar1.getTime());

        Locale local = new Locale("zh", "US");
        System.out.println(local.getCountry());
        System.out.println(local.getLanguage());
    }


    @Test
    public void testLang() {
        Locale locale = Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("locale/resource", locale);
        System.out.println(bundle.getString("aaa"));
        System.out.println(" >> >>  >>  >>  >>   >>");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("locale/resource", Locale.US);
        System.out.println(resourceBundle.getString("aaa"));
        System.out.println(" >> >>  >>  >>  >>   >>");
        ResourceBundle bundle1 = ResourceBundle.getBundle("locale/resource", Locale.CANADA);
        System.out.println(bundle1.getString("aaa"));
        /*ApplicationContext*/
        /*ContextNamespaceHandler*/

    }

    @Test
    public void testHandler() {
        System.out.println("   Counter.class.getClassLoader()     >>    " + Counter.class.getClassLoader());
        System.out.println("   LockDemo.class.getClassLoader()    >>     " + LockDemo.class.getClassLoader());
        System.out.println("   EnrollTask.class.getClassLoader()  >>     " + EnrollTask.class.getClassLoader());
        System.out.println("   ExcelWithoutResponse.class.getClassLoader()  >> " + ExcelWithoutResponse.class.getClassLoader());
        /*ComponentScanBeanDefinitionParser*/
        System.out.println("  " + Factorys.class.getClassLoader().getResourceAsStream("spring/applicationContext_quartz.xml"));

    }

    @Test
    public void testSource() {
        /*AnnotationConfigApplicationContext*/
        System.out.println("   " + Factorys.class.getResource("/com/enroll/mapper/EnrollMapper.xml"));
    }


    @Test
    public void testAssert() {
        System.out.println(" execute  ");
        String str = "s";
        Assert.hasText(str);
        /*XmlBeanDefinitionReader*/
        /*ContextNamespaceHandler*/

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AopConfiguration.class);
        MathCalculator calculator = context.getBean(MathCalculator.class);
        calculator.getResult(21, 7);

    }

    @Autowired
    @Qualifier(value = "dataSource")
    private DataSource dataSource;


    @Test
    public void testTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        String sql = "select * from test";
        List<Map<String, Object>> maps = template.queryForList(sql);
        System.out.println(maps);
    }

    @Test
    public void testHashMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("aa","bb");
        map.put("bb","bb");
        map.put("cc","bb");
        map.put("dd","bb");
        map.put("ee","bb");
        map.put("ff","bb");
        map.put("gg","bb");
        map.put("hh","bb");
        map.put("ii","bb");
        map.put("jj","bb");
        map.put("kk","bb");
        map.put("ll","bb");
        map.put("mm","bb");
        map.put("nn","bb");
        map.put("oo","bb");
        map.put("pp","bb");
        map.put("qq","bb");
        map.put("rr","bb");
        map.put("ss","bb");
        map.put("tt","bb");
        map.put("uu","bb");
        map.put("vv","bb");
        map.put("ww","bb");
        map.put("xx","bb");
        map.put("yy","bb");
        map.put("zz","bb");


    }

}



