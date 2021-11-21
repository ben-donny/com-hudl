package com.hudl.login;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends BasePage {

    private final LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    public void doLogin(String email, String password){
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);
        loginPage.clickOnlogInWithOrganizationButton();
         wait(4);

    }

    public void doPassordReset(String email){
        loginPage.clickOnNeedHelpButton();
        wait(2);
        loginPage.enterEmailForPasswordReset(email);
        loginPage.clickOnResetPasswordButton();
        wait(3);
    }

    public void assertCoachHeaderText(String expectedText) {
        String actualText =  loginPage.getCoachHeaderText();
        assertThat(actualText, containsString(expectedText));
    }

    public void assertQAHiringProjectText(String expectedText) {
        String actualText =  loginPage.getQAHiringProjectText();
        assertThat(actualText, containsString(expectedText));
    }


    public void assertPageTitleText(String expectedText) {
        String actualText =  getPageTitle();
        assertThat(actualText, containsString(expectedText));
    }

    public void assertinvalidEmailAndPasswordErrorText(String expectedText) {
        String actualText =  loginPage.getinvalidEmailAndPasswordErrorText();
        assertThat(actualText, containsString(expectedText));
    }

    public void assertPasswordResetConfirmationText(String expectedText) {
        String actualText =  loginPage.getResetPasswordConfirmationText();
        assertThat(actualText, is(equalTo(expectedText)));
    }

    public void assertErrorMessageForInvalidEmailForPasswordReset(String expectedText) {
        String actualText =  loginPage.getPasswordResetWithInvalidEmailText();
        assertThat(actualText, containsString(expectedText));
    }
}
