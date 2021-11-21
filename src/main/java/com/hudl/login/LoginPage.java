package com.hudl.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="div > a.mainnav__btn.mainnav__btn--primary")
    private WebElement loginBtn;

    @FindBy(id="email")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="logIn")
    private WebElement logInWithOrganizationBtn;

    @FindBy(css="div.hui-globaluseritem > div.hui-globaluseritem__display-name > span")
    private WebElement coachHeaderText;

    @FindBy(css=".hui-primaryteamswitcher > .hui-primaryteamswitcher__item.hui-primaryteamswitcher__item--team  span")
    private WebElement qaHiringProjectText;

    @FindBy(css="body > div.super-wrap > form.login-container > div.login-error.fade-in-expand > div > p")
    private WebElement invalidEmailAndPasswordErrorText;

    @FindBy(css="div.remember-help > div > label")
    private WebElement rememberButton;

    @FindBy(id="forgot-password-link")
    private WebElement needHelpBtn;

    @FindBy(id="forgot-email")
    private WebElement forgotEmailField;

    @FindBy(id="resetBtn")
    private WebElement resetButton;

    @FindBy(css="div.reset-error.fade-in-expand > div > p")
    private WebElement messagePasswordResetWithInvalidEmail;

    @FindBy(css="div.reset-info > p:nth-child(2)")
    private WebElement passwordResetConfirmationMessageForValidEmail;


    public void clickOnlogInButton() {
        this.loginBtn.click();
    }

    public void enterUsername(String email) {
        this.userName.clear();
        this.userName.sendKeys(email);

    }

    public void enterPassword(String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickOnlogInWithOrganizationButton() {
      this.logInWithOrganizationBtn.click();
    }

    public String getCoachHeaderText(){
       return coachHeaderText.getText();
    }

    public String getQAHiringProjectText(){
      return qaHiringProjectText.getText();
    }

    public String getinvalidEmailAndPasswordErrorText(){
        return invalidEmailAndPasswordErrorText.getText();
    }

    public void clickOnNeedHelpButton() {
        this.needHelpBtn.click();
    }

    public void enterEmailForPasswordReset(String email) {
        this.forgotEmailField.click();
        this.forgotEmailField.sendKeys(email);
    }

    public void clickOnResetPasswordButton() {
        this.resetButton.click();
    }

    public String getResetPasswordConfirmationText(){
        return passwordResetConfirmationMessageForValidEmail.getText();
    }

    public String getPasswordResetWithInvalidEmailText(){
        return messagePasswordResetWithInvalidEmail.getText();
    }
}


