package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {

    private final SelenideElement verificationHead = $(byText("Интернет Банк"));
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement verificationButton = $("[data-test-id='action-verify']");

    public void verifyPageVisibility() {
        codeField.should(Condition.visible);
    }

    public DashboardPage validVerify(DataHelper.VerificationCode verificationCode) {
        codeField.setValue(verificationCode.getCode());
        verificationButton.click();
        return new DashboardPage();
    }
}
