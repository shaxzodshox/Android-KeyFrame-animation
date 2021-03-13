package com.shakhzod.app

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var isInfoLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout.setOnClickListener {
            if(isInfoLayout)
                swapLayout(R.layout.activity_main)
            else
                swapLayout(R.layout.activity_main_info)
        }
    }

    private fun swapLayout(layoutId: Int){
        val constraintSet = ConstraintSet()
        constraintSet.clone(this, layoutId)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator(1.0f)
        transition.duration = 1000

        TransitionManager.beginDelayedTransition(constraintLayout, transition)
        constraintSet.applyTo(constraintLayout)

        isInfoLayout = !isInfoLayout
    }
}
