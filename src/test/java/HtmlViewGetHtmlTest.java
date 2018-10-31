import com.mishenkin.java15.domain.entity.PersonalData;
import com.mishenkin.java15.view.HtmlView;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Created by Александр on 31.10.2018.
 */
public class HtmlViewGetHtmlTest {
    @Test
    public void isGetHtmlMethodReturnNotNull(){
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
        Assert.assertTrue(!htmlView.getHtml().isEmpty());
    }
}
