import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FileUtils {

    public static List<ArrayList> read(String fileName) {
        //ArrayList<ArrayList> array = new ArrayList<>();
        List array = new ArrayList<>();
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                //ArrayList<String> splitArrayList = new ArrayList<>();
                List splitArrayList = new ArrayList<>();
                //String[] splitArray = line.split(cvsSplitBy);
                splitArrayList = Arrays.asList(line.split(cvsSplitBy));
/*
                for (String s : splitArray) {
                    splitArrayList.add(s);
                }
*/
                array.add(splitArrayList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

//    public static void write(String fileName, String textToFile) {
//        //Определяем файл
//        File file = new File(fileName);
//
//        try {
//            //проверяем, что если файл не существует то создаем его
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            //PrintWriter обеспечит возможности записи в файл
//            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
//            try {
//                //Записываем текст у файл
//                out.print(textToFile);
//            } finally {
//                //После чего мы должны закрыть файл
//                //Иначе файл не запишется
//                out.close();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void write(String outFile, List<ArrayList> array) {
        //Определяем файл
        String fileName = null;
        File file = null;
        if (fileName != null) {
            file = new File(fileName);
        }
        //Конвертируем массив в строку
        String textToFile = convertListToString(array);

        try {
            //проверяем, что если файл не существует то создаем его
            if (!file.exists()) {
                file.createNewFile();
            }
            //PrintWriter обеспечит возможности записи в файл
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                //Записываем текст у файл
                out.print(textToFile);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertListToString(List<ArrayList> array) {
        String str = "";
        String separator = ",";
        String newLine = "\n";

        for (List<String> textArray : array) {
            for (int i = 0; i < textArray.size(); i++) {
                str += textArray.get(i);
                if (i < textArray.size()-1){
                    str += separator;
                }else{
                    str += newLine;
                }
            }
        }
        return str;
    }

    public static void print(List<ArrayList> array) {
        List<String> arrayList;

        for (int i = 0; i < array.size(); i++) {
            arrayList = array.get(i);
            for (int j = 0; j < arrayList.size(); j++) {
                System.out.print("(" + i + ":" + j + ")" + arrayList.get(j) + "\t");
            }
            System.out.println();
        }
    }

}