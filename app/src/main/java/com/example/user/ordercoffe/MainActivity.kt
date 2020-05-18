package com.example.user.ordercoffe
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.text.NumberFormat

/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {
    private var quantity:Int=0
    private var price=50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * This method is called when the order button is clicked.
     */
    fun incOrder(view: View) {
        displayQuantity(++quantity)
        displayPrice(quantity*price)
    }
    fun decOrder(view: View) {
        displayQuantity(--quantity)
        displayPrice(quantity*price)
    }
    fun submitOrder(view: View){
        val text = "Order Successfully Placed!"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
        displayQuantity(quantity)
        displayMessage("Total: ${NumberFormat.getCurrencyInstance().format(quantity*price)}\nThank You!")
        quantity=0
        displayQuantity(0)
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(number: Int) {
        val quantityTextView = findViewById<View>(R.id.quantity_text_view) as TextView
        quantityTextView.text = "" + number
    }

    private fun displayPrice(number: Int) {
        val summaryTextView = findViewById<TextView>(R.id.summary_text_view)
        summaryTextView.text = NumberFormat.getCurrencyInstance().format(number)
    }
    private fun displayMessage(message:String){
        val messageTextView=findViewById<View>(R.id.summary_text_view) as TextView
        messageTextView.text=message
    }
}