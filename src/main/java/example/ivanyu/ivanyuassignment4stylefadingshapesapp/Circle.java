package example.ivanyu.ivanyuassignment4stylefadingshapesapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


/**
 * This class allows circles of random parameters (radius, positioning, and color) to be created, allowing
 * these circles to be eventually drawn on the screen based on these values.
 * @author Ivan Yu
 * @created 6/29/2016
 */
class Circle extends Shape{
    /**
     * As the variable names suggest, radius will be the randomly generated radius of the circle,
     * xPosition will be the lateral position of the Circle's center in the canvas's x-y coordinates, and
     * yPosition will be the vertical position of the Circle's center in the canvas's x-y coordinates.
     * The style variable specifies the type of color combination the circle gets.
     */
    float radius;
    float xPosition;
    float yPosition;
    Paint paint;
    int style;

    /**
     * This passes the context argument to the constructor of its parent class, Shape. The Shape's
     * constructor class also passes the context argument to the constructor of the View class.
     * @param context - this parameter is used as an argument for the constructor of the Shape class.
     *                  It will eventually be the current activity of the application when the Circle
     *                  constructor is called in this program.
     *   @param style - This will specify the type of colors the circle gets.
     */
    Circle(Context context, int style){
        super(context);
        this.style = style;
    }

    /**
     * This method returns the CIRCLE value contained in the ShapeType enum of the parent class Shape.
     * @return - CIRCLE value of the parent class Shape's enum datafield, ShapeType.
     */
    @Override
    ShapeType getShapeType() {
        return ShapeType.CIRCLE;
    }


    /**
     * This method gets called when the Circle object is added as a view in the relative layout in the MainActivity class.
     * It allows a circle to be created in  such a way that it is drawn on the screen based on random parameters such as
     * radius and the lateral and vertical positions of the Circle's center relative to the canvas. This method ensures that
     * no parts of the circle exceeds the boundary of the canvas and the screen, and therefore, the whole circle will always
     * be drawn within the canvas.
     * @param canvas - This parameter is the canvas in which the shape will be drawn.
     */
    @Override
    public void onDraw(Canvas canvas){

        /**
         * borderLength will be the size of the border, area will be the total area of the circle without the border.
         * canvasHeight is the total vertical length of the canvas, and canvasWidth is the total lateral width of the canvas.
         */
        float borderLength;
        float area;
        float canvasHeight = canvas.getHeight();
        float canvasWidth = canvas.getWidth();
        do{
            //These are the vertical and lateral position of the circle's center in the canvas. It is randomized.
            yPosition = (float) Math.random() * canvasHeight;
            xPosition = (float) Math.random() * canvasWidth;

            // The max value of the radius will be the higher of the two depending on the user's device: the height or width of the canvas.
            float randomRadiusBound = ((canvasHeight > canvasWidth) ? canvasHeight : canvasWidth);
            radius = (float) (Math.random() * randomRadiusBound);

            // if the radius causes the circle to have parts exceeding beyond the screen, a new one will be generated so that the whole circle is in the screen.
            while (radius > (canvasHeight - yPosition) || radius > (canvasWidth - xPosition) || radius > xPosition || radius > yPosition || radius == 0) {
               radius = (float) (Math.random() * randomRadiusBound);
            }

            // The borderLength will be proportional to the size of the circle divided by 16.
            area = (float) (2*Math.PI*radius);
            borderLength = area/16f;

            // Total size of the shape with the border should not allow the shape to go beyond the sides of the canvas. Also, the borders should always be smaller than the actual shape.
        }while((borderLength+xPosition+radius)>canvasWidth||(xPosition-radius-borderLength)<0||(borderLength+yPosition+radius)>canvasHeight||(yPosition-radius-borderLength)<0
                || (borderLength+radius)>(2*radius));

        // The shape's border and fill will be colored according to the current style.
        paint = new Paint();
        switch (style) {
            case 0:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.RED);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.BLACK);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 1:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.BLUE);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.YELLOW);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 2:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.CYAN);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.BLUE);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 3:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.GREEN);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.RED);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 4:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.MAGENTA);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.RED);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 5:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.RED);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.YELLOW);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
            case 6:

                // This is for the fill color.
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(Color.YELLOW);
                canvas.drawCircle(xPosition, yPosition, radius, paint);

                // This is for the border color.
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(borderLength);
                paint.setColor(Color.BLUE);
                canvas.drawCircle(xPosition, yPosition, radius, paint);
                break;
        }

    }
}
