package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.Vector;

/**
 * The MainActivity class creates the buttons and its functions,
 * and ultimately, the shapes in the screen. This class also provides
 * methods for updating and displaying the count of rectangles and circles,
 * and removing shapes from the shape vector and the screen.
 *
 * @author Ivan Yu
 * @created 6/29/2016
 */
public class MainActivity extends AppCompatActivity {

    /**
     * shapeVector stores all the created shapes, shapeCount refers to the xml file's text view displaying the counts of the shapes,
     * relativeLayout refers to the xml file's relative layout which will display the shapes, and shapeFactory will initialize the circles and rectangles.
     * currentStyle will be the integer representation of the current color combination style which the new shapes will have.
     */
    static Vector<Shape> shapeVector;
    static TextView shapeCount;
    RelativeLayout relativeLayout;
    ShapeFactory shapeFactory;
    static int currentStyle = 0;

    /**
     * This method hides the action bar from the screen, initializes the text view and buttons of the activity and
     * assign each buttons its functions.
     * @param savedInstanceState - This is the only parameter of the onCreate method.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This removes the action bar from the screen.
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        // shapeCount is the TextView that displays the counts of rectangles and circles. The shapeVector will contain created circles and rectangles.
        shapeCount = (TextView) findViewById(R.id.text);
        shapeVector = new Vector<Shape>();
        // The relativeLayout is the RelativeLayout set in the xml file where the shapes will be drawn.
        relativeLayout = (RelativeLayout) findViewById(R.id.canvas);
        updateShapesCount();
        // These Shape Factories makes shapes of different colors. Using the final modifier allows me to reference these within the style button's onClick method.
        final ShapeFactory sfRedBlack = AbstractShapeFactory.getShapeFactory(0);
        final ShapeFactory sfBlueYellow = AbstractShapeFactory.getShapeFactory(1);
        final ShapeFactory sfCyanBlue = AbstractShapeFactory.getShapeFactory(2);
        final ShapeFactory sfGreenMagenta = AbstractShapeFactory.getShapeFactory(3);
        final ShapeFactory sfMagentaRed = AbstractShapeFactory.getShapeFactory(4);
        final ShapeFactory sfRedYellow = AbstractShapeFactory.getShapeFactory(5);
        final ShapeFactory sfYellowBlue = AbstractShapeFactory.getShapeFactory(6);
        // shapeFactory creates the shapes, and it initially makes red and black colored shapes.
        shapeFactory = sfRedBlack;
        // These buttons are respectively for creating circles, creating rectangles, and erasing all shapes on the screen.
        Button circleButton = (Button) findViewById(R.id.circle);
        Button rectButton = (Button) findViewById(R.id.rect);
        Button styleButton = (Button) findViewById(R.id.style);
        Button clearButton = (Button) findViewById(R.id.clear);

        circleButton.setOnClickListener(new View.OnClickListener(){
            /**
             * This method decrements the alphas of each shapes, removes the shapes
             *  that aren't visible from the vector, creates and adds a new circle to
             *  the shape vector, and then updates the number of shapes.
             * @param v - This parameter refers to the view clicked to trigger the onClick method,
             *           which is the circleButton.
             */
            @Override
            public void onClick(View v){
                // The alphas of the shapes are decreased, then a created circle is stored in the vector, and then the shape count is updated.
                adjustShapeAlpha();
                shapeVector.add(shapeFactory.getShape(v.getContext(), "Circle"));
                relativeLayout.addView(shapeVector.lastElement());
                updateShapesCount();
            }
        });
        rectButton.setOnClickListener(new View.OnClickListener(){
            /**
             *  This method decreases the alphas of all shapes in the shapeVector,
             *  creates a new rectangle and stores it in the vector, and then
             *  updates the count of the shapes.
             * @param v- This parameter refers to the view clicked to call this onClick method,
             *           which is the rectangleButton.
             */
            @Override
            public void onClick(View v){
                // The alphas of each shapes are decremented, then a new rectangle is added to the vector, and finally, the shape count is updated.
                adjustShapeAlpha();
                shapeVector.add(shapeFactory.getShape(v.getContext(), "Rectangle"));
                relativeLayout.addView(shapeVector.lastElement());
                updateShapesCount();
            }
        });
        styleButton.setOnClickListener(new View.OnClickListener() {
            /**
             * This changes the current color style of the shapes being made.
             * @param v - the parameter is the button that was clicked, the styleButton.
             */
            @Override
            public void onClick(View v){
                // currentStyle incremented, all new shapes will have the color mix corresponding to the currentStyle integer.
                currentStyle++;

                // currentStyle can only range from 0 to 6. If it is 6 when the style button is clicked, it resets to 0.
                if(currentStyle>6){
                    currentStyle = 0;
                }

                // shapeFactory, which ultimately creates the shapes, becomes a factory that makes shapes with colors corresponding to the currentStyle integer.
                switch(currentStyle){
                    case 0:
                        shapeFactory = sfRedBlack;
                        break;
                    case 1:
                        shapeFactory = sfBlueYellow;
                        break;
                    case 2:
                        shapeFactory = sfCyanBlue;
                        break;
                    case 3:
                        shapeFactory = sfGreenMagenta;
                        break;
                    case 4:
                        shapeFactory = sfMagentaRed;
                        break;
                    case 5:
                        shapeFactory = sfRedYellow;
                        break;
                    case 6:
                        shapeFactory = sfYellowBlue;
                        break;
                }
                // updateShapesCount() is called to also update the color style displayed by the text view.
                updateShapesCount();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener(){
            /**
             * This method makes all the shapes in the shapeVector invisible,
             * removes the shapes from the shapeVector, and then resets the shape count to 0.
             * @param v - This parameter refers to the clearButton, which upon clicked,
             *            calls this onClick method.
             */
            @Override
            public void onClick(View v){
                // removeShape() is called for every shape in the vector, making these shapes invisible.
                for(Shape shape : shapeVector){
                    shape.removeShape();
                }
                // All shapes are removed from the shapeVector, and the shape counts are reset to 0.
                shapeVector.clear();
                updateShapesCount();
            }
        });
    }

    /**
     * This method traverses through the shapes in the shape vector, lowering each of the
     * shapes' alpha. If the shape's alpha is greater than 0f (meaning that the shape is still visible),
     * the shape will be maintained, otherwise if the shape is no longer visible, the shape will be
     * removed from the shape vector and made invisible. A temporary shape vector local variable
     * is made to assist with the shape removals.
     */
    void adjustShapeAlpha(){
        // This temporary Shape vector will first hold all of the visible shapes in the original shapeVector.
        Vector<Shape> temp = new Vector<Shape>();
        for(Shape shape : shapeVector){
            shape.setShapeAlpha(shape.getShapeAlpha()-.1f);
            // Visible shapes are added to the temporary Shape vector.
            if(shape.getShapeAlpha()>.1f){
                temp.add(shape);
            }else{
                // if the shape's alpha is less than or equal to .1f, the shape's visibility is disabled, and the shape isn't added to the temporary vector.
                shape.removeShape();
            }
        }

        // The temp vector has less entries than shapeVector if there's a shape that's invisible in shapeVector, which will not be included in the updated shapeVector.
        if(temp.size()!=shapeVector.size()){
            // The shapeVector is first cleared, and then set to the temporary Shape vector, which holds only visible shapes.
            shapeVector.clear();
            shapeVector = temp;
        }
    }

    /**
     * This method traverses through the shape vector, counting the number of rectangles and circles and then
     * updating the rectangle and circle counts on the top of the screen appropriately according to the numbers
     * counted through the traversal.
     */
    void updateShapesCount(){

        // The number of circles and rectangles are 0 before the traversal. colorCombo will be the name of the color mix currently used.
        int numCircles = 0;
        int numRectangles = 0;
        String colorCombo = "";

        // This allows the name of the color combination being used to be displayed on the screen.
        switch(currentStyle){
            case 0:
                colorCombo = "RED-BLACK";
                break;
            case 1:
                colorCombo = "BLUE-YELLOW";
                break;
            case 2:
                colorCombo = "CYAN-BLUE";
                break;
            case 3:
                colorCombo = "GREEN-RED";
                break;
            case 4:
                colorCombo = "MAGENTA-RED";
                break;
            case 5:
                colorCombo = "RED-YELLOW";
                break;
            case 6:
                colorCombo = "YELLOW-BLUE";
                break;
        }

        // This traverses through the shapeVector and counts the number of circles and rectangles.
        for(Shape shape : shapeVector){
            if(shape.getShapeType() == Shape.ShapeType.CIRCLE){
                numCircles++;
            }
            if(shape.getShapeType() == Shape.ShapeType.RECTANGLE){
                numRectangles++;
            }
        }

        // This updates the display of the counts of rectangles and circles.
        shapeCount.setText(numRectangles + " Rectangles, " + numCircles + " Circles, Style:" + currentStyle + " " +  colorCombo);
    }

}
