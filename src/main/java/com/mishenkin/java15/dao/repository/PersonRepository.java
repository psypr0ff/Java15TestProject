package com.mishenkin.java15.dao.repository;

import com.mishenkin.java15.domain.entity.PersonalData;

/**
 * интерфейс для работы с проперти файлом
 * Created by Александр on 30.10.2018.
 */
public interface PersonRepository {
    /**
     * получение персональных данных из хранилища
     * @return {@link PersonalData}
     */
    PersonalData getPersonalData();
}
