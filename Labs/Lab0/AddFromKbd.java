import java.util.Scanner;  // import Scanner class

public class AddFromKbd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();
        
        int sum = num1 + num2;
        
        // print result
        System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);
        
        // close scanner
        scanner.close();
    }
}

