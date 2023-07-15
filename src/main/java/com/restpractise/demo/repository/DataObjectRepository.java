package com.restpractise.demo.repository;

import com.restpractise.demo.entity.DataObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataObjectRepository extends JpaRepository<DataObject, String> {
}
