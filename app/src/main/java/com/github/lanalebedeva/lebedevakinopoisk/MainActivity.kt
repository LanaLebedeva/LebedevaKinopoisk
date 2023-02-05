package com.github.lanalebedeva.lebedevakinopoisk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.lanalebedeva.lebedevakinopoisk.topfilms.PopularMoviesFragment


private lateinit var fragmentPopularMoviesFragment: PopularMoviesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentPopularMoviesFragment = PopularMoviesFragment()
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.main_fragmentContainer,
                    fragmentPopularMoviesFragment,
                    "fragmentPopularMoviesFragment"
                )
                .addToBackStack(null)
                .commit()
        } else {
            fragmentPopularMoviesFragment =
                supportFragmentManager.findFragmentByTag("fragmentPopularMoviesFragment") as PopularMoviesFragment
        }
    }
}
