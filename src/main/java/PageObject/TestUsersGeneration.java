package PageObject;

import com.github.javafaker.Faker;

public class TestUsersGeneration {

    Faker faker = new Faker();
    private String name;
    private String email;
    private String correctPassword;
    private Integer incorrectPassword;



    public String getName(){
    String name = faker.name().firstName();
    return name;
}

    public String getEmail(){
        String email = faker.name().firstName() + "@test.ru";
        return email;
    }
    public Integer getCorrectPassword(){
        Integer correctPassword = faker.number().numberBetween(000000, 9999999);
        return correctPassword;
    }
    public Integer getIncorrectPassword(){
        Integer incorrectPassword = faker.number().numberBetween(0,99999);
        return incorrectPassword;
    }

}
