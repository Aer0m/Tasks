package Default;
import java.util.Arrays;
import java.util.Scanner;

class Text {
    public String[] alphabetSort(String[] text){
        Arrays.sort(text);

        return text;
    }
}

public class Main {
    public static void main(String[] args) {
        Text txt = new Text();
        Scanner sc = new Scanner(System.in);
        System.out.println("¬ведите текст: ");
        String str = sc.nextLine();
        String[] text = str.split("\\.");
        text = txt.alphabetSort(text);
        for(int i = 0; i < text.length; i++){
            if(!(text[i].contains("?"))) {
                System.out.print(text[i] + ". ");
            }
            else
                System.out.print(text[i]);
            }
        }
    }