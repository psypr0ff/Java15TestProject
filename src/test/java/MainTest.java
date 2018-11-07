import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.service.impl.OutputServiceImpl;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * тестирование основного функционала
 * Created by Александр on 04.11.2018.
 */
public class MainTest {
    private final String propertyPath = "test.properties";
    private final String htmlPath = "test.html";

    @BeforeTest
    public void setTestData(){
        PersonalData personalData = new PersonalData("FIO",
                "DOB",
                new String[]{"email"},
                "skype",
                "avatar",
                new String[]{"target"},
                new String[]{"experience"},
                new String[]{"educations"},
                new String[]{"addEducation"},
                new String[]{"skills"},
                new String[]{"codeExample"});
        Helper helper = new Helper(personalData);
        helper.createInputPropertyFile(propertyPath);
    }

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
