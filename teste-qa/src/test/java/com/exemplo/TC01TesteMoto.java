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
import org.openqa.selenium.support.ui.Select;

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

    //Teste com os campos preenchidos
    @Test
    public void AddTest() {
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

        // Preenche os campos do formulário
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modelo"))).sendKeys("HONDA CB 500X");
        driver.findElement(By.id("placa")).sendKeys("ABD-9876");
        Select statusSelect = new Select(wait.until(
        ExpectedConditions.elementToBeClickable(By.id("status"))
        ));
        statusSelect.selectByVisibleText("Em manutenção");

        // Salva preenchendo os campos
        WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-primary[type='submit']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSalvar); 

        //Valida o sucesso
        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/motos?sucesso=true"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/motos?sucesso=true", driver.getCurrentUrl());

    } finally {
        driver.quit();
    }
    }

    //Teste para preencher os campos - Perfil
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

        // Gestão de perfil
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Perfil"))).click();

        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/usuario"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/usuario", driver.getCurrentUrl());

        // Valida título
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Perfil do Usuário')]")
        ));

        // Preenche os campos do formulário
        WebElement nome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nomeCompleto")));
        nome.clear();
        nome.sendKeys("Pedro Henrique Gonçalves Gomes");

        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("pedro.gomes.10@outlook.com.br");

        WebElement telefone = driver.findElement(By.id("telefone"));
        telefone.clear();
        telefone.sendKeys("11966100100");

        // Clica no botão "Salvar alterações"
        WebElement btnSalvar = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.btn.btn-success[type='submit']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnSalvar);

        // Valida mensagem de sucesso
        WebElement alertaSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[contains(@class, 'alert-success') and contains(normalize-space(), 'Perfil atualizado com sucesso!')]")
        ));

        Assertions.assertTrue(alertaSucesso.isDisplayed());
        Assertions.assertEquals("Perfil atualizado com sucesso!", alertaSucesso.getText().trim());

    } finally {
        driver.quit();
    }
    }

    @Test
    public void ProfileExistTest() {
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

        // Gestão de perfil
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Perfil"))).click();

        wait.until(ExpectedConditions.urlToBe("https://challengejavasprint3.onrender.com/usuario"));
        Assertions.assertEquals("https://challengejavasprint3.onrender.com/usuario", driver.getCurrentUrl());

        // Valida título
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Perfil do Usuário')]")
        ));

    } finally {
        driver.quit();
    }
    }



}

