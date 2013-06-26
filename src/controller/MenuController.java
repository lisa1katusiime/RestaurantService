package controller;

import model.Menu;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:11 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MenuController {
    @Autowired
    ServletContext servletContext;

    private Menu menu;
    private Menu menu2;
    private Menu menu3;

    List<Menu> dishes = new ArrayList<Menu>();

    public MenuController(){
        menu = new Menu("Sweets", "1,500", "friedBeedPicture");
        menu2 = new Menu("Turkish Foods", "15,000", "friedBeedPicture");
        menu3 = new Menu("Desert", "5,000", "friedBeedPicture");
    }

    @RequestMapping(value = "/dishNameDisplay", method = RequestMethod.GET, headers = {"Accept=application/xml"})
    @ResponseBody
    public String renderMenuName(Map<Object, String> menuMap) {
        menuMap.put("sea foods", menu.toString());
        menuMap.put("Turkish Foods", menu2.toString());
        menuMap.put("Desert", menu3.toString());
        return "sea foods";
    }

    @RequestMapping(value = "/dishName", method = RequestMethod.GET, headers = {"Accept=application/xml"})
    @ResponseBody
    public String renderDishAsXml() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<menu><dish>"+ menu.getDishName() +"<price>" + menu.getDishPrice() +"</price></dish></menu>";
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET, headers = {"Accept=application/xml"})
    @ResponseBody
    public String renderDishesAsXml() {
        List<Menu> dishes = new ArrayList<Menu>();
        Menu dish1 = new Menu("Sweets", "5,000", "sweetsPicture");
        dishes.add(dish1);
        Menu dish2 = new Menu("Fried Beef", "25,000", "friedBeefPicture");
        dishes.add(dish2);
        Menu dish3 = new Menu("Dessert", "5,000", "dessertPicture");
        dishes.add(dish3);

        String expectedResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> " + "<menu>" ;
        for(Menu dish: dishes){
            expectedResult += "<dish>" + dish.getDishName() + "<price>" + dish.getDishPrice() + "</price><url>" + dish.getDishPictureUrl() + "</url></dish>";

        }
        return expectedResult + "</menu>";
    }

    @RequestMapping( value = "/picture/1.jpeg", method = RequestMethod.GET , produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] renderPicture() throws IOException {
        String picturePath = "WEB-INF/pages/images/food.jpeg";
        return getPicture(picturePath);
    }

    public byte[] getPicture(String path) throws IOException{
        InputStream resourceAsStream;
        resourceAsStream = servletContext.getResourceAsStream(path);
        return IOUtils.toByteArray(resourceAsStream);
    }
}
