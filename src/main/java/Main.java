import java.io.*;

/**
 * Created by Александр on 02.05.2018.
 */
public class Main {

    public static void main(String[] args) throws  IOException, NullPointerException
     {
         File input = new File("input.properties"); //инициализируем файл input.properties
         File output = new File("output.html"); //инициализируем файл output.html
         if (input.exists()) { //если файл input.properties существует
             inputParser inputParser = new inputParser(); //инстанцируем парсер файла input.properties
             String encoding = "utf-8"; //устанавливаем кодировку
             if (output.exists()) output.setWritable(true, false); //если файл output.html уже существует - делаем его доступным для перезаписи
             FileOutputStream fos = new FileOutputStream("output.html"); //инстанцируем поток записи в файл output.html
             OutputStreamWriter writer = new OutputStreamWriter(fos, encoding); //инстанцируем кодировщик символов в байты
             //записываем в файл output.html разметку странички
             writer.write("<!DOCTYPE html>" +
                     "<html>" +
                        "<head>" +
                     //подключаем bootstrap3
                            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">" +
                            "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">" +
                            "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>" +
                            "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />" +
                            "<title>" +
                     //указываем в заголовке Ф.И.О.
                                inputParser.fio +
                            "</title>" +
                        "</head>" +
                     "<body style='background: grey;'>" +
                        "<div style='background: white; border: solid 1px black; margin-left:15%; margin-right: 15%; margin-top: 1%' >" +
                            "<div class='row' ><h1><center>Резюме</center></h1></div>" +
                            "<div class='row center-block' >" +
                                "<div class='col-md-8' >" +
                                    "<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                                        "<dt>Ф.И.О.</dt>" +
                                        "<dd>" +
                                            inputParser.fio + //пишем ФИО
                                        "</dd>" +
                                    "</dl>" +
                                    "<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                                        "<dt>Дата рождения</dt>" +
                                        "<dd>" +
                                            inputParser.dob + //пишем дату рождения
                                        "</dd>" +
                                    "</dl>" +
                                    "<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                                        "<dt>email</dt>" +
                                        "<dd>"); //заполняем список адресов электронной почты
                                            for (int x = 0; x < inputParser.email.length; x++) {
                                                writer.write(inputParser.email[x] + "<br>");
                                            }
                                            writer.write(
                                    "</dd>" +
                                    "</dl>" +
                                    "<dl class='dl-horizontal' style='margin-bottom: 0;'>" +
                                        "<dt>Skype</dt>" +
                                        "<dd>" +
                                            inputParser.skype + //указываем логин в скайпе
                                        "</dd>" +
                                    "</dl>" +
                                "</div>" +
                                "<div class='col-md-4'>" +
                     //указываем ссылку на аватар
                                    "<img src='" + inputParser.avatar + "' class='center-block' alt='Аватар' height='100'>" +
                                "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Цель</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.target.length; x++) {
                                        writer.write(x + 1 + ". " + inputParser.target[x] + "<br>");//заполняем список целей
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Опыт</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.experience.length; x++) {
                                        writer.write(x + 1 + ". " + inputParser.experience[x] + "<br>"); //заполням список опыта
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Образование</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.education.length; x++) {
                                        writer.write(x + 1 + ". " + inputParser.education[x] + "<br>");//заполняем список Образование
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Доп.образование и курсы</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.additeducation.length; x++) {
                                        writer.write(x + 1 + ". " + inputParser.additeducation[x] + "<br>");//заполняем список "Курсы"
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Навыки</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.skills.length; x++) {
                                        writer.write(x + 1 + ". " + inputParser.skills[x] + "<br>");//заполняем список навыков
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                            "<div class='panel panel-default' style='margin: 20px; '>" +
                                "<div class='panel-heading'>" +
                                    "<h3 class='panel-title'>Пример кода</h3>" +
                                "</div>" +
                                "<div class='panel-body'>");
                                    for (int x = 0; x < inputParser.codeexample.length; x++) { //заполняем список ссылок на код
                                        writer.write("<a href='" + inputParser.codeexample[x] + "'>" + inputParser.codeexample[x] + "</a></br>");
                                    }
                                    writer.write(
                            "</div>" +
                            "</div>" +
                        "</div>" +
                     "</body>" +
                 "</html>");
             writer.close();
             System.out.println("Страничка сгенерирована успешно");
         } else System.out.println("Страничка не может быть сгенерирована, т.к. файл input.properties не найден");
    }
}
