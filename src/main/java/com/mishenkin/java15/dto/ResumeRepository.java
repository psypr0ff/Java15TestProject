package com.mishenkin.java15.dto;

import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.domain.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Александр on 27.11.2018.
 */
public interface ResumeRepository extends JpaRepository<Summary, Long> {
}
