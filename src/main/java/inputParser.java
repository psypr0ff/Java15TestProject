import java.io.*;
import java.util.Properties;

/**
 * Created by Александр on 02.05.2018.
 */
public class inputParser {
    public String fio;
    public String dob;
    public String[] email ;
    public String skype;
    public String avatar;
    public String[] target;
    public String[] experience;
    public String[] education;
    public String[] additeducation;
    public String[] skills;
    public String[] codeexample;
    propertyChecker checker;
    {
        Properties property = new Properties(); //инстанцируем Properties
        try {
            property.load(new FileInputStream(new File("input.properties"))); //загружаем Properties из файла
            checker = new propertyChecker(); //инстанцируем класс проферяющий корректность данных в файле input.properties
            fio=checker.propertyChecker(property,"FIO"); //получаем и проверяем значение по ключу FIO
            dob=checker.propertyChecker(property,"DOB"); //получаем и проверяем значение по ключу DOB
            email=checker.propertyCheckerArray(property, "email"); //получаем и проверяем значение по ключу email
            skype=checker.propertyChecker(property, "skype"); //получаем и проверяем значение по ключу skype
            avatar = checker.propertyChecker(property, "avatar"); //получаем и проверяем значение по ключу avatar
            target = checker.propertyCheckerArray(property, "target"); //получаем и проверяем значение по ключу target
            experience = checker.propertyCheckerArray(property,"experience"); //получаем и проверяем значение по ключу experience
            education = checker.propertyCheckerArray(property, "education"); //получаем и проверяем значение по ключу education
            additeducation = checker.propertyCheckerArray(property, "additeducation"); //получаем и проверяем значение по ключу additeducation
            skills = checker.propertyCheckerArray(property, "skills"); //получаем и проверяем значение по ключу skills
            codeexample = checker.propertyCheckerArray(property, "codeexample"); //получаем и проверяем значение по ключу codeexample
        }
        catch (IOException e) { //ловим исключение
            e.printStackTrace();
        }
    }

}
