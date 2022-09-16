package API;

public class CustomerGeneration {
    public static Customer getDefault() {
        return new Customer("сентябрьгорит1111@test.ru", "333335555", "пуша");
    }
    public static Customer getIncorrectPassword() {
        return new Customer("сентябрьгорит3333@test.ru", "33", "пуша2");
    }
}
