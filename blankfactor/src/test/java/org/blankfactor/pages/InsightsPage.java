package org.blankfactor.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class InsightsPage {
  public SelenideElement blogPageItem() { return $(".page-item__info").$(Selectors.byText("Blog"));}

}
