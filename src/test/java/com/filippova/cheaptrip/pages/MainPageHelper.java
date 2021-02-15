package com.filippova.cheaptrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPageHelper extends PageBase {

    private static final String TRIP_PANEL_XPATH = "//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-offer/ion-content/ion-grid/ion-row[2]/ion-col/ion-item[1]/mat-accordion/mat-expansion-panel";

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

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-0-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityFrom;

    @FindBy(xpath = "//*[@id=\"main-content\"]/app-places/ion-tabs/div/ion-router-outlet/app-discover/ion-content/ion-card/ion-card-content/ion-grid/ion-row[1]/ion-col[2]/ion-item/ion-input/input")
    WebElement toLine;

    @FindBy(xpath = "//ion-item//ion-label[@id='ion-input-1-lbl']//..//..//ion-item//ion-list")
    WebElement submitCityTo;

    @FindBy(css = "ion-select.select.md.in-item.hydrated")
    WebElement selectCurrency;

    @FindBy(xpath = "//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/ion-item[2]")
    WebElement usd;

    @FindBy(xpath = "//*[contains(@class,\"sc-ion-popover-md-h sc-ion-popover-md-s select-popover md hydrated\")]/div[2]/div[2]/ion-select-popover/ion-list/ion-radio-group/*")
    List<WebElement> currencyList;

    @FindBy(css = "ion-button.ion-color-primary")
    WebElement letsGoButton;

    @FindBy(xpath = TRIP_PANEL_XPATH)
    WebElement foldedTripPanel;

    @FindBy(xpath = TRIP_PANEL_XPATH + "/div/div/app-details/ion-list/*/ion-label/p[3]/span[3]")
    List<WebElement> tripSegments;

    @FindBy(xpath = TRIP_PANEL_XPATH + "/mat-expansion-panel-header/span[1]/mat-panel-description/p/span[3]/ion-badge")
    WebElement totalTripPrice;

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
        waitUntilElementVisible(submitCityFrom, 5);
        submitCityFrom.click();
    }

    public void fillInToTypeForm(String textInput) {
        toLine.click();
        inputTextToField(toLine, textInput);
        waitUntilElementVisible(submitCityTo, 5);
        submitCityTo.click();
    }

    public void selectUSD() {
        selectCurrency.click();
        waitUntilElementVisible(usd, 3);
        currencyList.get(1).click();
    }

    public void clickOnLetsGoButton() {
        letsGoButton.click();
    }

    public boolean checkSumOfTrip() {
        float sumOfSegments = 0f;
        for (WebElement segmentPriceElement : tripSegments) {
            sumOfSegments += getPriceValue(segmentPriceElement.getText());
        }
        float total = getPriceValue(totalTripPrice.getText());
        return sumOfSegments == total;
    }

    public void unfoldTripPanel() {
        waitUntilElementVisible(foldedTripPanel, 3);
        foldedTripPanel.click();
    }

    private float getPriceValue(String priceAsString) {
        return Float.parseFloat(priceAsString.substring(1));
    }
}
