package com.example.registrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registrationapp.databinding.ActivityItemBinding
import com.example.registrationapp.databinding.ActivityMainBinding

class ItemActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        //---  binding  ---
        binding = ActivityItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //----------------------


        val itemsList = binding.itemList

        val items = ArrayList<Item>()
        items.add(Item(1, "evil_kysya", "Kysia got angry", "Kysia is angry and may bite, but she is still a cute little kitten." , 1000000000))
        items.add(Item(2, "sleepy_kysya", "Kysia wants to sleep", "Kisya is tired and wants to sleep. Please don't disturb her or she might bite you. She is very sweet and loves everyone, but she needs her rest. Kisya's sleeping and she doesn't want to be disturbed. If you try to touch her, she might bite, so please be careful. She's very sweet" , 1000000000))
        items.add(Item(3, "killer_kysya", "Kisya wants to kill", "Kisya is a creature that wants to kill and needs blood, meat, and suffering. However, despite her violent nature, she is also very cute." , 1000000000))
        items.add(Item(4, "monster_kysya", "feels like a monster", "Now, Kisya looks like a monster. She can kill you with her gaze and is ready to attack at any second. But isn't she still cute?" , 1000000000))
        items.add(Item(5, "cutie_kysya", "Kysya looks so cute", "Kysya looks so cute that you want to squeeze her to death, strangle her in your arms and stroke her until your arm falls off. " , 1000000000)) //Кыся выглядит такой милой, что хочется затискать ее до смерти, задушить в объятиях и гладить до тех пор, пока у вас не отвалится рука.
        items.add(Item(6, " kysya_with_pills", "piiiills", "Kysia is not a drug addict, it seemed to you. And anyway, what are you watching? Should I scratch your eyes out??" , 1000000000))



        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

    }
}