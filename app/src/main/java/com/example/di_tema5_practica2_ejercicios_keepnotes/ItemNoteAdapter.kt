package com.example.di_tema5_practica2_ejercicios_keepnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemNotesAdapter(var items: ArrayList<ItemNote>) : RecyclerView.Adapter<ItemNotesAdapter.ItemViewHolder>() {
    lateinit var onClick : (View) -> Unit


    //La clase declarada como itemViewHolder hereda, es, un ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*
        Si son privadas no son accesibles en onBindViewHolder
        y no se podran usar.
        */
        var tvNote: TextView

        init {
            tvNote = itemView.findViewById(R.id.tvNoteContent)

        }

        fun bindTarjeta(item: ItemNote, onClick: (View) -> Unit) = with(itemView) {
            tvNote.setText(item.note)
            setOnClickListener { onClick(itemView) }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_note, viewGroup, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: ItemViewHolder, pos: Int) {
        val itemNote = items.get(pos)
        viewHolder.bindTarjeta(itemNote, onClick)


        /*viewHolder.itemToolbar.setOnMenuItemClickListener(object: Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem): Boolean{
                when(item.itemId){
                    (R.id.action_copiar) ->{
                        listaItems.add(viewHolder.adapterPosition, ItemCard(itemCard.imagen,itemCard.titulo))
                        notifyItemInserted(viewHolder.adapterPosition)
                    }
                    (R.id.action_eliminar) ->{
                        listaItems.removeAt(viewHolder.adapterPosition)
                        notifyItemRemoved(viewHolder.adapterPosition)
                    }
                }
                return true
            }

        })

         */
    }

    override fun getItemCount(): Int {
        return items.size
    }
}