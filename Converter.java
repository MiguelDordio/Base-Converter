import java.util.*;

public class Main {
    public static void main(String[] args){
        ask_input();
    }

    private static void convertBase10(int num, int base){
        char[] trans = new char[8];
        int i = trans.length-1;
        while(num != 0){
            trans[i] = (char)(num % base + '0');
            num /= base;
            i--;
        }
        System.out.println("" + new String(trans));
    }

    private static int convertoToBase10(char[] num, int base){
        double result = 0;
        int size = num.length-1;
        for(int i = 0; i < num.length; i++){
            result += Math.pow(base, size)*Integer.parseInt(String.valueOf(num[i]));
            size--;
        }
        return (int) Math.round(result);
    }

    private static void ask_input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert a number: ");
        int num = input.nextInt();
        Scanner input1 = new Scanner(System.in);
        System.out.println("Insert a base: ");
        int base = input1.nextInt();
        Scanner input2 = new Scanner(System.in);
        System.out.println("Insert a base: ");
        int baseTo = input2.nextInt();
        if(base == 10){
            System.out.print(num + " in base " + base + " = ");
            convertBase10(num, baseTo);
        }else{
            char[] chars = ("" + num).toCharArray();
            int tmp = convertoToBase10(chars ,base);
            System.out.print(num + " in base " + base + " = ");
            convertBase10(tmp, baseTo);
            System.out.print("in base "+ baseTo);
        }
    }
}
