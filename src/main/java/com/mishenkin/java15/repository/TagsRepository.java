package com.mishenkin.java15.repository;

import com.mishenkin.java15.domain.entity.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Александр on 04.12.2018.
 */
public interface TagsRepository extends JpaRepository<Tags, Long> {
    //List<Tags> findBySummaryId(Long id);
}
