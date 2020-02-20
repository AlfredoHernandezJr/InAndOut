package cs134.miracosta.edu.ahernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView ;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.ahernandez.model.Order;

public class OrderActivity extends AppCompatActivity {

    // Instance variables.
    private Order order ;

    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault()) ;

    // Links to the TextViews.
    private TextView doubleDoubleTextView ;
    private TextView cheeseburgerTextView ;
    private TextView frenchFriesTextView ;
    private TextView shakesTextView ;
    private TextView smallDrinkTextView ;
    private TextView mediumDrinkTextView ;
    private TextView largeDrinkTextView ;

    // Will hold the altered TextViews' text based on local currency.
    private String doubleDoublePriceText ;
    private String cheeseburgerPriceText ;
    private String frenchFriesPriceText ;
    private String shakesPriceText ;
    private String smallPriceText ;
    private String mediumPriceText ;
    private String largePriceText ;

    // Holds the user's order.
    private EditText doubleDoubleEditText ;
    private EditText cheeseburgerEditText ;
    private EditText frenchFriesEditText ;
    private EditText shakesEditText ;
    private EditText smallDrinkEditText ;
    private EditText mediumDrinkEditText ;
    private EditText largeEditEditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState) ;
        setContentView(R.layout.activity_order) ;

        // TextView linking for the order activity.
        doubleDoubleTextView = findViewById(R.id.doubleDoubleTextView) ;
        cheeseburgerTextView = findViewById(R.id.cheeseburgerTextView) ;
        frenchFriesTextView = findViewById(R.id.frenchFriesTextView) ;
        shakesTextView = findViewById(R.id.shakesTextView) ;
        smallDrinkTextView = findViewById(R.id.smallDrinkTextView) ;
        mediumDrinkTextView = findViewById(R.id.mediumDrinkTextView) ;
        largeDrinkTextView = findViewById(R.id.largeDrinkTextView) ;

        // EditText linking for the order activity.
        doubleDoubleEditText = findViewById(R.id.doubleDoubleEditText) ;
        cheeseburgerEditText = findViewById(R.id.cheeseburgerEditText) ;
        frenchFriesEditText = findViewById(R.id.frenchFriesEditText) ;
        shakesEditText = findViewById(R.id.shakesEditText) ;
        smallDrinkEditText = findViewById(R.id.smallDrinkEditText) ;
        mediumDrinkEditText = findViewById(R.id.mediumDrinkEditText) ;
        largeEditEditText = findViewById(R.id.largeDrinkEditText) ;

        // Initialize a default Order object.
        order = new Order() ;

        // Display the price of the food based on local currency.
        doubleDoublePriceText = doubleDoubleTextView.getText().toString() + " " +  currency.format(order.getPriceDoubleDouble()) ;
        doubleDoubleTextView.setText(doubleDoublePriceText) ;

        cheeseburgerPriceText = cheeseburgerTextView.getText().toString() + " " + currency.format(order.getPriceCheeseburger()) ;
        cheeseburgerTextView.setText(cheeseburgerPriceText) ;

        frenchFriesPriceText = frenchFriesTextView.getText().toString() + " " + currency.format(order.getPriceFrenchFries()) ;
        frenchFriesTextView.setText(frenchFriesPriceText) ;

        shakesPriceText = shakesTextView.getText().toString() + " " + currency.format(order.getPriceShake()) ;
        shakesTextView.setText(shakesPriceText) ;

        smallPriceText = smallDrinkTextView.getText().toString() + " " + currency.format(order.getPriceSmallDrink()) ;
        smallDrinkTextView.setText(smallPriceText) ;

        mediumPriceText = mediumDrinkTextView.getText().toString() + " " + currency.format(order.getPriceMediumDrink()) ;
        mediumDrinkTextView.setText(mediumPriceText) ;

        largePriceText = largeDrinkTextView.getText().toString() + " " + currency.format(order.getPriceLargeDrink()) ;
        largeDrinkTextView.setText(largePriceText) ;
    }

    /**
     * Will send the entered order over to the summary activity.
     * @param v The current screen the user is interacting with.
     */
    public void placeOrder(View v)
    {
        // Hold entered amount of items.
        int doubleDoubles ;
        int cheeseburgers ;
        int frenchFries ;
        int shakes ;
        int smallDrinks ;
        int mediumDrinks ;
        int largeDrinks ;

        // Safely gets the entered quantities of food.
        try {
            // Parses an entered double number then converts it into a valid int.
            doubleDoubles = (int) (Double.parseDouble(doubleDoubleEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            doubleDoubles = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            cheeseburgers = (int) (Double.parseDouble(cheeseburgerEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            cheeseburgers = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            frenchFries = (int) (Double.parseDouble(frenchFriesEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            frenchFries = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            shakes = (int) (Double.parseDouble(shakesEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            shakes = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            smallDrinks = (int) (Double.parseDouble(smallDrinkEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            smallDrinks = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            mediumDrinks = (int) (Double.parseDouble(mediumDrinkEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            mediumDrinks = 0 ;
        }
        try {
            // Parses an entered double number then converts it into a valid int.
            largeDrinks = (int) (Double.parseDouble(largeEditEditText.getText().toString())) ;
        } catch(NumberFormatException e) {
            largeDrinks = 0 ;
        }

        // Creates and loads up the intent.
        Intent intent = new Intent(this, SummaryActivity.class) ;

        intent.putExtra("DoubleDoubles", doubleDoubles) ;
        intent.putExtra("Cheeseburgers", cheeseburgers) ;
        intent.putExtra("FrenchFries", frenchFries) ;
        intent.putExtra("Shakes", shakes) ;
        intent.putExtra("SmallDrinks", smallDrinks) ;
        intent.putExtra("MediumDrinks", mediumDrinks) ;
        intent.putExtra("LargeDrinks", largeDrinks) ;

        /** Starts up the next activity. */
        startActivity(intent) ;
    }
}
