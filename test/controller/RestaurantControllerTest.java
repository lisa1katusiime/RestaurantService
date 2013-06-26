package controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestaurantControllerTest {
    @InjectMocks
    RestaurantController restaurantController;
    Map<Object, String> restaurantMap;

    @Mock
    model.Restaurant restaurantMock;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_render_restaurant_name_correctly(){
        restaurantMap = new HashMap<Object, String>();
        assertThat(restaurantController.render(restaurantMap), is("restaurant"));
    }

    @Test
    public void should_be_able_to_show_post_as_xml(){
        when(restaurantMock.toString()).thenReturn("Istanbul Restaurant");
        String expectedMessage = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<restaurant><name>Istanbul Restaurant</name></restaurant>";

        String actualMessage = restaurantController.renderXml();
        assertThat(actualMessage,is(expectedMessage));
    }
}


