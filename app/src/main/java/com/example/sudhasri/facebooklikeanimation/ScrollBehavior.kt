package com.example.sudhasri.facebooklikeanimation

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.view.View
import android.support.v4.view.ViewCompat
import android.view.ViewGroup
import android.support.design.widget.CoordinatorLayout
import android.util.AttributeSet

class OverScrollBounceBehavior : CoordinatorLayout.Behavior<View> {

    private var mOverScrollY: Int = 0

    constructor() {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, directTargetChild: View, target: View, nestedScrollAxes: Int): Boolean {
        mOverScrollY = 0
        return true
    }

    override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
        if (dyUnconsumed == 0) {
            return
        }

        mOverScrollY -= dyUnconsumed
        val group = target as ViewGroup
        val count = group.childCount
        for (i in 0 until count) {
            val view = group.getChildAt(i)
            view.translationY = mOverScrollY.toFloat()
        }
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, child: View, target: View) {
        val group = target as ViewGroup
        val count = group.childCount
        for (i in 0 until count) {
            val view = group.getChildAt(i)
            ViewCompat.animate(view).translationY(0f).start()
        }
    }
}