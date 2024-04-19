package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoversPage extends BasePageObject {
  
  private By figureListLocator = By.className("figure");

  public HoversPage(WebDriver driver, Logger log) {
    super(driver, log);
  }

  public void hoverOverFigure(int index) {
    WebElement figure = findAll(figureListLocator).get(index);
    hoverOverElement(figure);
  }

  public int getNumberOfFiguresDisplayed() {
    return findAll(figureListLocator).size();
  }

  public boolean verifyFigureCaptionIsDisplayed(int index) {
    WebElement figure = findAll(figureListLocator).get(index);

  }
}
