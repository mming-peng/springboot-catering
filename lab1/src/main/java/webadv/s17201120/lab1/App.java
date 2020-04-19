package webadv.s17201120.lab1;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入账号");
        String user = scan.nextLine();
        System.out.println("请输入密码");
        String pwd = scan.nextLine();
        if (user.equals( "彭明明") && pwd.equals( "1234"))
        {
             System.out.println("登录成功！");
        }else{
             System.out.println("登录失败！");
        }
        if (args.length < 1) {
            System.err.println("Please provide an input!");
            System.exit(0);
        }
        System.out.println(sha256hex(args[0]));
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
