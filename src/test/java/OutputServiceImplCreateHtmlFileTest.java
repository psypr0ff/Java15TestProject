import com.mishenkin.java15.service.impl.OutputServiceImpl;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;


/**
 * тестирование создания файла
 * Created by Александр on 31.10.2018.
 */
public class OutputServiceImplCreateHtmlFileTest {
    private static final Logger log = Logger.getLogger(OutputServiceImplCreateHtmlFileTest.class);
    private final String path = "test.html";

    @Test
    public void isHtmlFileCreated(){
        log.info("Запущен тест проверки метода создания файла "+path);
        OutputServiceImpl outputService = new OutputServiceImpl();
        outputService.createHtmlFile(path);
        File file = new File(path);
        if (file.exists()) log.info("Тест пройден");
        else log.error("Тест провален");
        Assert.assertTrue(file.exists());
    }

    @AfterTest
    public void clean(){
        File file = new File(path);
        if (file.delete()) log.info("Файл "+path+" удален");
        else log.error(path + " не удален");
    }
}
