package _14_oops.oop2;

public class SingletonClass {
    //private so that no one can automatically create new and different objects
    //when constructor is called in some other file
    private SingletonClass (){

    }
    private static SingletonClass instance;
    public static SingletonClass getInstance(){
        //check whether 1 obj is created or not
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }

}
