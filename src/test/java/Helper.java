import com.mishenkin.java15.domain.entity.PersonalData;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * вспомогательный тестовый класс
 * Created by Александр on 02.11.2018.
 */
class Helper {
    private final PersonalData personalData;
    private static final Logger log = Logger.getLogger(Helper.class);

    Helper(PersonalData personalData){
        this.personalData = personalData;
    }

    void createInputPropertyFile(String path){
        if (this.personalData != null){
            /*try {
                File file = new File(path);
                *//*if(!file.exists()){
                    file.createNewFile();
                }*/
                try (FileWriter writer = new FileWriter(path, false)){
                    writer.write("FIO="+personalData.getFIO()+
                            "\nDOB="+personalData.getDOB()+
                            "\nemail="+personalData.getEmail()[0]+
                            "\nskype="+personalData.getSkype()+
                            "\navatar="+personalData.getAvatar()+
                            "\ntarget="+personalData.getTarget()[0]+
                            "\nexperience="+personalData.getExperiences()[0]+
                            "\neducation="+personalData.getEducations()[0]+
                            "\nadditeducation="+personalData.getAdditionalEducations()[0]+
                            "\nskills="+personalData.getSkills()[0]+
                            "\ncodeexample="+personalData.getExamplesCode()[0]);
                    writer.flush();
                    //log.info(outputHttpFilePath+" file created");
                }
           // }
            catch(IOException ex){
                System.out.println(ex.getMessage());
                //log.error("Ошибка ввода вывода");
            }
        }
    }

    static void deleteFile(String path){
        File file = new File(path);
        if (file.delete()) log.info("File "+path+" deleted");
        else log.error(path + " is not deleted");
    }
}
