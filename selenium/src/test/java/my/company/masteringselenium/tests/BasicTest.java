package my.company.masteringselenium.tests;

import my.company.masteringselenium.DriverBase;
import my.company.masteringselenium.page_objects.EditorPage;
import my.company.masteringselenium.page_objects.HerokuPage;
import org.testng.SkipException;
import org.testng.annotations.Test;

/**
 * task#3
 * ---------------
 * 1. goto http://the-internet.herokuapp.com/
 * 2. go to Frames >  iFrame
 * 3. Remove all text from editor,
 * 4. type-in 2 lines of your custom text (line1, line2) into the editor.
 * 5. Make 1st line of text bold
 * 6. create file with screenshot
 * 7. make test skipped (i.e. test should be executed but should have status 'skipped')
 */

public class BasicTest extends DriverBase {

    @Test
    public void makeEditorTest() {
        new HerokuPage().open("http://the-internet.herokuapp.com/")
                .clickOnLinkWithText("Frames")
                .clickOnLinkWithText("iFrame");
        new EditorPage().clear()
                .type("first first first\n" + "second second second")
                .makeFirstRowBold()
                .captureScrenshot();
        throw new SkipException("skip");
    }
}