package com.bodan.maplecalendar.presentation.views

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
import com.bodan.maplecalendar.databinding.ActivityCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {

    private val viewModel: CharacterViewModel by viewModels()
    private lateinit var binding: ActivityCharacterBinding
    private lateinit var navController: NavController
    private val navHostFragment: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fcv_character) as NavHostFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = viewModel
        binding.lifecycleOwner = this
        binding.bnvCharacter.itemIconTintList = null

        setBottomNavigationBar()
        viewModel.initState()
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
        navController.setGraph(R.navigation.nav_graph_character)
        binding.bnvCharacter.setupWithNavController(navController = navController)
    }
}