package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class DrawingPage extends BasePage {

    public static final Duration NO_TIME = Duration.ofSeconds(1);
    private static final Duration STEP_DURATION = Duration.ofSeconds(1);
    public String drawingText = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView";

    public DrawingPage(AppiumDriver driver) {
        super(driver);
    }
    private Point getPointOnCircle (int step, int totalSteps, Point origin, double radius) {
        double theta = 1 * Math.PI * ((double)step / totalSteps);
        int x = (int)Math.floor(Math.cos(theta) * radius);
        int y = (int)Math.floor(Math.sin(theta) * radius);
        return new Point(origin.x + x, origin.y + y);
    }
    private void drawCircle (AppiumDriver driver, Point origin, double radius, int steps) {
        Point firstPoint = getPointOnCircle(0, steps, origin, radius);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence circle = new Sequence(finger, 0);
        circle.addAction(finger.createPointerMove(NO_TIME, PointerInput.Origin.viewport(), firstPoint.x, firstPoint.y));
        circle.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        for (int i = 1; i < steps + 1; i++) {
            Point point = getPointOnCircle(i, steps, origin, radius);
            circle.addAction(finger.createPointerMove(STEP_DURATION, PointerInput.Origin.viewport(), point.x, point.y));
        }
        circle.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(circle));
    }
    public void drawSmile(int x, int y, int radius, int steps) {
        Point head = new Point(540, 960);
        head.move(x, y);

        drawCircle(driver, head, radius, steps);
    }
    public void drawLine(int startX, int startY, int endX, int endY, int speed) {
        isVisibleByXpath(drawingText);
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", startX, "startY", startY,
                "endX", endX, "endY", endY,
                "speed", speed));
    }
}