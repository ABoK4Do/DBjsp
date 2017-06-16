package classes;

/**
 * Created by ABoK4Do on 11.05.17.
 */
public class Factory {

   // private static FoodDAO foodDAO = null;
    private static CategoryDAO categoryDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

   /* public FoodDAO getFoodDAO() {
        if (foodDAO == null) {
            foodDAO = new FoodDAO();
        }
        return foodDAO;
    }*/

    public CategoryDAO getCategoryDAO() {
        if (categoryDAO == null) {
            categoryDAO = new CategoryDAO();
        }
        return categoryDAO;
    }


}