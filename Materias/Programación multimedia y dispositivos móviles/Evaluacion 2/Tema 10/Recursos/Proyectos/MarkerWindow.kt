package com.example.adaptersv.mapa

import android.content.Intent
import android.os.Build
import android.widget.Button
import android.widget.TextClock
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.adaptersv.OSMActivity
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.infowindow.InfoWindow
import com.example.adaptersv.R

class MarkerWindow(private val mapView: MapView, private val title: String): InfoWindow(R.layout.info_window, mapView)
{

    override fun onOpen(item: Any?)
    {
        // Following command
        closeAllInfoWindowsOn(mapView)

        val tvTitulo = mView.findViewById<TextView>(R.id.text_view_pin)
        tvTitulo.text = title

        val tvDesc = mView.findViewById<TextView>(R.id.text_view_descripcion)
        tvDesc.text = "Descripción de la actividad"

        val btn = mView.findViewById<Button>(R.id.close_button)

        btn.setOnClickListener {
            mView.isActivated = false
        }
    }

    override fun onClose()
    {

    }

}