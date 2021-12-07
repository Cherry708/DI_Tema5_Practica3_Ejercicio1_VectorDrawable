package com.example.di_tema5_practica2_ejercicios_keepnotes

import android.annotation.SuppressLint
import android.graphics.drawable.AnimatedVectorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle("KeepNotes")
        setSupportActionBar(toolbar)

        val notes = ArrayList<ItemNote>()
        notes.add(ItemNote("Lorem ipsum dolor sit amet consectetur adipiscing, elit facilisis donec felis bibendum arcu aenean, sem nunc tincidunt aliquam enim. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit amet consectetur adipiscing, aliquam enim.Porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit elit facilisis donec felis aenean, sem nunc tincidunt aliquam enim. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit amet consectetur adipiscing, elit facilisis donec felis. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit facilisis donec felis bibendum arcu aenean, sem nunc tincidunt aliquam enim. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit adipiscing, elit arcu aenean, sem nunc tincidunt aliquam enim. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit amet aliquam enim. Facilisi commodo arcu penatibus aliquam, sapien sem conubia interdum."))
        notes.add(ItemNote("Lorem ipsum dolor sit facilisis donec felis bibendum arcu aenean, sem nunc tincidunt aliquam enim. Facilisi viverra porttitor curae eleifend vivamus, tincidunt suspendisse commodo arcu penatibus aliquam, sapien sem conubia interdum."))

        val recView = findViewById<RecyclerView>(R.id.recView)
        recView.setHasFixedSize(true)

        val adaptador = ItemNotesAdapter(notes)
        recView.adapter = adaptador
        recView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adaptador.onClick = {}

        //Animación
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setImageResource(R.drawable.ic_baseline_add_24)

        fab.setOnClickListener {
            val rotar = getDrawable(R.drawable.addfab_rotation) as AnimatedVectorDrawable
            fab.setImageDrawable(rotar)
            rotar.start()
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
}