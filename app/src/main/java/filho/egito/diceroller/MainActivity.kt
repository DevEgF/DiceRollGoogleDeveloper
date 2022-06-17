package filho.egito.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val toastRoller = Toast.makeText(this, "Dice Rolled!!!", Toast.LENGTH_SHORT)

        rollButton.setOnClickListener {
            rollDice()
            toastRoller.show()
            rollDice()
        }
    }

    //Roll the dice and update the screen with the result
    private fun rollDice() {
        //Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Update the screen with the dice roll
        //        val resultTextView: TextView = findViewById(R.id.textView)
        //        resultTextView.text = diceRoll.toString()
        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        // val determine which drawable resouce ID to use base on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Update the ImageView with the correct drawable resoucer ID
        diceImage.setImageResource(drawableResource)
        //Update the contente Description
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
