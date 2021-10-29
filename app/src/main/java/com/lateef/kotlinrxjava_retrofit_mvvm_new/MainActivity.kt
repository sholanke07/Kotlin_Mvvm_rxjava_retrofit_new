package com.lateef.kotlinrxjava_retrofit_mvvm_new

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lateef.kotlinrxjava_retrofit_mvvm_new.Adapter.PostListAdapter
import com.lateef.kotlinrxjava_retrofit_mvvm_new.ViewModel.MainActivityViewModel
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? = null
    var adapter: PostListAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        dialog = SpotsDialog.Builder().setContext(this).setCancelable(false).build()
        dialog!!.show()

        layoutManager = LinearLayoutManager(this)
        recyclerPost!!.layoutManager = layoutManager

        mainActivityViewModel!!.getPostList.observe(this, {postModels ->
            Log.e("MainActivity", "PostList: " + postModels.get(0).userId)

            adapter = PostListAdapter(this, postModels)
            adapter!!.notifyDataSetChanged()
            recyclerPost!!.adapter = adapter
            dialog!!.dismiss()
        })
    }
}