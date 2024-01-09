package com.emc.cm.repository;

import com.emc.cm.entity.ApmInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApmApiProxyRepository extends JpaRepository<ApmInstance, String> {

}
