import com.mishenkin.java15.dao.repository.PersonRepository;
import com.mishenkin.java15.dao.repository.impl.PersonRepositoryFromPropertyFileImpl;
import com.mishenkin.java15.domain.entity.PersonalData;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;

/**
 * проверка метода получения данных из проперти файла
 * Created by Александр on 02.11.2018.
 */
public class PersRepPropertyFileImplGetPropertyTest {
    private PersonalData personalData;
    private final String path = "test.properties";

    @BeforeTest
    private void setTestData(){
        personalData = new PersonalData("FIO",
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
        helper.createInputPropertyFile(path);
    }

    @Test
    public void getPropertyTest(){
        try(InputStream inputStream = new FileInputStream(path)) {
            PersonRepository propertyFile = new PersonRepositoryFromPropertyFileImpl(inputStream);
            Assert.assertTrue(personalData.equals(propertyFile.getPersonalData()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @AfterTest
    private void clean(){
        File file = new File(path);
        if (file.delete()) /*log.info("Файл "+path+" удален");
        else log.error(path + " не удален");*/
            System.out.println("файл удален");
    }

}
