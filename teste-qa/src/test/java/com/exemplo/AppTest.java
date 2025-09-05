package com.exemplo;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AppTest {
    @Test
    public void loginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/");
        assert driver.getTitle().equals("Swag Labs");

        //Teste de usuário e senha
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Entao
        assert driver.getCurrentUrl().equals("https://www.saucedemo.com/v1/inventory.html");
        assert driver.findElement(By.id("shopping_cart_container")).isDisplayed();


        driver.quit();



    }
}
