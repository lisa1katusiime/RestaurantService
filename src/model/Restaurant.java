package model;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 12:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Restaurant {
    private String restaurantName;

    public Restaurant(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString(){
        return this.restaurantName;
    }
}

