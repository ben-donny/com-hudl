package com.hudl.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaswordResetTest extends BasePage {

    public static final String INVALIDEMAIL = "invalidemail@mailinator.com";
    public static final String RESET_PASSWORD_CONFIRMATION_TEXT = "Click the link in the email to reset your password.";
    public static final String THAT_EMAIL_ADDRESS_DOESN_T_EXIST_IN_HUDL = "That email address doesn't exist in Hudl.";


    @BeforeClass
    @Parameters({"BROWSER", "SITEURL"})
    public void setUp(String BROWSER, String SITEURL ) throws Exception{
        createDriver(BROWSER, SITEURL);
    }

    /**
     * I do not want to run multiple not to get locked out
     *
    @Test
    @Parameters({"userName"})
    public void passwordResetWithValidEmail() throws Exception{
        LoginSteps loginSteps = new LoginSteps(new LoginPage());
        loginSteps.doPassordReset(INVALIDEMAIL);
        loginSteps.assertPasswordResetConfirmationText(RESET_PASSWORD_CONFIRMATION_TEXT);
    }
     **/

    @Test
    public void doPasswordResetWithInvalidEmail() throws Exception{
        LoginSteps loginSteps = new LoginSteps(new LoginPage());
        loginSteps.doPassordReset(INVALIDEMAIL);
        loginSteps.assertErrorMessageForInvalidEmailForPasswordReset(THAT_EMAIL_ADDRESS_DOESN_T_EXIST_IN_HUDL);
    }

    @AfterClass(alwaysRun = true)
    public void quitDrver(){
        closeDriver();
    }

}
