package kr.ac.kumoh.s20181259.week0501carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kr.ac.kumoh.s20181259.week0501carddealer.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val model:CardViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //1
        //val c = getCardName(29)//29 : 하트4
        //binding.card1.setImageResource(R.drawable.c_10_of_spades)


        //2
        /*binding.btn1.setOnClickListener{
            val res = IntArray(5)
            for(i in 0 until res.size) {
                res[i] = resources.getIdentifier(
                    getCardName(Random.nextInt(52)),
                    "drawable",
                    packageName
                )
            }
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])*/

        //3
        model.cards.observe(this, Observer<IntArray>{
            val res = IntArray(5)
            for(i in 0 until res.size) {
                res[i] = resources.getIdentifier(
                    getCardName(it[i]),
                    "drawable",
                    packageName
                )
            }
            binding.card1.setImageResource(res[0])
            binding.card2.setImageResource(res[1])
            binding.card3.setImageResource(res[2])
            binding.card4.setImageResource(res[3])
            binding.card5.setImageResource(res[4])
        })

        binding.btn1.setOnClickListener{
            model.deal()
        }
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
        Log.i("number of getCardName: ", num)
        return "c_${num}_of_${shape}"
    }
}