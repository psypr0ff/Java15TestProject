import com.mishenkin.java15.domain.entity.PersonalData;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



/**
 * тестирование метода PersonalData.equals()
 * Created by Александр on 03.11.2018.
 */
public class PersonalDataEqualsTest {
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
        System.out.println("Test with equals data");
        Assert.assertTrue(actualData.equals(expectedData));
    }

    @Test //(priority = 2)
    public void isEqualsFalse(){
        PersonalData falseData = new PersonalData();
        System.out.println("Test with different data");
        Assert.assertFalse(falseData.equals(expectedData));
    }
}
