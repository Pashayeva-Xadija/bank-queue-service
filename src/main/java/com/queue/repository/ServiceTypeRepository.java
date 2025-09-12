package com.queue.repository;

import com.queue.model.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    boolean existsByName(String name);
}
