package util;

import java.io.File;
import java.io.PrintStream;

public abstract class Log {
    public static void setErro(){
        try {           
            File arquivo = new File("src/log/erro.txt");
            arquivo.getParentFile().mkdir();

            PrintStream ps = new PrintStream(arquivo);
            System.setErr(ps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
