package com.example.sudhasri.facebooklikeanimation

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity(), PostListAdapter.OnItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val postList = resources.getStringArray(R.array.posts).toList()
        recyclerView.adapter = PostListAdapter(postList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)


        /*frame = findViewById<FrameLayout>(R.id.root)
        container = ExampleContainerView(this)
        rootContainer = findViewById(R.id.root_container)
        findViewById<Button>(R.id.button).setOnClickListener {
            container?.addView(SpringScrollViewExample(this))
            mAnimating = true
            frame?.addView(container)
            container?.postDelayed(Runnable {
                container?.reveal(true, object : ExampleContainerView.Callback {
                    override fun onProgress(progress: Double) {
                        val scale = SpringUtil.mapValueFromRangeToRange(progress,
                                0.0, 1.0, 0.8, 1.0).toFloat()
                        rootContainer?.setScaleX(scale)
                        rootContainer?.setScaleY(scale)
                        rootContainer?.setAlpha(progress.toFloat())
                    }

                    override fun onEnd() {
                        mAnimating = false
                    }
                })
            }, 100)
        }*/

    }

    /* override fun onBackPressed() {
         if (mAnimating || container == null) {
             return
         }
         mAnimating = true
         container?.hide(true, object : ExampleContainerView.Callback {
             override fun onProgress(progress: Double) {
                 val scale = SpringUtil.mapValueFromRangeToRange(progress, 0.0, 1.0, 0.8, 1.0).toFloat()
                 rootContainer?.setScaleX(scale)
                 rootContainer?.setScaleY(scale)
                 rootContainer?.setAlpha(progress.toFloat())
             }

             override fun onEnd() {
                 mAnimating = false
                 container?.clearCallback()
                 frame?.removeView(container)
                 container = null
             }
         })
     }*/

    override fun onItemClick() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        transaction
                .add(android.R.id.content, CommentsDialog())
                .addToBackStack(null)
                .commit()
//        val dialog = CommentsDialog()
//        dialog.enterTransition =Fade()
//        dialog.exitTransition = Fade()
//        dialog.show(supportFragmentManager, CommentsDialog::class.java.simpleName)

    }
}
