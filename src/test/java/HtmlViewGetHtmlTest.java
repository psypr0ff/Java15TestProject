import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.view.HtmlView;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * тестирование проверки генерации HTML
 * Created by Александр on 31.10.2018.
 */
public class HtmlViewGetHtmlTest {
    private static final Logger log = Logger.getLogger(HtmlViewGetHtmlTest.class);
    private PersonalData personalData;
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
    }

    @Test
    public void isGetHtmlMethodReturnNotNull(){
        log.info("HTML-data generating test started");
        HtmlView htmlView = new HtmlView(personalData);
        boolean result = htmlView
                .getHtml()
                .stream()
                .anyMatch(s -> s.contains("<title>"+personalData.getFIO()));
        if (result) log.info("HTML-data generating test passed");
        else log.error("HTML-data generating test failed");
        Assert.assertTrue(result);
    }
}
