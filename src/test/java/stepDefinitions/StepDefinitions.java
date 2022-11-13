package stepDefinitions;


import com.github.javafaker.Faker;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.NTTPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.FileReader;
import java.io.IOException;

public class StepDefinitions {

    NTTPages pages = new NTTPages();
    Faker faker = new Faker();
    Actions actions=new Actions(Driver.getDriver());
    Logger log = (Logger) LogManager.getLogger(StepDefinitions.class);


    @Given("Kullanici ToolsQA anasayfasina gider")
    public void kullaniciToolsQAAnasayfasinaGider() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        log.info("url e gidildi");

    }

    @When("Anasayfanin acildigini kontrol eder")
    public void anasayfaninAcildiginiKontrolEder() throws InterruptedException {

        String sayfaUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(sayfaUrl.equals(ConfigReader.getProperty("url")));
        log.info("anasayfaya giriş yaptığı doğrulandı");


    }

    @When("Forms kartina tiklar")
    public void formsKartinaTiklar() throws InterruptedException {


        ReusableMethods.jseClick(pages.formsCart);


    }

    @When("Practice Form butonuna tiklar")
    public void practiceFormButonunaTiklar() {

        pages.practiceFormsButton.click();

    }

    @When("Acilan sayfada ilgili alanlar doldurur ve submit butonuna tiklar")
    public void acilanSayfadaIlgiliAlanlarDoldurur() {



        String firstName="";
        String lastName="";
        String eMail="";
        String address="";
        String phoneNumber="";
        String csvFile_Path="C:\\Users\\HP\\Desktop\\NTTDataProje\\TestData.csv";
        pages.firstnameTextBox.click();

        CSVReader reader = null;
        try{
            reader=new CSVReader(new FileReader(csvFile_Path));
            String[] cell;
            while ((cell= reader.readNext())!=null){
                for (int i = 0; i < 1; i++) {
                    firstName=cell[i];
                    lastName=cell[i+1];
                    eMail=cell[i+2];
                    address=cell[i+3];
                }
            }
        }catch (IOException | CsvValidationException e){
            e.printStackTrace();
        }
        pages.firstnameTextBox.sendKeys(firstName);
        log.info("firstName dolduruldu");
        pages.lastnameTextBox.sendKeys(lastName);
        log.info("lastName  dolduruldu");
        pages.emailTextBox.sendKeys(eMail);
        log.info("eMail  dolduruldu");
        ReusableMethods.jseClick(pages.maleButton);
        log.info("male butonu tıklandı");
        pages.mobilNumberTextBox.sendKeys("5555555555");
        log.info("mobil  dolduruldu");
        ReusableMethods.JSEScrollBy();
        pages.date.click();
        log.info("tarih dropdownu tıklandı");
        Select select=new Select(pages.mounth);
        select.selectByValue("6");
        log.info("ay seçildi ");
        Select select2=new Select(pages.year);
        select2.selectByVisibleText("2022");
        log.info("yıl seçildi ");
        pages.day.click();
        log.info("gun seçildi ");
        ReusableMethods.jseClick(pages.musicButton);
        log.info("music butonu tıklandı");
        String filePath= "C:\\Users\\HP\\Desktop\\doga.jpg";
        log.info("dosya yolu belirlendi ");
        pages.selectFile.sendKeys(filePath);
        log.info("dosyaseç butonuna tıklandı");
        pages.addressTextBox.sendKeys(address);
        log.info("adres bilgisi dolduruldu");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        log.info("submit butonuna tıklandı");


    }

    @When("acilan pop-up ekran goruntusu alir")
    public void acilanPopUpEkranGoruntusuAlir() throws IOException {


        ReusableMethods.waitForVisibility(pages.popUp, 5);
        log.info("pop-up bekletildi");

        ReusableMethods.JSEScrollBy();
        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
        executor.executeScript("document.body.style.zoom = '0.67'");

        ReusableMethods.getScreenshot("popUp");
        log.info("pop-up ekran görüntüsü alındı");

    }

    @When("Close butonuna tiklar")
    public void closeButonunaTiklar() throws InterruptedException {

        ReusableMethods.jseClick(pages.closeButton);
        log.info("close butonuna tıklandı");
    }

    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {

        Driver.CloseDriver();
    }
}
