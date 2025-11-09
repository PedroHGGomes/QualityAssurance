package com.exemplo;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TC01TesteMoto {
    //Teste para garantir a existência da página de gestão de motos
    @Test
public void loginTest() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        // Login page
        driver.get("https://challengejavasprint3.onrender.com/login");
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/login", driver.getCurrentUrl());

        // Click login with GitHub
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/oauth2/authorization/github']"))
        ).click();

        // GitHub login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).sendKeys("pedro.gomes.10@outlook.com.br");
        driver.findElement(By.id("password")).sendKeys("M@nteigadecacau1");
        driver.findElement(By.name("commit")).click();

        // Dashboard
        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/", driver.getCurrentUrl());

        // Gestão de motos
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Gestão"))).click();

        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/motos"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/motos", driver.getCurrentUrl());

        // Valida título
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Gestão de Motos')]")
        ));

        Assertions.assertTrue(
                driver.findElement(By.xpath("//h1[contains(text(),'Gestão de Motos')]")).isDisplayed()
        );

    } finally {
        driver.quit();
    }
}



    //Teste com os campos vazios
    @Test
    public void EditTest() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        // Login page
        driver.get("https://challengejavasprint3.onrender.com/login");
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/login", driver.getCurrentUrl());

        // Click login with GitHub
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/oauth2/authorization/github']"))).click();

        // GitHub login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).sendKeys("pedro.gomes.10@outlook.com.br");
        driver.findElement(By.id("password")).sendKeys("M@nteigadecacau1");
        driver.findElement(By.name("commit")).click();

        // Dashboard
        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/", driver.getCurrentUrl());

        // Gestão de motos
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Gestão"))).click();

        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/motos"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/motos", driver.getCurrentUrl());

        // Valida título
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Gestão de Motos')]")
        ));

        // Clica no botão "Adicionar Moto"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/motos/new']")
        )).click();

        // Tenta salvar sem preencher nada
        WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-primary[type='submit']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSalvar); 

        // Valida mensagem de erro
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Modelo é obrigatório']")
        ));

        Assertions.assertTrue(mensagem.isDisplayed());
        Assertions.assertEquals("Modelo é obrigatório", mensagem.getText());

    } finally {
        driver.quit();
    }
    }

    //Teste com os campos vazios - Perfil
    @Test
    public void ProfileTest() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        // Login page
        driver.get("https://challengejavasprint3.onrender.com/login");
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/login", driver.getCurrentUrl());

        // Click login with GitHub
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/oauth2/authorization/github']"))).click();

        // GitHub login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_field"))).sendKeys("pedro.gomes.10@outlook.com.br");
        driver.findElement(By.id("password")).sendKeys("M@nteigadecacau1");
        driver.findElement(By.name("commit")).click();

        // Dashboard
        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/", driver.getCurrentUrl());

        // Gestão de motos
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Gestão"))).click();

        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/motos"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/motos", driver.getCurrentUrl());

        // Valida título
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Gestão de Motos')]")
        ));

        // Clica no botão "Adicionar Moto"
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href='/motos/new']")
        )).click();

        // Tenta salvar sem preencher nada
        WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-primary[type='submit']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSalvar); 

        // Valida mensagem de erro
        WebElement mensagem = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[normalize-space()='Modelo é obrigatório']")
        ));

        Assertions.assertTrue(mensagem.isDisplayed());
        Assertions.assertEquals("Modelo é obrigatório", mensagem.getText());

    } finally {
        driver.quit();
    }
    }



}

