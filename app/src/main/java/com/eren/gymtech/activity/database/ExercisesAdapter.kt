package com.eren.gymtech.activity.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eren.gymtech.R

class ExercisesAdapter(private val userList : ArrayList<Exercises>)  : RecyclerView.Adapter<ExercisesAdapter.ExercisesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.users_items,parent,false)
        return ExercisesViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: ExercisesViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.userName.text = currentItem.userName
        holder.userSurname.text = currentItem.userSurname
        holder.userBirthDate.text = currentItem.userBirthDate
        holder.userMail.text = currentItem.userMail
        holder.userUid.text = currentItem.userUid
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    class ExercisesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userName : TextView = itemView.findViewById(R.id.tvUserName)
        val userSurname : TextView = itemView.findViewById(R.id.tvUserSurname)
        val userMail : TextView = itemView.findViewById(R.id.tvUserMail)
        val userBirthDate : TextView = itemView.findViewById(R.id.tvUserBirthDate)
        val userUid: TextView = itemView.findViewById(R.id.tvUserUid)
    }
}