package com.example.drcrreport3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
class MainActivity : AppCompatActivity() {

    private var account_id: ArrayList<String> = ArrayList()
    private var account_name: ArrayList<String> = ArrayList()
    private var parent_id: ArrayList<String> = ArrayList()
    private var parent_name: ArrayList<String> = ArrayList()
    private var debit: ArrayList<String> = ArrayList()
    private var credit: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "DR CR Report App"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("message")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                account_id.add(userDetail.getString("account_id"))
                account_name.add(userDetail.getString("account_name"))
                parent_id.add(userDetail.getString("parent_id"))
                parent_name.add(userDetail.getString("parent_name"))
                debit.add(userDetail.getString("debit"))
                credit.add(userDetail.getString("credit"))
            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
        val customAdapter = CustomAdapter(this@MainActivity, account_id,account_name,parent_id,parent_name,debit, credit)
        recyclerView.adapter = customAdapter
    }
    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("user_list.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }
}