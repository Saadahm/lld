package SnakeAndFoodGameDesign;

public class FoodFactory {
   public static Food generateFood(int []position, String type)
    {
        if(type.equals("bonus"))
            return new BonusFood(position[0],position[1]);
        else
            return new NormalFood(position[0],position[1]);
    }
}
