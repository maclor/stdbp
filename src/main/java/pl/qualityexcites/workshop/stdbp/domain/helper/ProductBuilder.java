package pl.qualityexcites.workshop.stdbp.domain.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pl.qualityexcites.workshop.stdbp.domain.Product;
import pl.qualityexcites.workshop.stdbp.helpers.Color;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class ProductBuilder {

    private static By nameBy = By.xpath(".//*[@itemprop='name']");
    private static By priceBy = By.xpath(".//*[contains(@class,'right-block')]//*[@itemprop='price']");
    private static By fullPriceBy = By.cssSelector(".right-block .old-price");
    private static By discountBy = By.cssSelector(".right-block .price-percent-reduction");
    private static By colorBy = By.className("color_pick");

    public static Product buildProductFromWebElement(WebElement productElement) {
        Product product = new Product();

        product.setName(getName(productElement));
        product.setPrice(getPrice(productElement));
        Float fullPrice = getFullPrice(productElement);
        product.setFullPrice(fullPrice);

        Integer discount = getDiscount(productElement);
        product.setDiscount(discount);

        List<Color> colors = getColors(productElement);
        if (!isNull(colors) || !colors.isEmpty()) {
            product.setAvailableColors(colors);
        }

        return product;
    }

    private static Integer getDiscount(WebElement productElement) {
        try {
            String discountString = productElement.findElement(discountBy).getText();
            if (discountString.isEmpty())
                return null;
            return Integer.parseInt(discountString.trim().replace("%", "").replace("-", ""));
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    private static float getPrice(WebElement productElement) {
        return Float.parseFloat(productElement.findElement(priceBy).getText().trim().replace("$", ""));
    }

    private static Float getFullPrice(WebElement productElement) {
        try {
            WebElement fullPriceElement = productElement.findElement(fullPriceBy);
            String fullPriceString = fullPriceElement.getText();
            if (fullPriceString.isEmpty())
                return null;
            return Float.parseFloat(fullPriceString.trim().replace("$", ""));
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    private static String getName(WebElement productElement) {
        return productElement.findElement(nameBy).getText();
    }

    private static List<Color> getColors(WebElement productElement) {
        List<Color> colorsList = new ArrayList<>();

        for (WebElement colorPicker : productElement.findElements(colorBy)) {
            String rgb = colorPicker.getCssValue("background-color").replace("rgb", "").replace(" ", "").trim();
            Color color = Color.getColorForRgb(rgb);
            if (!isNull(color)) {
                colorsList.add(color);
            }
        }

        return colorsList;
    }
}
