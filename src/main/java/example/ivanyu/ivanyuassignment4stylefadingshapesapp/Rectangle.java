package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * This class allows rectangles to be created such that it is drawn in the screen according to
 * random boundaries. The topmost, bottommost, leftmost and rightmost positions
 * of the rectangle are randomly generated, though this class ensures that the rectangles'
 * parts never goes beyond the screen's boundaries. Also, the rectangle is drawn with
 * a different colored border.
 *
 * @author Ivan Yu
 * @created 6/29/2016
 */
class Rectangle extends Shape{

    //These floats represent the position of the top, bottom, left and right sides of the rectangle on the layout.
    float topPosition;
    float bottomPosition;
    float leftPosition;
    float rightPosition;
    // These will be used to determine the color of the rectangle.
    Paint paint;
    int style;

    /**
     * This passes the context argument to the constructor of its parent class, Shape. The Shape's
     * constructor class also passes the context argument to the constructor of the View class.
     * @param context - this parameter is used as an argument for the constructor of the Shape class.
     *                  The current activity of the application will be used as the argument to be passed
     *                  to this constructor once this constructor is invoked in the program.
     * @param style -  This specifies the color combination of the rectangle.
     */
    Rectangle(Context context, int style){
        super(context);
        this.style = style;
    }

    /**
     * This method returns the value of RECTANGLE contained within the
     * ShapeType enum data field of the Shape abstract class.
     * @return - a ShapeType value of RECTANGLE is returned.
     */
    @Override
    ShapeType getShapeType() {
        return ShapeType.RECTANGLE;
    }

    /**
     * This method assigns the attributes to the rectangle. The rectangle's parts will never
     * exceed beyond its canvas's boundaries. The height and width of the rectangle
     * is randomly generated by the topPosition, bottomPosition, leftPosition and rightPosition
     * data fields, which respectively represents the rectangle's topmost, bottommost, leftmost,
     * and rightmost positions within the canvas (the canvas has its x and y coordinates where
     * (0,0) is the top leftmost corner). Also, the rectangle will be filled with a color that
     * is different from the color of its border.
     * @param canvas - this parameter is the canvas to which the rectangle will be drawn.
     */
    @Override
    public void onDraw(Canvas canvas){

        // borderLength is the size of the border. canvasHeight and canvasWidth are the height and width of the canvas.
        float borderLength;
        float canvasHeight = canvas.getHeight();
        float canvasWidth = canvas.getWidth();
        do {
            // This generates a random number, but if this number is 0, a new random number is generated until the number isn't 0.
            float randomNotZero = (float) Math.random();
            while (randomNotZero == 0) {
                randomNotZero = (float) Math.random();
            }

            // bottomPosition will be randomly generated where the max is the canvas' height. Then, the topPosition will be a random number between the bottom position and the canvas' height.
            bottomPosition = randomNotZero * canvasHeight;

            // The topPosition is a value between 0 and the bottomPosition, excluding the value of bottomPosition. If topPosition gets bottomPosition's value, it gets reassigned.
            topPosition = (float) Math.random() * bottomPosition;
            while (topPosition == bottomPosition) {
                topPosition = (float) Math.random() * rightPosition;
            }

            // This generates a new random number, but if it's 0, a new number is generated until the number isn't 0.
            randomNotZero = (float) Math.random();
            while (randomNotZero == 0) {
                randomNotZero = (float) Math.random();
            }

            // The rightmost position can be any number between 0 and the canvas's width. The leftmost position of the rectangle will be a number between 0 and the rightmost position.
            rightPosition = randomNotZero * canvasWidth;

            // leftPosition cannot be the same as rightPosition, otherwise, a new random number will be assigned to the leftPosition.
            leftPosition = (float) Math.random() * rightPosition;
            while (leftPosition == rightPosition) {
                leftPosition = (float) Math.random() * rightPosition;
            }

            // The borderLength will ultimately be the smaller between lateralLength and verticalLength.
            float lateralLength = (rightPosition-leftPosition)/4;
            float verticalLength = (bottomPosition - topPosition)/4;
            borderLength = (lateralLength<verticalLength)?lateralLength:verticalLength;

            // Adding the border with the rectangle will not result in the total rectangle having parts going beyond the canvas's borders. This while-statement assures that.
        }while((borderLength+rightPosition)>canvasWidth||(leftPosition-borderLength)<0||(borderLength+bottomPosition)>canvasHeight||(topPosition-borderLength)<0);

            // These following lines of codes assigns the colors for the rectangle and draws the rectangle.
            paint = new Paint();
            switch (style) {
                case 0:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.RED);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.BLACK);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 1:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.BLUE);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.YELLOW);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 2:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.CYAN);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);

                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.BLUE);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 3:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.GREEN);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);

                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.RED);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 4:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.MAGENTA);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);

                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.RED);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 5:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.RED);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.YELLOW);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
                case 6:
                    // This is for the fill color.
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.YELLOW);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);

                    // This is for the border color.
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(borderLength);
                    paint.setColor(Color.BLUE);
                    canvas.drawRect(leftPosition, topPosition, rightPosition, bottomPosition, paint);
                    break;
            }
    }
}
