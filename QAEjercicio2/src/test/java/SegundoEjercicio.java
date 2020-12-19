import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SegundoEjercicio {

    public static void main(String[] args) {

        WebDriver driver = null;

        /* Activo el navegador */
        WebDriverManager.chromedriver().version("87.0.4280.88").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        /* Busco zapatillas en amazon */
        String cadenaBusqueda = "//*[@id=\"twotabsearchtextbox\"]";
        WebElement buscar = driver.findElement(By.xpath(cadenaBusqueda));
        buscar.sendKeys("zapatillas");
        buscar.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(3000) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Obtengo la informacion de las 2 zapatillas */
        String strDescripcion1 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[2]/h2/a/span";
        String strPrecio1 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]";

        String strDescripcion2 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[4]/div/span/div/div/div/div/div[2]/h2/a/span";
        String strPrecio2 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[4]/div/span/div/div/div/div/div[4]/div/div/div/a/span";

        //String strDescuento = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[51]/div/span/div/div/div[3]/div[2]/span/span[2]/span[1]";

        WebElement oDescripcion1 = driver.findElement(By.xpath(strDescripcion1));
        WebElement oprecio1 = driver.findElement(By.xpath(strPrecio1));

        WebElement oDescripcion2 = driver.findElement(By.xpath(strDescripcion2));
        WebElement oprecio2 = driver.findElement(By.xpath(strPrecio2));

        // Determino los valores y indico cual es mas barato
        String precio1 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]";
        String precio2 = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[4]/div/span/div/div/div/div/div[4]/div/div/div/a/span/span[2]/span[2]";

        WebElement oValor1 = driver.findElement(By.xpath(precio1));
        WebElement oValor2 = driver.findElement(By.xpath(precio2));

        int valor1 = Integer.parseInt(oValor1.getText());
        int valor2 = Integer.parseInt(oValor2.getText());

        if (valor1 > valor2) {

            System.out.println("La mejor opción de compra es: " + oDescripcion2.getText());
            System.out.println(oprecio2.getText());

        } else {

            System.out.println("La mejor opción de compra es: " + oDescripcion1.getText());
            System.out.println(oprecio1.getText());

        }

        try {
            Thread.sleep(3000) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Selecciono la primera zapatilla */
        String cadenaSeleccion = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div/div/span/a/div/img";
        WebElement seleccion = driver.findElement(By.xpath(cadenaSeleccion));
        if(seleccion.isDisplayed() == false){
            System.out.println("aca");
            cadenaSeleccion = "//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/span/a/div/img";
            seleccion = driver.findElement(By.xpath(cadenaSeleccion));

        }
        seleccion.click();

    }

}
