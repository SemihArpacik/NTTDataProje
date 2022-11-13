package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NTTPages {

    public NTTPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    public WebElement formsCart;

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceFormsButton;

    @FindBy (id = "firstName")
    public WebElement firstnameTextBox;

    @FindBy(id ="lastName")
    public WebElement lastnameTextBox;

    @FindBy(id ="userEmail")
    public WebElement emailTextBox;

    @FindBy(id ="gender-radio-1")
    public WebElement maleButton;

    @FindBy(id ="userNumber")
    public WebElement mobilNumberTextBox;

    @FindBy(id ="dateOfBirthInput")
    public WebElement date;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    public WebElement mounth;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    public WebElement year;

    @FindBy(xpath = "(//div[text()='16'])[1]")
    public WebElement day;

    @FindBy(id ="hobbies-checkbox-3")
    public WebElement musicButton;

    @FindBy(id ="uploadPicture")
    public WebElement selectFile;

    @FindBy(id ="currentAddress")
    public WebElement addressTextBox;

    @FindBy(xpath ="//div[@class='modal-content']")
    public WebElement popUp;

    @FindBy (id = "closeLargeModal")
    public  WebElement closeButton;




}
