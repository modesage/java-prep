package _14_oops.oop6.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try{
//            divide(a,b);
//            throw new Exception(String.valueOf(divide(a,b)));
//            throw new Exception("just for fun");
            String name = "modesage";
            if(name.equals("modesage")){
                throw new MyException("name is modesage");
            }

        }
        //new exception message will be caught
        //this catch will be more strict
        catch(ArithmeticException e){
            System.out.println(e.getMessage());

        }
        catch(MyException e){
            System.out.println(e.getMessage());

        }
        //this will include all exception
        //if this Exception will be on top catch block then below exceptions will never run
        //as this is the parent class of all exceptions
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        //only one finally can be there
        //this block will always run
        finally{
            System.out.println("this will always run!");
        }
    }
    //throws tell that it may throw the exception if you are using this method
    static int divide(int a, int b) throws ArithmeticException{
        //now here we are explicitly throwing the exception, when the if statement is true
        if(b == 0){
            throw new ArithmeticException("please don't divide by zero");
        }
        return a / b;
    }
}
