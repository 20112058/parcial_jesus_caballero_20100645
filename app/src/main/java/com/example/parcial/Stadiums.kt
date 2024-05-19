package com.example.parcial

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Stadiums : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_stadiums)
        val stadiums = listOf(
            Stadium("Estadio 1", "Ubicación 1", 50000),
            Stadium("Estadio 2", "Ubicación 2", 60000),
            Stadium("Estadio 3", "Ubicación 3", 60000),
            Stadium("Estadio 4", "Ubicación 4", 60000),
            Stadium("Estadio 5", "Ubicación 5", 60000),
            // Agrega más estadios según sea necesario
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewStadiums)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = StadiumAdapter(stadiums)
        recyclerView.adapter = adapter

        val buttonGoToMenu: Button = findViewById(R.id.buttonGoToMenu)
        buttonGoToMenu.setOnClickListener {
            val intent = Intent(this, MainActivityMenuParcial::class.java)
            startActivity(intent)
        }

    }


}
data class Stadium(
    val name: String,
    val location: String,
    val capacity: Int
)
class StadiumAdapter(private val stadiums: List<Stadium>) : RecyclerView.Adapter<StadiumAdapter.StadiumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StadiumViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_stadium, parent, false)
        return StadiumViewHolder(view)
    }

    override fun onBindViewHolder(holder: StadiumViewHolder, position: Int) {
        val stadium = stadiums[position]
        holder.bind(stadium)
    }

    override fun getItemCount(): Int {
        return stadiums.size
    }

    inner class StadiumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        private val locationTextView: TextView = itemView.findViewById(R.id.textViewLocation)
        private val capacityTextView: TextView = itemView.findViewById(R.id.textViewCapacity)

        fun bind(stadium: Stadium) {
            nameTextView.text = stadium.name
            locationTextView.text = stadium.location
            capacityTextView.text = "Capacidad: ${stadium.capacity}"
        }
    }
}
