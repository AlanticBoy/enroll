package com.enroll.jpa.dao;

import com.enroll.jpa.entity.PermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author:付风松
 * @Description:
 * @Date:Created in  9:19 2018/11/20
 * @ModefiedBy:
 */
public interface PermsRepository extends JpaRepository<PermsEntity, Long>, JpaSpecificationExecutor<PermsEntity> {
}
