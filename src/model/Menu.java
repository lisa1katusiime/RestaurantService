package model;

/**
 * Created with IntelliJ IDEA.
 * User: lisa
 * Date: 6/26/13
 * Time: 1:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Menu {
    private String dishName;
    private String dishPrice;
    private String dishPictureUrl;

    public Menu(String dishName, String dishPrice, String dishPictureUrl) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishPictureUrl = dishPictureUrl;
    }

    @Override
    public String toString(){
        return this.getDishName() + "\n" + this.getDishPrice() + "\n" + this.dishPictureUrl;
    }

    public String getDishPrice() {
        return dishPrice;
    }

    public String getDishName() {
        return dishName;
    }

    public String getDishPictureUrl() {
        return dishPictureUrl;
    }
}
