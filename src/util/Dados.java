package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

@SuppressWarnings("all")
public class Dados {
    private static final String CAMINHO = "src/obj/";

    public static<T> void  salvar(List<T> obj, String nome) throws Exception{
        
        File arquivo = new File(CAMINHO + nome + ".ser");
        arquivo.getParentFile().mkdirs();

        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(arquivo));
        oos.writeObject(obj);
        oos.close();
    }

    public static<T> List<T> ler(String nome) throws Exception{

        File arquivo = new File(CAMINHO + nome + ".ser");

        if(arquivo.exists() && arquivo.isFile()){
            ObjectInputStream ois = new ObjectInputStream( new FileInputStream(arquivo));
            return (List<T>) ois.readObject();
        } else{
            throw new Exception("Não foi possível ler o arquivo");
        }   
    }
}
