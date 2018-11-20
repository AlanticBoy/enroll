package com.enroll.jpa.dao;

import com.enroll.jpa.entity.UserPermEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:20 2018/11/20
 * @ModefiedBy:
 */
public interface UserPermRepository extends JpaRepository<UserPermEntity, Long>, JpaSpecificationExecutor<UserPermEntity> {
}
