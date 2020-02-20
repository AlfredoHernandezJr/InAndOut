package cs134.miracosta.edu.ahernandez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.ahernandez.model.Order;

public class SummaryActivity extends AppCompatActivity {

    // Instance variables.
    private Order order ;

    // Number formats for local currency and percent.
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault()) ;
    private NumberFormat percent = NumberFormat.getPercentInstance(Locale.getDefault()) ;

    private TextView orderTotalTextView ;
    private TextView itemsOrderedTextView ;
    private TextView subtotalTextView ;
    private TextView taxTextView ;

    // Will hold the edited TextViews based on local percent and currency.
    private String orderTotalText ;
    private String itemsOrderedText ;
    private String subtotalText ;
    private String taxText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Links to the TextViews.
        orderTotalTextView = findViewById(R.id.orderTotalTextView) ;
        itemsOrderedTextView = findViewById(R.id.itemsOrderedTextView) ;
        subtotalTextView = findViewById(R.id.subtotalTextView) ;
        taxTextView = findViewById(R.id.taxTextView) ;

        // Retrieve the intent from the order activity.
        Intent intent = getIntent() ;

        // Extras passed along.
        int cheeseburgers, doubleDoubles, frenchFries,
            shakes, smallDrinks, mediumDrinks, largeDrinks ;

        // Initialize values based on first activity.
        cheeseburgers = intent.getIntExtra("Cheeseburgers", 0) ;
        doubleDoubles = intent.getIntExtra("DoubleDoubles", 0) ;
        frenchFries = intent.getIntExtra("FrenchFries", 0) ;
        shakes = intent.getIntExtra("Shakes", 0) ;
        smallDrinks = intent.getIntExtra("SmallDrinks", 0) ;
        mediumDrinks = intent.getIntExtra("MediumDrinks", 0) ;
        largeDrinks = intent.getIntExtra("LargeDrinks", 0) ;

        // Create a new order.
        order = new Order() ;

        order.setCheeseburgers(cheeseburgers) ;
        order.setDoubleDoubles(doubleDoubles) ;
        order.setFrenchFries(frenchFries) ;
        order.setShakes(shakes) ;
        order.setSmallDrinks(smallDrinks) ;
        order.setMediumDrinks(mediumDrinks) ;
        order.setLargeDrinks(largeDrinks) ;

        // Sets the TextViews based on the order from the OrderActivity.
        orderTotalText = orderTotalTextView.getText().toString() + " " + currency.format(order.calculateTotal()) ;
        orderTotalTextView.setText(orderTotalText) ;

        itemsOrderedText = itemsOrderedTextView.getText().toString() + " " + order.getNumberItemsOrdered() ;
        itemsOrderedTextView.setText(itemsOrderedText) ;

        subtotalText = subtotalTextView.getText().toString() + " " + currency.format(order.calculateSubtotal()) ;
        subtotalTextView.setText(subtotalText) ;

        taxText = taxTextView.getText().toString() + "(" + percent.format(order.getTaxRate()) + ") " + currency.format(order.calculateTax()) ;
        taxTextView.setText(taxText) ;
    }

    /**
     * Ends the activity and returns to the start of the app.
     * @param v current activity.
     */
    public void startNewOrder(View v)
    {
        finish() ;
    }
}
