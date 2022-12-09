package com.example.chi_12_di

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.Component
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerBattleComponent.create()
        val war = component.war
        war?.prepare()
        war?.report()
    }
}

@Component
internal interface BattleComponent {
    val war: War?
}

interface House {
    fun prepareForWar()
    fun reportForWar()
}

class Boltons @Inject constructor() : House {

    override fun prepareForWar() {
        // что-то происходит
        Log.d("ttt", "${this.javaClass.simpleName} prepared for war");
    }

    override fun reportForWar() {
        // что-то происходит
        Log.d("ttt", "${this.javaClass.simpleName} reporting..");
    }


}


class Starks @Inject constructor() : House {

    override fun prepareForWar() {
        // что-то происходит
        Log.d("ttt", "${this.javaClass.simpleName} prepared for war");
    }

    override fun reportForWar() {
        // что-то происходит
        Log.d("ttt", "${this.javaClass.simpleName} reporting..");
    }


}

class War @Inject constructor(private val starks :Starks, private val boltons :Boltons) {

    fun prepare(){
        starks.prepareForWar();
        boltons.prepareForWar();
    }

    fun report(){
        starks.reportForWar();
        boltons.reportForWar();
    }
}

