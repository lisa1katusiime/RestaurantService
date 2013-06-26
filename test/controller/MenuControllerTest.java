package controller;

import model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class MenuControllerTest {
    @InjectMocks
    MenuController menuController;
    Map<Object, String> menuMap;

    @Mock
    Menu menuMock;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_render_menu_name_correctly(){
        menuMap = new HashMap<Object, String>();
        assertThat(menuController.renderMenuName(menuMap), is("sea foods"));
    }

    @Test
    public void should_be_able_to_render_dish_as_xml(){
        when(menuMock.getDishName()).thenReturn("Sea Foods");
        when(menuMock.getDishPrice()).thenReturn("1,500");

        String expectedMenu = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<menu><dish>Sea Foods<price>1,500</price></dish></menu>";
        assertThat(menuController.renderDishAsXml(), is(expectedMenu));

        verify(menuMock).getDishName();
        verify(menuMock).getDishPrice();
    }

    @Test
    public void should_be_able_render_dishes_as_xml(){
        Menu dish1 = new Menu("Sweets", "5,000", "friedBeefPicture");
        Menu dish2 = new Menu("Fried Beef", "25,000", "friedBeefPicture");
        Menu dish3 = new Menu("dessert", "5,000", "friedBeefPicture");

        String expectedResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<menu><dish>Sweets<price>5,000</price><url>sweetsPicture</url></dish><dish>Fried Beef<price>25,000</price><url>friedBeefPicture</url></dish><dish>Dessert<price>5,000</price><url>dessertPicture</url></dish></menu>";
        assertThat(expectedResult, is(menuController.renderDishesAsXml()));
    }
}
