import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();

        String[] croatia=
                {"c=","c-","dz=","d-","lj","nj","s=","z="};

        for(int i=0;i< croatia.length;i++){
            if(str.contains(croatia[i])){   //문자열에 크로아티아 문자 포함시
                str=str.replace(croatia[i],"*");
                //크로아티아 문자를 *로 대체
            }
        }
        System.out.println(str.length());
    }

}