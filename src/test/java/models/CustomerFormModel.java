package models;

public class CustomerFormModel {

    private String email = null;
    private String password = null;
    private String repeatPassword = null;
    private String question = null;
    private String answer = null;

    public CustomerFormModel(CustomerFormBuilder customerFormBuilder) {
        this.email= customerFormBuilder.email;
        this.password= customerFormBuilder.password;
        this.repeatPassword= customerFormBuilder.repeatPassword;
        this.question= customerFormBuilder.question;
        this.answer= customerFormBuilder.answer;

    }

    public  String getEmail() {
        return email;
    }

    public  String getPassword() {
        return password;
    }

    public  String getQuestion() {
        return question;
    }

    public  String getRepeatPassword() {
        return repeatPassword;
    }

    public  String getAnswer() {
        return answer;
    }

    public static class CustomerFormBuilder
    {
        private  String email;
        private  String password;
        private  String repeatPassword;
        private  String question;
        private  String answer;

        public CustomerFormBuilder(String email ,String password)
        {
            this.email = email;
            this.password = password;
        }

        public CustomerFormBuilder repeatPassword(String repeatPassword)
        {
            this.repeatPassword= repeatPassword;
            return this;
        }

        public CustomerFormBuilder answer(String answer)
        {
            this.answer= answer;
            return this;
        }

        public CustomerFormModel build()
        {
            CustomerFormModel customerFormModel = new CustomerFormModel(this);
            return customerFormModel;

        }

    }
}
