package nikitagorbatko.example.products.ui.contacts

import android.annotation.SuppressLint
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.TextView
import androidx.cursoradapter.widget.SimpleCursorAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.loader.app.LoaderManager
import androidx.loader.content.CursorLoader
import nikitagorbatko.example.products.R
import nikitagorbatko.example.products.ui.contacts.ContactsViewModel


@SuppressLint("InlinedApi")
private val FROM_COLUMNS: Array<String> = arrayOf(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)

@SuppressLint("InlinedApi")
private val SELECTION: String = "${ContactsContract.Contacts.DISPLAY_NAME_PRIMARY} LIKE ?"

@SuppressLint("InlinedApi")
private val PROJECTION: Array<out String> = arrayOf(
    ContactsContract.Contacts._ID,
    ContactsContract.Contacts.LOOKUP_KEY,
    ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
)

private const val searchString: String = ""
// Defines the array to hold values that replace the ?
private val selectionArgs = arrayOf<String>(searchString)
/*
 * Defines an array that contains resource ids for the layout views
 * that get the Cursor column contents. The id is pre-defined in
 * the Android framework, so it is prefaced with "android.R.id"
 */
private val TO_IDS: IntArray = intArrayOf(android.R.id.text1)
// Define global mutable variables
// Define a ListView object
lateinit var contactsList: ListView
// Define variables for the contact the user selects
// The contact's _ID value
var contactId: Long = 0
// The contact's LOOKUP_KEY
var contactKey: String? = null
// A content URI for the selected contact
var contactUri: Uri? = null
// An adapter that binds the result Cursor to the ListView
private var cursorAdapter: SimpleCursorAdapter? = null

class ContactsFragment : Fragment()
{

    private lateinit var contactsViewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        contactsViewModel =
            ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        contactsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        //loaderManager.initLoader(0, null, this)
        return root
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        // Gets the ListView from the View list of the parent activity
//        activity?.also {
//            contactsList = it.findViewById(R.id.contacts_list_view)
//            // Gets a CursorAdapter
//            cursorAdapter = SimpleCursorAdapter(
//                it,
//                R.layout.item_layout,
//                null,
//                FROM_COLUMNS,
//                TO_IDS,
//                0
//            )
//            // Sets the adapter for the ListView
//            contactsList.adapter = cursorAdapter
//        }
//    }
//
//    override fun onCreateLoader(id: Int, args: Bundle?): androidx.loader.content.Loader<Cursor> {
//        /*
// * Makes search string into pattern and
// * stores it in the selection array
// */
//        selectionArgs[0] = "%${searchString}%"
//        // Starts the query
//        activity?.let {
//            return CursorLoader(
//                it,
//                ContactsContract.Contacts.CONTENT_URI,
//                PROJECTION,
//                SELECTION,
//                selectionArgs,
//                null
//            )
//        } ?: throw IllegalStateException()
//    }
//
//    override fun onLoadFinished(loader: androidx.loader.content.Loader<Cursor>, data: Cursor?) {
//        cursorAdapter?.swapCursor(data)
//    }
//
//    override fun onLoaderReset(loader: androidx.loader.content.Loader<Cursor>) {
//        cursorAdapter?.swapCursor(null)
//    }
//
//    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//        TODO("Not yet implemented")
//    }
}