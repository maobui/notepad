package com.me.bui.notepad.recycler

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.me.bui.notepad.R
import com.me.bui.notepad.data.DataStore
import com.me.bui.notepad.data.Note
import com.me.bui.notepad.util.layoutInflater
import kotlinx.android.synthetic.main.item_note.view.*

import java.util.ArrayList

class NotesAdapter(private val context: Context) : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private var notes: List<Note> = ArrayList()
    private var isRefreshing = false

    init {
        setHasStableIds(true)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        refresh()
    }

    override fun getItemId(position: Int): Long {
        return notes[position].id.toLong()
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = context.layoutInflater.inflate(R.layout.item_note, parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]
        holder.text.setText(note.text)
    }

    fun refresh() {
        if (isRefreshing) return
        isRefreshing = true
        DataStore.execute(object : Runnable {
            override fun run() {
                val notes = DataStore.notes.all
                Handler(Looper.getMainLooper()).post(object : Runnable {
                    override fun run() {
                        this@NotesAdapter.notes = notes
                        notifyDataSetChanged()
                        isRefreshing = false
                    }
                })
            }
        })
    }

    class NotesViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.text
    }
}
