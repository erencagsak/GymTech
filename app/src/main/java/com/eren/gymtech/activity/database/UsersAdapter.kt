package com.eren.gymtech.activity.database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eren.gymtech.R

class UsersAdapter(private val userList : ArrayList<Users>)  : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.users_items,parent,false)
        return UsersViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.userName.text = currentItem.userName
        holder.userSurname.text = currentItem.userSurname
        holder.userBirthDate.text = currentItem.userBirthDate
        holder.userIsAMember.text = currentItem.userIsAMember.toString()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    class UsersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userName : TextView = itemView.findViewById(R.id.tvUserName)
        val userSurname : TextView = itemView.findViewById(R.id.tvUserSurname)
        val userBirthDate : TextView = itemView.findViewById(R.id.tvUserBirthDate)
        val userIsAMember : TextView = itemView.findViewById(R.id.tvUserIsAMember)
    }
}