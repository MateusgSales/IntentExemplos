package com.example.mateussales.unifor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val btnCam = findViewById(R.id.buttonCam) as Button
        btnCam.setOnClickListener { capturePhoto() }

        val btnContact = findViewById(R.id.buttonContact) as Button
        btnContact.setOnClickListener { selectContact() }

        val btnCall = findViewById(R.id.buttonCall) as Button
        btnCall.setOnClickListener { dialPhoneNumber() }

    }


    fun dialPhoneNumber() {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel: 55850000000")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun selectContact() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = ContactsContract.Contacts.CONTENT_TYPE
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 1)
        }
    }

    fun capturePhoto() {
        val intent = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }
}
