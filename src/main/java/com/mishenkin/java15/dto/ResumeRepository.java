package com.mishenkin.java15.dto;

import com.mishenkin.java15.domain.entity.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Александр on 27.11.2018.
 */
public interface ResumeRepository extends JpaRepository<PersonalData, Long> {
}
