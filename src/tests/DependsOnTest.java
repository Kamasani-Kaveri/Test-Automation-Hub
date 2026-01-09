import org.testng.annotations.Test;

public class DependsOnTest {

    @Test
    public void login() {
        System.out.println("Login Successful");
    }

    @Test(dependsOnMethods = "login")
    public void placeOrder() {
        System.out.println("Order Placed");
    }
}
