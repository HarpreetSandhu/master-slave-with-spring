package com.therootcoder.sample.masterslavespring.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Indexed;

import java.io.Serializable;
import java.util.List;

/**
 * Base repository interface to expose read-only methods for consumers
 *
 * CAUTION: Don't add any data manipulation/insertion method here. Only read-only operation must be added here
 *
 * @author Harpreet Sandhu
 * @since 23-Mar-2019
 **/
@NoRepositoryBean
@Indexed
public interface ReadOnlyRepository<ENTITY, ID extends Serializable> extends Repository<ENTITY, ID> {
    ENTITY findById(ID id);

    boolean existsById(ID var1);

    List<ENTITY> findAll();

    long count();
}