package kr.ac.kumoh.s20181259.week0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.ac.kumoh.s20181259.week0501carddealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getCardName(29)//29 : 하트4

        binding.card1.setImageResource(R.drawable.c_10_of_spades)
    }

    private fun getCardName(c: Int): String{
        val shape = when (c/13){
            0 -> "spades"
            1 -> "diamonds"
            2 -> "hearts"
            3 -> "clubs"
            else -> "error"
        }
        val num = when (c%13){
            0 -> "ace"
            in 1..9 -> (c%13+1).toString()
            10 -> "jack"
            11 -> "queen"
            12 -> "king"
            else -> "error"
        }


        Log.i("input of getCardName: ", (c).toString())
        Log.i("shape of getCardName: ", shape)
        Log.i("number of getCardName: ", num.toString())



        return "c_ace_of_spades"
    }
}