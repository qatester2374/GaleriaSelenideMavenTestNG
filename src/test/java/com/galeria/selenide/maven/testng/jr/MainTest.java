package com.galeria.selenide.maven.testng.jr;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainTest {

    SelenideElement damenTab = $(byXpath("//a[contains(text(), 'Damen')]"));
    SelenideElement searchInput = $(byXpath("//input[@placeholder='Search products']"));
    SelenideElement allMenu = $(byXpath("//button[contains(text(), 'All menu')]"));
    SelenideElement radSport = $(byXpath("//a[contains(text(), 'Radsport')]"));
    ElementsCollection searchResultsGrid = $$("div.heluOB div.hngzF");
    ElementsCollection labelsArticle = $$("div label");
    SelenideElement quantityPlus = $(byXpath("//button[@data-testid='plusButton']"));
    SelenideElement quantityMinus = $(byXpath("//button[@data-testid='minusButton']"));
    SelenideElement counterInput = $(byName("counterInput"));
    ElementsCollection imagesGrid = $$(".ProductGallerystyled__ThumbsStyle-sc-1dr9xt-3 button");
    SelenideElement numberOfSearchElements = $(byClassName("gkk-pop-pagination__details"));
    ElementsCollection searchResultItems = $$("#search-result-items li.gkk-search-results__item");
    SelenideElement wishList = $(byId("IDTA_wishlist"));
    SelenideElement wishListIndicator = $(byId("wishlist-indicator"));
//    SelenideElement pagination = $(byClassName("gkk-pop-pagination__nav-pages-item-link"));
    SelenideElement lastPage = $(byClassName("gkk-pop-pagination__nav-icon--relative-left"));
    SelenideElement lastPageNumbers = $(byClassName("gkk-pop-pagination__nav-pages"));
    ElementsCollection lastPageNumbersElements = $$("ul .gkk-pop-pagination__nav-pages-item");
    SelenideElement filiale = $(byXpath("//span[contains(text(), 'Filiale')]"));
    SelenideElement andern = $(byXpath("//button[contains(text(), 'ndern')]"));
    SelenideElement findStore = $(byXpath("//input[@placeholder='Find store']"));
//    ElementsCollection stores = $$("div .kMuqUv");
    ElementsCollection stores = $$("div .kMuqUv .gFlvGi");
    SelenideElement closeFiliale = $(byXpath("//html/body/div[2]"));

    // registration
    SelenideElement name = $(byId("jform_name"));
    SelenideElement username = $(byId("jform_username"));
    SelenideElement password = $(byId("jform_password1"));
    SelenideElement confirmPassword = $(byId("jform_password2"));
    SelenideElement email = $(byId("jform_email1"));
    SelenideElement confirmEmail = $(byId("jform_email2"));
    SelenideElement registerSubmit = $(byXpath("//button[contains(text(), 'Register')]"));

    // login
    SelenideElement usernameLogin = $(byId("username"));
    SelenideElement passwordLogin = $(byId("password"));
    SelenideElement loginSubmit = $(byXpath("//button[contains(text(), 'Log in')]"));

    // upload
    SelenideElement galleryViewForImage = $(byXpath("//h3[contains(text(), 'Gallery View for Images')]"));
    SelenideElement fineUploaderGalleryArea = $(byId("fine-uploader-gallery"));
    SelenideElement inputUpload = $(byXpath("//*[@id=\"fine-uploader-gallery\"]/div/div[3]/input"));

    SelenideElement manualTriggerUploads = $(byXpath("//h3[contains(text(), 'Manually Trigger Uploads')]"));
    SelenideElement selectFiles = $(byXpath("//*[@id=\"fine-uploader-manual-trigger\"]/div/div[3]/div/input"));
    SelenideElement triggerUpload = $(byId("trigger-upload"));

    // prompt
    SelenideElement prompt = $(byName("prompt"));

    // gigatron
    SelenideElement searchInputField = $(byXpath("//input[@type='text']"));
    SelenideElement countSearchItems = $(byXpath("//*[@id=\"searchcontent\"]/div/div/div[2]/div/div[1]/div/h1/p"));
    ElementsCollection gridProducts = $$("#grid-products div.product-item-css");
    SelenideElement newsletter = $(byXpath("//label[contains(text(), 'Prijava za newsletter')]"));

    // mikroknjiga
    SelenideElement cenovnikLink = $(byXpath("//a/font[contains(text(), 'Cenovnik')]"));
    ElementsCollection cenovnikTabela = $$("body > table > tbody > tr:nth-child(2) > td > table tbody tr td a");
    SelenideElement addukorpu = $(byId("addukorpu"));

    // list
    SelenideElement processor = $(byClassName("tag_processor"));
    SelenideElement motherboard = $(byClassName("tag_motherboard"));
    SelenideElement loadingSpinner = $(byXpath("//div[@class='loading']"));
    ElementsCollection listOfComponents = $$("#inner-content-div ul li");

    public SelenideElement searchElementContainsText(String str) {
        SelenideElement element = $(byXpath("//img[contains(@alt,'" + str + "')]"));
        return element;
    }

    public Integer countElements(String id) throws InterruptedException {
        Thread.sleep(2000);
        ElementsCollection myElementList = $$("#" + id);
        return myElementList.size();
//        if (myElementList.size() > 0) {
//            click(mobileElement);
//        }
    }

    @BeforeTest
    void beforeTest() {
//        Configuration.browser = "Firefox";
//        open("https://www.galeria.de/");
//        Configuration.headless = true;
    }

    @Test
    void todoGaleria() throws InterruptedException {
//        open("https://www.galeria.de/");
        open("https://galeria.stage.galeria.bestbytes.net/", "", "demo", "dfLr8dY7e7ZJJmtqwAJtVQZiGHNiUZ9gNssMjK4rHTFFaTeUd6");
        open("https://galeria.stage.galeria.bestbytes.net/");
        Thread.sleep(2000);
        damenTab.hover();
        Thread.sleep(1000);
//        $(withText("Jacken & Mantel")).shouldBe(Condition.visible);

        allMenu.click();
        $(radSport).scrollIntoView(true).click();
        Thread.sleep(5000);
//        $(withText("Radsport")).shouldBe(Condition.visible);
//        $(By.className("heluOB")).waitUntil(Condition.visible, 30000);
        System.out.println(searchResultsGrid.size());
        Assert.assertTrue(searchResultsGrid.size() > 0);

        $(searchResultsGrid.get(0)).scrollIntoView(true);
        searchResultsGrid.get(0).hover();
        Thread.sleep(1000);
        $(withText("more items available")).shouldBe(Condition.visible);

        searchResultsGrid.get(1).hover();
        $(withText("more items available")).shouldBe(Condition.visible);
        searchResultsGrid.get(0).click();
        Thread.sleep(1000);
        System.out.println("labels: " + labelsArticle.size());
        for (int i = 0; i < labelsArticle.size(); i++) {
            labelsArticle.get(i).click();
            Assert.assertTrue(labelsArticle.get(i).getText().contains("label for"));
        }
        quantityPlus.click();
        quantityPlus.click();
        quantityMinus.click();
        quantityPlus.click();
        counterInput.sendKeys("-200");
        counterInput.clear();
        counterInput.sendKeys("23");

        Thread.sleep(1000);

        System.out.println("images: " + imagesGrid.size());

        for (int i = 0; i < imagesGrid.size(); i++) {
            imagesGrid.get(i).hover();
        }

        Thread.sleep(3000);

//        searchInput.sendKeys("Citizen");
//        searchInput.pressEnter();
//        searchInput.click();
        System.out.println(searchResultItems.size());
//        searchElementContainsText("CA0690-88L").click();
//        wishList.click();
//        wishListIndicator.shouldHave(text("1"));
//        Assertions.assertEquals(1, Integer.valueOf(wishListIndicator.getText()));
//        System.out.println(numberOfSearchElements.getText());

//        String[] elements = numberOfSearchElements.getText().split(" ");
//        System.out.println(elements.length);
//        System.out.println(elements[elements.length - 1]);
//        Assert.assertTrue(Integer.valueOf(elements[elements.length - 1]) > 0);
//
//        lastPage.click();
//        Thread.sleep(3000);
//
//        System.out.println(lastPageNumbersElements.size());

        zoom(2.0);
        Thread.sleep(1000);
        zoom(0.1);
        Thread.sleep(1000);
        zoom(1.0);
        Thread.sleep(1000);

        filiale.click();

        localStorageAssert("Berlin");

        andern.shouldBe(Condition.visible);
        andern.click();

        localStorageAssert("Krefeld");

        localStorage().clear();

        closeFiliale.click();
        refresh();
        Assert.assertEquals(localStorage().getItem("site"), null);

        Thread.sleep(4000);
    }

    void localStorageAssert(String term) {
        findStore.sendKeys(term); // Krefeld term
        findStore.pressEnter();
        String firstItem = stores.get(0).getText();
        System.out.println("Stores 1st item: " + firstItem);
        stores.get(0).click();
        System.out.println("LOCAL STORAGE1: " + localStorage().getItem("site"));
        JSONObject jsonObject1 = new JSONObject(localStorage().getItem("site"));
        Assert.assertTrue(firstItem.equals(jsonObject1.getJSONObject("favoriteStore").get("name")));
    }

    @Test
    void register() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/registration-form");
        name.sendKeys("Joca");
        username.sendKeys("joca");
        password.sendKeys("12345");
        confirmPassword.sendKeys("1234");
        email.sendKeys("hilimi6347@herrain.com");
        confirmEmail.sendKeys("hilimi6347@herrain.com");
        registerSubmit.click();
        Thread.sleep(3000);
    }

    @Test
    void login() throws InterruptedException {
        open("http://demo.t3-framework.org/joomla30/index.php/en/joomla-pages/sample-page-2/login-page");
        usernameLogin.sendKeys("joca");
        passwordLogin.sendKeys("12345");
        loginSubmit.click();
        Thread.sleep(3000);
    }

    @Test
    void uploadImage1() throws InterruptedException {
        open("https://fineuploader.com/demos.html");
//        fineUploaderGalleryArea.scrollIntoView(true);
        galleryViewForImage.scrollTo();
        inputUpload.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        Thread.sleep(3000);
    }

    @Test
    void uploadImage2() throws InterruptedException {
        open("https://fineuploader.com/demos.html");
        galleryViewForImage.scrollTo();
        inputUpload.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        Thread.sleep(1000);
        manualTriggerUploads.scrollTo();
        selectFiles.sendKeys("C:/Users/gabor/Pictures/bananas-1326090.jpg");
        triggerUpload.click();
        Thread.sleep(1000);
    }

    @Test
    void searchArticle1() throws InterruptedException {
        open("https://gigatron.rs/");
//        switchTo().innerFrame();
        searchInputField.sendKeys("ssd");
        searchInputField.pressEnter();
        System.out.println(countSearchItems.getText());
        String[] splited = countSearchItems.getText().split("\\s+");
        System.out.println("splitted: " + splited[0]);
        Integer x = Integer.valueOf(splited[0]);
        Assert.assertTrue(x > 0);
        Thread.sleep(1000);
        gridProducts.get(23).scrollIntoView(true);
        Thread.sleep(1000);
        for (int i = 23; i < Integer.valueOf(splited[0]); i += 4) {
//            System.out.println(i);
            gridProducts.get(i).scrollIntoView(true);
            Thread.sleep(50);
        }
        System.out.println("gridProducts size: " + gridProducts.size());
        Integer y = Integer.valueOf(gridProducts.size());
        Assert.assertTrue(x.intValue() == y.intValue());
        Thread.sleep(3000);
    }

    void otvoriCenovnik() throws InterruptedException {
        cenovnikLink.click();
        Thread.sleep(500);
        System.out.println(cenovnikTabela.size());
        Integer max = cenovnikTabela.size();
        Integer min = 0;
        int randomNum = new Random().nextInt(max - min + 1) + min;
        System.out.println(randomNum);
        cenovnikTabela.get(randomNum).click();

        System.out.println(countElements("addukorpu"));
        if (countElements("addukorpu") > 0) {
            addukorpu.click();
            refresh();
        } else {
            $(withText("RASPRODATO")).shouldBe(Condition.visible);
            otvoriCenovnik();
        }
    }

    @Test
    void articleInBasket() throws InterruptedException {
        open("https://www.mikroknjiga.rs/");

        otvoriCenovnik();

        Thread.sleep(3000);
    }

    @Test
    void configuration() throws InterruptedException {
        open("http://www.list.rs/gaming/konfigurator");
        motherboard.click();
        ElementsCollection spinner = $$("#config_list .loading");
        System.out.println(spinner.size());
        System.out.println("Number of elements in the list: " + listOfComponents.size());
        Thread.sleep(30000);
        System.out.println(spinner.size());
    }

    void test() {
        System.out.println("main");
    }
}
