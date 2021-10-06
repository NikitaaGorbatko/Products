package nikitagorbatko.example.products

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import nikitagorbatko.example.products.ui.PermissionManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_contacts, R.id.navigation_orders, R.id.navigation_products))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add<ContactsFragment>(R.id.fragment_container_view)
//            }
//        }

        //val contactListView = findViewById<ListView>(R.id.contacts_list_view)

        PermissionManager.showPhoneStatePermission(applicationContext, this)
    }

}



