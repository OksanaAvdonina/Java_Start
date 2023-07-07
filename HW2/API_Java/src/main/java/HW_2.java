//Урок 2. Почему вы не можете не использовать API

//1) Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder или String.
// Данные для фильтрации приведены ниже в виде строки.
// Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

//Дополнительные задания
//2) Дана json-строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].

//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class HW_2 {
    public static void main(String[] args) {
        String strSql = "select * from students where";
        String file = "file.txt";
        ArrayList<String> list = new ArrayList<String>(2);
        list.add("Hello");
        list.add("world");
        System.out.println(list);
        System.out.println(list.toString());

        char[]fileString = Reader(file);

        String str = Arrays.toString(fileString);

        String newstr = FormatText(str);

        StringBuilder builder = new StringBuilder(strSql);
        String[] arrStr = newstr.split(",  ");

        for(int i = 0; i < arrStr.length;i++){
            if(!arrStr[i].contains("null")) {builder.append(arrStr[i]);}
            if(i < arrStr.length - 2) {builder.append(" and ");}
        }
        System.out.println(builder);
    }
    static char[] Reader(String file){
        FileReaderExtended reader1 = null;
        try {
            reader1 = new FileReaderExtended(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");;
        }
        char[]chars = new char[reader1.GetLength(reader1)];
        try {
            FileReaderExtended reader2 = new FileReaderExtended(file);
            reader2.read(chars);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }
        return chars;
    }
    static String FormatText(String str){
        str = str.replaceAll("[\\[,{, }\\],]", "");
        str = str.replaceAll("[\"\"]", " ");
        str = str.replaceAll("[:]", "=");
        str = str.replaceAll("  ", ",  ");
        return str;
    }

}
