package com.example.submissionpemulaapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionpemulaapp.databinding.ListAnimalBinding

class ListAnimalAdapter(private val listAnimal: ArrayList<Animal>): RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ListAnimalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ListAnimalBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listAnimal.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (animal, latin, photo) = listAnimal[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = animal
        holder.binding.tvItemLatin.text = latin
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailAnimalActivity::class.java)
            intent.putExtra("key_animal", listAnimal[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }
}