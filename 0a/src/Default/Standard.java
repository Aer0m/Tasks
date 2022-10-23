package Default;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Text{
    public ArrayList outsort(String[] text, String word){
        word = word.toLowerCase();
        ArrayList <String> words = new ArrayList<>();
        String[] strings;
        for(int i = 0; i < text.length; i++){
            strings = text[i].split("\\s");
            for(int j = 0; j < strings.length; j++){
                if(Objects.equals(strings[j].toLowerCase(), word)){
                    words.add(text[i]);
                }
            }
        }
        return words;
    }
}

public class Standard {
    public static void main(String[] args) {
        Text txt = new Text();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст: "); //текст вводится в одну строчку, предложения отделяются точками
        String text = sc.nextLine();
        text = text.trim();
        System.out.println("Введите ключевое слово: ");
        String word = sc.nextLine();
        word = word.trim();
        word = word.toLowerCase();
        String[] textArr = text.split("\\.");
        String str = String.valueOf(txt.outsort(textArr, word));
        str = str.substring(1, str.length()-1);
        str = str.replace(",", ";");
        System.out.println(str + ".");
    }
}
