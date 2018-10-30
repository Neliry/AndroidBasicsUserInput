package com.example.maria.lesson_6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_cream_check_box);
        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate_check_box);
        int price = calculatePrice(quantity, 5, whippedCreamCheckBox.isChecked(), chocolateCheckBox.isChecked());
        EditText name_editText=(EditText)findViewById(R.id.name_edit_text);
        String message= getString(R.string.order_summary_name, name_editText.getText().toString()) +
                "\n" + getString(R.string.order_summary_whipped_cream,  whippedCreamCheckBox.isChecked())  +
                "\n"+ getString(R.string.order_summary_chocolate, chocolateCheckBox.isChecked()) +
                "\n"+ getString(R.string.order_summary_quantity, quantity) +
                "\n"+ getString(R.string.order_summary_price, NumberFormat.getCurrencyInstance(Locale.US).format(price))+
                "\n"+ getString(R.string.thank_you) ;
        String subject=getString(R.string.order_summary_email_subject, name_editText.getText().toString()) ;
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity    is the number of cups of coffee ordered
     * @param pricePerCup is the price of one cup of coffee
     */
    private int calculatePrice(int quantity, int pricePerCup, boolean checkWhippedCream, boolean checkChocolate) {
        if(checkWhippedCream)
            pricePerCup++;
        if(checkChocolate)
            pricePerCup+=2;
        return quantity * pricePerCup;
    }

    public void increment(View view) {
        if (quantity < 100){
            quantity += 1;
            displayQuantity(quantity);
            return;
        }
        Toast.makeText(this, "You can not have mare than 100 coffees!", Toast.LENGTH_SHORT).show();
    }

    public void decrement(View view) {
        if (quantity > 1){
            quantity -= 1;
            displayQuantity(quantity);
            return;
        }
        Toast.makeText(this, "You can not have less than 1 coffee!", Toast.LENGTH_SHORT).show();
    }
}
