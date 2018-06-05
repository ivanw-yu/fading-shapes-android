package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * This class provides a method for instantiating circle and rectangle objects.
 * @author Ivan Yu
 * @created 6/29/2016
 */
public class ShapeFactory extends AbstractShapeFactory {

    // This integer data field will represent a color combination the ShapeFactory object makes.
    int style;

    /**
     * This creates a ShapeFactory object assigned with an integer representing a color combination.
     * @param style - This integer parameter represents a color combination used by the program.
     */
    public ShapeFactory(int style) {
        this.style = style;
    }

    /**
     * This method creates and returns a Circle or Rectangle object as specified by the shape String argument.
     * By calling the Circle and Rectangle classes' constructor, this method also calls these classes'
     * onDraw method, thereby automatically drawing a Circle or Rectangle onto the screen.
     *
     * @param context - This context parameter is passed onto a constructor of the Circle or Rectangle class.
     * @param shape - This String value specified whether a Circle or Rectangle object is created and returned.
     *
     * @return - The return value is either a Circle or Rectangle object, which comes from classes that
     *           extends the abstract Shape class.
     */
    public Shape getShape(Context context, String shape){
        if(shape.equalsIgnoreCase("Circle")){
            return new Circle(context, style);
        }
        if(shape.equalsIgnoreCase("Rectangle")){
            return new Rectangle(context, style);
        }
        return null;
    }
}
