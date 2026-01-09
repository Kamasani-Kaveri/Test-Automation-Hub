import org.testng.annotations.Test;

public class EnabledTest {

    @Test(enabled = false)
    public void disabledTest() {
        System.out.println("This will not run");
    }

    @Test
    public void enabledTest() {
        System.out.println("This will run");
    }
}
