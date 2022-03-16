package ex3v2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriteFile {
    public void whenWriteStringUsingBufferedWritter_thenCorrect(List<String> arrReadFile, String writePathFile) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writePathFile+"/ระบบจัดการหัวข้อการสัมนา.txt"))) {
            for (String data : arrReadFile) {
                writer.write(data);
                writer.newLine();
                System.out.println(data);
            }
            System.out.println("Write Success");
        } catch (Exception e) {
            System.out.println("Write Error");
            e.printStackTrace();
        }
    }
}
