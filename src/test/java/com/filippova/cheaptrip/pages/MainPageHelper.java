package com.filippova.cheaptrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageHelper extends PageBase {

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".hide-xs.md.title-default.hydrated")
    WebElement slogan;

    @FindBy(css = "ion-buttons.select.buttons-last-slot.sc-ion-buttons-md-h.sc-ion-buttons-md-s.md.hydrated")
    WebElement selectLang;

    @FindBy(css = "ion-item.select-interface-option")
    List<WebElement> langList;

    @FindBy(id = "ion-rb-38-lbl")
    WebElement russianLanguage;

    @FindBy(tagName = "ion-card-title")
    WebElement title;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-discover/ion-content/ion-card/ion-card-content/ion-grid/ion-row[1]/ion-col[1]/ion-item/ion-input/input")
    WebElement fromLine;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-discover/ion-content/ion-card/ion-card-content/ion-grid/ion-row[1]/ion-col[2]/ion-item/ion-input/input")
    WebElement toLine;

    @FindBy(css = "ion-select.select.md.in-item.hydrated")
    WebElement selectCurrency;

    @FindBy(xpath = "//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/ion-item[2]")
    WebElement usd;

    @FindBy(xpath = "//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/*")
    List<WebElement> currencyList;

    public boolean isSloganContainsText(String text) {
        return slogan.getText().contains(text);
    }

    public void selectRussianLanguage() {
        selectLang.click();
        waitUntilElementVisible(russianLanguage, 3);
        langList.get(1).click();
    }

    public boolean isLanguageOnPageRussian(String text) {
        return title.getText().contains(text);
    }

    public void fillInFromTypeForm(String textInput) {
        fromLine.click();
        inputTextToField(fromLine, textInput);
    }

    public void fillInToTypeForm(String textInput) {
        toLine.click();
        inputTextToField(toLine, textInput);
    }

    public void selectUSD() {
        selectCurrency.click();
        waitUntilElementVisible(usd, 3);
        currencyList.get(1).click();
    }
}
