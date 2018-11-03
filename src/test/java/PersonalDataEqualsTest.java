import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * тестирование метода PersonalData.equals()
 * Created by Александр on 03.11.2018.
 */
public class PersonalDataEqualsTest {
    private static final Logger log = Logger.getLogger(PersonalDataEqualsTest.class);
    private PersonalData actualData;
    private PersonalData expectedData;

    @BeforeTest
    private void setTestData(){
        actualData = new PersonalData("FIO",
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
        expectedData = new PersonalData("FIO",
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
    }

    @Test//(priority = 1)
    public void isEqualsTrue(){
        log.info("PersonalData.equals() method test with equals data started");
        Assert.assertTrue(actualData.equals(expectedData));
        log.info("PersonalData.equals() method test with equals data passed");
    }

    @Test //(priority = 2)
    public void isEqualsFalse(){
        log.info("PersonalData.equals() method test with different data started");
        PersonalData falseData = new PersonalData();
        Assert.assertFalse(falseData.equals(expectedData));
        log.info("PersonalData.equals() method test with different data passed");
    }
}
