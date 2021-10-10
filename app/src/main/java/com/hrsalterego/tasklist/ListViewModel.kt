package com.example.tasklists.model

import androidx.lifecycle.ViewModel

//Create a ViewModel class to save your data in state. The inputted tasks delete when you navigate
//btwn screens. For this reason ViewModel class is needed.
class ListViewModel : ViewModel() {
    var positionClicked = -1
    //From your FragmentOne screen: Carry each clicked item in the list (typelist val)

    val tasks = mutableListOf<String>()
    // and the position (positionClicked var) from the recyclerView here to be saved in memory.
}