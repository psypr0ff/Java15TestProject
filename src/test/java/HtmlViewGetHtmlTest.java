import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.view.HtmlView;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.function.Predicate;

/**
 * Created by Александр on 31.10.2018.
 */
public class HtmlViewGetHtmlTest {
    private static final Logger log = Logger.getLogger(HtmlViewGetHtmlTest.class);

    @Test
    public void isGetHtmlMethodReturnNotNull(){
        log.info("Запущен тест проверки генерации содержимого HTML файла");
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

        HtmlView htmlView = new HtmlView(personalData);
        boolean result = htmlView
                .getHtml()
                .stream()
                .anyMatch((Predicate<String>) s -> s.contains("<title>"+personalData.getFIO()));
        if (result) log.info("Тест пройден");
        else log.error("Тест провален");
        Assert.assertTrue(result
                /*htmlView
                .getHtml()
                .stream()
                .anyMatch((Predicate<String>) s -> s.contains("<title>"+personalData.getFIO()))*/
        );
    }
}
