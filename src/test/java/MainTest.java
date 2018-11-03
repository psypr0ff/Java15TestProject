import com.mishenkin.java15.service.impl.OutputServiceImpl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * тестирование основного функционала
 * Created by Александр on 04.11.2018.
 */
public class MainTest {
    private final String propertyPath = "test.property";
    private final String htmlPath = "test.html";

    @Test
    public void acceptanceTest(){
        OutputServiceImpl outputService = new OutputServiceImpl(propertyPath);
        outputService.createHtmlFile(htmlPath);
    }

    @AfterTest
    public void clean(){
        Helper.deleteFile(htmlPath);
        Helper.deleteFile(propertyPath);
    }
}
