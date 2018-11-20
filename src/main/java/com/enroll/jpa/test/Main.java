package com.enroll.jpa.test;

import com.enroll.jpa.dao.AudioRepository;
import com.enroll.jpa.dao.PermsRepository;
import com.enroll.jpa.dao.UserPermRepository;
import com.enroll.jpa.dao.UsersRepository;
import com.enroll.jpa.entity.Audioentity;
import com.enroll.jpa.entity.PermsEntity;
import com.enroll.jpa.entity.UsersEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  13:28 2018/11/19
 * @ModefiedBy:
 */
public class Main {

    private AudioRepository audioRepository;
    private PermsRepository permsRepository;
    private UsersRepository usersRepository;
    private UserPermRepository userPermRepository;

    @Before
    public void setup() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext_mybatis.xml");
        audioRepository = context.getBean(AudioRepository.class);
        permsRepository = context.getBean(PermsRepository.class);
        userPermRepository = context.getBean(UserPermRepository.class);
        usersRepository = context.getBean(UsersRepository.class);
    }

    @Test
    public void test() {
        Audioentity audioentity = new Audioentity();
        audioentity.setPrice(156.325);
        audioentity.setCollectiontime(Timestamp.valueOf("2018-09-21 11:11:11"));
        audioentity.setDescription(" Happy  ");
        audioentity.setName(" pian ");
        audioRepository.save(audioentity);
        System.out.println("------------------------------------");
        PermsEntity permsEntity = new PermsEntity();
        permsEntity.setPname(" 1111 ");
        permsEntity.setPdesc("1111");
        permsRepository.save(permsEntity);
        System.out.println("------------------------------------");
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setRegistertime(Timestamp.valueOf("2017-11-26 11:11:11"));
        usersEntity.setUname("song song");
        usersEntity.setGender("male");
        usersRepository.save(usersEntity);
    }

}
