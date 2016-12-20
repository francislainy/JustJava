/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        Log.v("MainActivity", "The Price is " + price);
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.notify_me_checkbox)).isChecked();
        Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);
        String priceMessage = createOrderSummary(price, hasWhippedCream);
       // String message = "She said \"1 dollar\"";
        displayMessage(priceMessage);
    }

    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String priceMessage =  "Name = Fran Campos";
        priceMessage+= "\nAdd whipped cream? ";
        priceMessage+= hasWhippedCream;
        priceMessage+= "\nQuantity =" + quantity;
        priceMessage+= "\nTotal: £" + price + "\nThank you!";

        return priceMessage;
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity--;
        if(quantity < 0)//Denying negative numbers to appear on the screen
            quantity = 0;
        displayQuantity(quantity);
    }

}