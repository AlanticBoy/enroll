package com.enroll.jpa.dao;

import com.enroll.jpa.entity.Audioentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  13:22 2018/11/19
 * @ModefiedBy:
 */
public interface AudioRepository extends JpaRepository<Audioentity, Long>, JpaSpecificationExecutor<Audioentity> {
}
