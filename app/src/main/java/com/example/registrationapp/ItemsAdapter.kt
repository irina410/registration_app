package com.example.registrationapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationapp.databinding.ActivityMainBinding


class ItemsAdapter(var items: List<Item>, var context: Context): RecyclerView.Adapter<ItemsAdapter.MyViewHolder>( ){



    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        var imege: ImageView = view.findViewById(R.id.item_imageView )
        var title: TextView = view.findViewById(R.id.item_name )
       // var desc: TextView = view.findViewById(R.id.item_desc )
        var price: TextView = view.findViewById(R.id.item_price  )

        var touchLay: ConstraintLayout = view.findViewById(R.id.layout_of_item)


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.title.text = items[position].shortDescription
        //holder.desc.text = items[position].detailedDescription
        holder.price.text = items[position].price.toString() + " деняк"


        var imageId = context.resources.getIdentifier(
            items[position].image, "drawable", context.packageName
        )


        holder.imege.setImageResource(imageId)


        holder.touchLay.setOnClickListener {
            val intent = Intent(context, MainActivityItem::class.java)

            intent.putExtra("NAME", items[position].shortDescription)
            intent.putExtra("DESC", items[position].detailedDescription)
            intent.putExtra("PRICE", items[position].price)
            intent.putExtra("IMG", items[position].image)

            context.startActivity(intent)
        }

    }

}