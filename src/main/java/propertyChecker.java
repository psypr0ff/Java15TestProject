import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Created by Александр on 05.05.2018.
 */
public class propertyChecker {

    //метод проверяющий ключи файла properties имеющие единичное значение
    public String propertyChecker(Properties property, String key) throws UnsupportedEncodingException{
        String propertyValue;
        if (!property.containsKey(key)){ //если искомого ключа нет - ругаемся в консоль и на сгенерированной страничке
            System.out.println("В файле input.properties отсутствует обязательный ключ " + key);
            if ((key.contains("avatar"))){ //если отсутствует ключ avatar - закрываем тег, меняем альтернативный текст
                propertyValue="#' alt=' Добавьте ключ "+key+"  в файл input.properties' style='background-color:red'";
            }else //пишем на сгенерированной страничке сообщение
            propertyValue="Добавьте ключ <b style='color:red'>"+key+"</b> в файл input.properties";
        } else //если искомый ключ найден - получаем соответствующее ему значение из файла properties
            propertyValue = new String(property.getProperty(key).getBytes("ISO8859-1"));
        return propertyValue;
    }

    //метод проверяющий ключи файла properties имеющие несколько соответсвующих значений
    public String[] propertyCheckerArray(Properties property, String key) throws UnsupportedEncodingException{
        String[] propertyValue;
        if (!property.containsKey(key)){ //если его нет - ругаемся в консоль и на сгенерированной страничке
            System.out.println("В файле input.properties отсутствует обязательный ключ " + key);
            propertyValue =  new String[1];
            if ((key.contains("codeexample"))){ //если отсутствует ключ codeexample - закрываем тег и меняем текст ссылки
                propertyValue[0]="# Добавьте ключ "+key+"  в файл input.properties";
            }else //пишем сообщение на сгенерированной страничке
            propertyValue[0]="Добавьте ключ <b style='color:red'>"+key+"</b> в файл input.properties";
        } else //если искомый ключ найден - получаем соответствующие ему значения из файла properties
            propertyValue = new String(property.getProperty(key).getBytes("ISO8859-1")).split(";");
        return propertyValue;
    }
}
