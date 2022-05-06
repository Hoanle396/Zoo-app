package com.example.lab6

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var list=ArrayList<Animal>()
    var adapter:AnimalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(Animal("dog","Chó con xinh xắn dễ thương",R.drawable.chucho,false))
        list.add(Animal("Double Dog","2 con Chó xinh xắn dễ thương",R.drawable.chocon,true))
        list.add(Animal("Chuột","chuột con xinh xắn dễ thương",R.drawable.chuottui,false))
        list.add(Animal("Gấu","Gấu Trúc xinh xắn dễ thương",R.drawable.gautruc,false))
        list.add(Animal("Sư tử","Sư Tử con xinh xắn dễ thương",R.drawable.sutu,true))
        list.add(Animal("Ngựa Vằn","Ngựa Vằn xinh xắn dễ thương",R.drawable.nguavan,false))

        adapter= AnimalAdapter(this,list)

        val listview:ListView=findViewById(R.id.tvList)
        listview.adapter=adapter
    }
   fun  delete(index:Int){
       list.removeAt(index)
       adapter!!.notifyDataSetChanged()

   }
    fun  add(index:Int){
        list.add(index,list[index])
        adapter!!.notifyDataSetChanged()

    }
   inner class  AnimalAdapter:BaseAdapter{
        var conText:Context?=null
        var list=ArrayList<Animal>()
        constructor(context: Context,list:ArrayList<Animal>):super(){
            this.conText=context
            this.list=list

        }
        override fun getCount(): Int {
            return list.size
        }

        override fun getItem(p0: Int): Any {
            return  list[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
           var animal= list[p0]
            if(animal.isKiller==true){
                val inflater=conText!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var view= inflater.inflate(R.layout.is_killer,null)
                val tvName:TextView=view.findViewById(R.id.tvName)
                val tvDes:TextView=view.findViewById(R.id.tvDes)
                val ivImage:ImageView=view.findViewById(R.id.ivImage)
                tvName.text=animal.name
                tvDes.text=animal.des
                ivImage.setImageResource(animal.image!!)
                view.setOnClickListener {
//                    delete(p0)
//                    add(p0)
                    var intent=Intent(conText,AnimalInfo::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    conText!!.startActivity(intent)
                }
                return view
            }
            val inflater=conText!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view= inflater.inflate(R.layout.itemview,null)
            val tvName:TextView=view.findViewById(R.id.tvName)
            val tvDes:TextView=view.findViewById(R.id.tvDes)
            val ivImage:ImageView=view.findViewById(R.id.ivImage)
            tvName.text=animal.name
            tvDes.text=animal.des
            ivImage.setImageResource(animal.image!!)
            view.setOnClickListener {
//                delete(p0)
//                add(p0)
                var intent=Intent(conText,AnimalInfo::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                conText!!.startActivity(intent)
            }
            return view
        }

    }
}