package org.blankfactor.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class BasePage {

  public SelenideElement letsTalkButton() { return $(".contact-btn-wrap");}

  public SelenideElement navigationBar() { return $(".navbar__nav");}

  public SelenideElement heroSlider() { return $(".hero-slider-wrap");}

  public SelenideElement navigationMenu() { return $("#menu-main-menu");}

  public SelenideElement insightsOption() { return navigationMenu().$(Selectors.byText("Insights"));}

}
