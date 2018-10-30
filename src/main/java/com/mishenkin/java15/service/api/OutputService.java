package com.mishenkin.java15.service.api;

/**
 * Сервис для создания HTML файла для резюме
 * Created by Александр on 30.10.2018.
 */
public interface OutputService {
    /**
     * Метод для содздания html-файла
     * @param Path - путь для сохранения html-файла
     */
    void createHtmlFile(String Path);
}
