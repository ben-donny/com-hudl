package com.hudl.login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {
    public static final String EMAIL_AND_OR_PASSWORD_NEED_HELP_TEXT = "We didn't recognize that email and/or password. Need help?";
    public static final String LOGIN_ACCOUNT_ICON_TEXT = "Coach I";
    public static final String QA_HIRE_PROJECT_TEXT = "QA Hire Project";
    public static final String HOME_HUDL = "Home - Hudl";
    public static final String INVALID_PASSWORD = "invalidPassword";
    public static final String INVALIDEMAIL = "invalidemail@mailinator.com";
    LoginSteps loginSteps;



    @BeforeClass
    @Parameters({"BROWSER", "SITEURL"})
    public void setUp(String BROWSER, String SITEURL ) throws Exception{
        createDriver(BROWSER, SITEURL);
        loginSteps = new LoginSteps(new LoginPage());
    }

    @Test
    @Parameters({"userName", "password"})
    public void loginWithValidCredentials(String userName, String password) throws Exception{

        loginSteps.doLogin(userName, password);
        loginSteps.assertCoachHeaderText(LOGIN_ACCOUNT_ICON_TEXT);
        loginSteps.assertQAHiringProjectText(QA_HIRE_PROJECT_TEXT);
        loginSteps.assertPageTitleText(HOME_HUDL);

    }

    @Test
    public void loginWithEmailAndPasswordFieldBlank() throws Exception{

        loginSteps.doLogin("", "");
        loginSteps.assertinvalidEmailAndPasswordErrorText(EMAIL_AND_OR_PASSWORD_NEED_HELP_TEXT);
    }

    @Test
    @Parameters({"userName"})
    public void loginWithInValidPassword(String userName) throws Exception{


        loginSteps.doLogin(userName, INVALID_PASSWORD);
        loginSteps.assertinvalidEmailAndPasswordErrorText(EMAIL_AND_OR_PASSWORD_NEED_HELP_TEXT);
    }

    @Test
    @Parameters({"password"})
    public void loginWithInValidEmail(String password) throws Exception{

        loginSteps.doLogin(INVALIDEMAIL, password);
        loginSteps.assertinvalidEmailAndPasswordErrorText(EMAIL_AND_OR_PASSWORD_NEED_HELP_TEXT);
    }

    @AfterClass(alwaysRun = true)
    public void quitDrver(){
        closeDriver();
    }

}
