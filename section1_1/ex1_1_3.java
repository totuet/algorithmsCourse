package section1_1;

public class ex1_1_3 {
    public static void main(String[] args) {
        for (String n: args) {
            System.out.println(n);
        };
        if((args[0].equals(args[1])) && (args[1].equals(args[2]))) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

    }
}
