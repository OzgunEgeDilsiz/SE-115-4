public class Main {
    public static int factorial(int f){
        if (f==0){
            return 1;
        }
        else{
            return f*(factorial(f-1));
        }
    }

    public static int sumDigits(int s){
        if (s<0){
            s = -s;
        }
        if (s<10){
            return s;
        }
        else{
            return s % 10 + sumDigits(s / 10);
        }
    }

    public static long power(long base, int exp){
        if (exp==0){
            return 1;
        }
        else{
            return base * power(base,exp-1);
        }
    }

    public static int fib(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 4= " + factorial(4));
        System.out.println("Sum of the digits of 305= " + sumDigits(305));
        System.out.println("3 to the power of 4= " + power(3,4));
        System.out.println("Fib(5)= " + fib(5));
    }
}
