package controller;

import model.Restaurant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:06 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class RestaurantController {
    private Restaurant restaurant;

    public RestaurantController(){
        restaurant = new Restaurant("Lisa1Restaurant");
    }

    @RequestMapping(value = "/restaurantName", method = RequestMethod.GET)
    public String render(Map<Object, String> restaurantMap) {
        restaurantMap.put("restaurant", restaurant.toString());
        return "restaurant";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers = {"Accept=application/xml"})
    @ResponseBody
    public String renderXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<restaurant><name>"+ restaurant +"</name></restaurant>";
    }

    public String renderMenuDishes(){

        return "<menu><dish>" + "</dish><restaurant>";
    }
}
