package tests;

import org.testng.annotations.Test;

public class GroupsTest {

    @Test(groups = "smoke")
    public void smokeTest() {
        System.out.println("Smoke Test");
    }

    @Test(groups = "regression")
    public void regressionTest() {
        System.out.println("Regression Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void sanityTest() {
        System.out.println("Sanity Test");
    }
}
