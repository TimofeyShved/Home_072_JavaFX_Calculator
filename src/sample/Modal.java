package sample;

public class Modal {
    public long calculation(long a, long b, String operator){
        System.out.println(a+operator+b);
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        System.out.println("Не известный оператор "+ operator);
        return 0;
    }
}
