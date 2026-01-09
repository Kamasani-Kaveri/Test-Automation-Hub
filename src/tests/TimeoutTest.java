import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(timeOut = 2000)
    public void slowTest() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Test completed within time");
    }
}
