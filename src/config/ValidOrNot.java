package config;

public  class ValidOrNot {

    public static boolean validEmail(String email){
        return email.matches(emailPattern());
    }

    public static String emailPattern(){
      return   "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    }

    public static boolean validPassword(String password){
        return password.matches(passwordPattern());
    }

    public static String passwordPattern(){
        return "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@!#$%_+=]).{8,}$";
    }
}
