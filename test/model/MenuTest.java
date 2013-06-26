package model;

import org.junit.Test;

import java.awt.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuTest {
    @Test
    public void represent_in_string() {
        Menu menu = new Menu("Fried Beef", "25,000.00", "friedBeefPicture");
        String result = menu.toString();
        assertThat(result, is("Fried Beef\n25,000.00\nfriedBeefPicture"));
    }
}
