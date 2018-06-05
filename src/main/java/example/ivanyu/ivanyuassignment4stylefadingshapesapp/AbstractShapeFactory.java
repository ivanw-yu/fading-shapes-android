package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

/**
 * This class returns a new ShapeFactory with a given color style.
 * Created by ivanyu on 7/9/16.
 */
public abstract class AbstractShapeFactory {
    /**
     * This method creates and returns a ShapeFactory that creates shapes having a specific color combination.
     * @param style - This parameter specifies the color combination the shape factory will produce.
     * @return - a ShapeFactory that creates shapes of specific color combination will be returned.
     */
   public static ShapeFactory getShapeFactory(int style){
        return new ShapeFactory(style);
    }
}