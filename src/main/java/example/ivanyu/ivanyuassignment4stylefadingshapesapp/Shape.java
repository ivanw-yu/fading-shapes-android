package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

import android.graphics.Color;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * This abstract class is to be extended by the Circle and Rectangle class.
 * This class provides methods for making the shape invisible in the canvas, for
 * retrieving the alpha of the shape, and for setting the alpha of the shape, which
 * will all be utilized in the MainActivity class. The Shape class also has
 * 2 abstract methods: onDraw and getShapeType. These abstract methods will be implemented
 * by the Circle and Rectangle class.
 *
 * @author Ivan Yu
 * @created 6/29/2016
 */
public abstract class Shape extends View{
    /**
     * The Paint data field will be used to generate a color for the shape to be drawn.
     * This data field will be used by the Circle and Rectangle class.
     * The ShapeType enum will be used to distinguish circles and rectangles,
     * which is important for counting the number of circles and rectangles in the
     * MainActivity class.
     */
    enum ShapeType {CIRCLE, RECTANGLE};

    /**
     *  This method calls the constructor of the View class, passing the context argument to that constructor.
     * @param context - This parameter is passed onto the constructor of the View class.
     */
    Shape(Context context){
        super(context);
    }


    /**
     * This method sets the alpha of the shape.
     * @param alpha - This parameter is the alpha which the shape will have through this method.
     */
    void setShapeAlpha(float alpha){
        setAlpha(alpha);
    }

    /**
     * This returns the alpha of the shape, by using the View class's method.
     * @return - the alpha of the shape, which may be between 0f and 1.0f.
     */
    float getShapeAlpha(){
         return getAlpha();
    }

    /**
     * This makes the shape invisible in the screen.
     */
    void removeShape(){
        setVisibility(View.GONE);
    }

    /**
     * This abstract method will be implemented by the Circle and Rectangle class.
     * @return - a ShapeType value which will be CIRCLE for the Circle class and RECTANGLE for the Rectangle class.
     */
    abstract ShapeType getShapeType();

    /**
     * This abstract method will be implemented by the Circle and Rectangle class.
     * The purpose of this method is to draw the shape (Circle or Rectangle) on the screen.
     * @param canvas - This parameter is the canvas in which the shape will be drawn.
     */
    @Override
    public abstract void onDraw(Canvas canvas);
    
}

