package class01;

import org.testng.annotations.Test;

public class dependsON {

    @Test
    public void Login(){
        System.out.println("Logged in");
    }

    @Test(dependsOnMethods = {"Login"})
    public void DashBoardVerification(){
        System.out.println("After log in I am verifying the dashboard page");
    }
}
