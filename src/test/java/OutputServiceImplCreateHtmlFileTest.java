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
    private static final String path = "test.html";


    @Test
    public void isHtmlFileCreated(){
        log.info("Testing "+path+" file creating started");
        OutputServiceImpl outputService = new OutputServiceImpl();
        outputService.createHtmlFile(path);
        File file = new File(path);
        if (file.exists()) log.info(path+" file creating test passed");
        else log.error(path+" file creating test failed");
        Assert.assertTrue(file.exists());
    }

    @AfterTest
    private void clean(){
        Helper.deleteFile(path);
    }
}
