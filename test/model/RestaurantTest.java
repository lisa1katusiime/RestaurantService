package model;

import model.Restaurant;
import org.junit.Test;

import java.awt.*;
import java.awt.Menu;
import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 12:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestaurantTest {
    @Test
    public void should_return_restaurant_name(){
        Restaurant restaurant = new Restaurant("Lisa1Restaurant");
        assertThat(restaurant.toString(), is("Lisa1Restaurant"));
    }

    @Test
    public void should_return_first_dish_in_the_menu(){

       model.Menu dish1 = new model.Menu("Sea Food", "1500","friedBeed Picture");
        ArrayList<model.Menu> menus = new ArrayList<model.Menu>();
        menus.add(dish1);
        assertThat(menus.get(0).toString(), is("Sea Food"));
    }
}
