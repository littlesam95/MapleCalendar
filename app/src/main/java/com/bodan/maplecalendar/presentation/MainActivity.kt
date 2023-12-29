package com.bodan.maplecalendar.presentation

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bodan.maplecalendar.R
import com.bodan.maplecalendar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fcv_main) as NavHostFragment
    }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.bnvMain.itemIconTintList = null

        setBottomNavigationBar()
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action != MotionEvent.ACTION_DOWN) {
            return super.dispatchTouchEvent(event)
        }


        if (this.currentFocus is EditText) {
            val outRect = Rect()
            this.currentFocus?.let {
                it.getGlobalVisibleRect(outRect)
                hideKeyboard(outRect, event, it)
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun hideKeyboard(
        outRect: Rect,
        event: MotionEvent,
        it: View
    ) {
        if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
            it.clearFocus()

            val inputMethodManager: InputMethodManager =
                this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(
                it.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    private fun setBottomNavigationBar() {
        navController = navHostFragment.navController
        navController.setGraph(R.navigation.nav_graph_main)
        binding.bnvMain.setupWithNavController(navController = navController)
    }
}