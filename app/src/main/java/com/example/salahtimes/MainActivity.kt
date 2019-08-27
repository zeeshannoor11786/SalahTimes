package com.example.salahtimes

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntRange
import android.widget.Toast
import com.example.salahtimes.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ISalatView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SalatPresenter(this).getDataFromApi("malé")



    }

    override fun onDataCompleteFromAPi(salat: Item) {

        val connectivityManager = baseContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        val isConnected: Boolean = activeNetwork?.isConnected == true
        if (activeNetwork?.isConnected == true) {
            // connected to internet
            fajar.text = salat.fajr
            duhar.text = salat.dhuhr
            asar.text = salat.asr
            Magrib.text = salat.maghrib
            isha.text = salat.isha

            Toast.makeText(baseContext, "Connected to WIFI Network", Toast.LENGTH_SHORT).show()
        }
        else
        {


            Toast.makeText(baseContext, "NOT Connected to WIFI Network", Toast.LENGTH_SHORT).show()
            this.finish()

        }


    }
    override fun onDataErrorFromApi(throwable: Throwable) {
        error("Error------->${throwable.localizedMessage}")
        Toast.makeText(this, "Error ${throwable.localizedMessage}", Toast.LENGTH_LONG).show()

    }


    public override fun onPause() {
        super.onPause()
        setContentView(R.layout.activity_main_display)
        this.setContentView(R.layout.activity_main_display)
    }

}
