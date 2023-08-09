package date.picker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static date.picker.DateHelper.getDateDifferenceInMonths;
import static date.picker.DateHelper.getDayFromDate;

public class DatePicker {
    @FindBy(css="a.ui-datepicker-prev")
    private WebElement prevArrow;

    @FindBy(css="a.ui-datepicker-next")
    private WebElement nexArrow;

    @FindBy(css = "div.ui-datepicker-title")
    private WebElement currentMonthTitle;

    @FindBy(css = "a.ui-state-default")
    private List<WebElement> listOfDays;

    @FindBy(id = "datepicker")
    private WebElement datePickerField;

    public DatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void openDatePicker() {
        datePickerField.click();
    }

    public void setDate(String dateToSelect) {
        String currentMonthFromDatePicker = currentMonthTitle.getText();
        long differenceBetweenMonths = getDateDifferenceInMonths(dateToSelect, currentMonthFromDatePicker);
        int dayToSet = getDayFromDate(dateToSelect);

        selectMonth(differenceBetweenMonths);
        selectDay(dayToSet);
    }

    public String getSelectedDate() {
        return datePickerField.getAttribute("value");
    }

    private void selectDay(int dayToSet) {
        for (WebElement dayToSelect : listOfDays) {
            if (Integer.parseInt(dayToSelect.getText()) == dayToSet) {
                dayToSelect.click();
                break;
            }
        }
    }

    private void selectMonth(long differenceBetweenMonths) {
        WebElement arrowToClick = selectArrow(differenceBetweenMonths);
        differenceBetweenMonths = Math.abs(differenceBetweenMonths);
        for (int month = 0; month < differenceBetweenMonths; month++) {
            arrowToClick.click();
                    }

    }

    private WebElement selectArrow(long differenceBetweenMonths) {
        WebElement arrowToClick = null;
        if (differenceBetweenMonths >= 0) {
            arrowToClick = nexArrow;
        } else {
            arrowToClick = prevArrow;
        }
        return arrowToClick;
    }
}
