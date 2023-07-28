import org.junit.jupiter.api.Test;

public class DrawingTest extends BaseTest {

    @Test
    void drawingFace() {

        basePage.clickSideBarButton();
        basePage.clickButtonByUI(basePage.sideBarDrawingButton);
        drawingPage.drawLine(400,600,400,800,999);
        drawingPage.drawLine(680,600,680,800,999);
        drawingPage.drawLine(540,820,540,900,999);
        drawingPage.drawSmile(540, 960, 300, 15);
    }
}