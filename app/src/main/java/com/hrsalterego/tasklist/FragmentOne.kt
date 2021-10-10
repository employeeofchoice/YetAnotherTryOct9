package com.example.tasklists.model

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.hrsalterego.tasklist.R

class ItemAdapter(
    private val typeList: MutableList<String>,
    private val onClickListener: onClickListner
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    interface onClickListner {
        fun itemViewClicked(position: Int)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {//create an inner class
        //Each individual element in the list is defined by a view holder object. When the view holder is created, it doesn't have any data associated with it.
        // After the view holder is created, the RecyclerView binds it to its data.
        // You define the view holder by extending RecyclerView.ViewHolder

        val textView: TextView = view.findViewById(R.id.list_item)
        var displaysCheck: CheckBox = view.findViewById(R.id.check_mark)
        var priorityDate: EditText = view.findViewById(R.id.due_date)

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder.
        // Each data item is just an To-Do object.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // method to setup a new Viewholder and its view - called by the recyclerView.
        val context = parent.context //tells the program what xml layout to use
        val inflater = LayoutInflater.from(context) //inflates the layout of the screen
        val adapterLayout = inflater.inflate(R.layout.display_view, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder, position: Int
    ) { //onBindViewHolder called by recyclerView to bind data to Viewholder and fill in layout.

        holder.priorityDate.text.toString()

        holder.textView.text =
            typeList[position] //must create a holder, which serves as a wrapper for the views and return back To-Do (in its class) item that I named myData
        //this typelist[position] helps to find the right TO-DO object from the dataset based on position/order
        Log.i("ItemAdapter", "Prints to do")

        holder.itemView.setOnClickListener { //When each recycler view line is clicked, the nav controller travels to fragmentTwo.
            onClickListener.itemViewClicked(position)
        }
        holder.displaysCheck.setOnClickListener { //Creates toast message for checkbox in the fragmentOne, when checkbox is clicked on
            if (holder.displaysCheck.isChecked) {
                Toast.makeText(
                    holder.itemView.context,
                    "Task Completed", Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return typeList.size
    }
}

