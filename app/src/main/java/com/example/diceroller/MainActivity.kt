package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the Layout
        val rollButton: Button = findViewById(R.id.button)

        // Set on clickListener to roll the button when Button is tab
        rollButton.setOnClickListener {rollDice()}

    }

    private fun rollDice() {
       val firstDiceRoll = Dice(6)
        val diceRoll = firstDiceRoll.roll()
       val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable ID is used when the dice id rolled
       val drawableResource = when(diceRoll) {

           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
       }
        // Update the imageView withe the correct resource id
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
    private class Dice (val numSides: Int) {
        //Do a random dice roll and return a result
        fun roll(): Int{
            return (1..numSides).random()
        }
    }
}