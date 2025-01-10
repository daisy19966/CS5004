public class Power {
    /* 1. Java uses long for large numbers while Python automatically handles large integers
       2. Java uses Math.pow for exponentiation while Python uses the exponentiation operator
       3. Java uses System.out.println while Python uses the print function
    */
    public static void main(String[] args) {
        long result = (long) Math.pow(2, 31);
        
        // print result
        System.out.println("2 raised to the power of 31 is: " + result);
    }