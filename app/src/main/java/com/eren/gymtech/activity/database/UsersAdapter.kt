package com.eren.gymtech.activity.database

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eren.gymtech.R
import com.eren.gymtech.activity.adminPage.fragments.updates.UpdateUsersActivity

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
        holder.userMail.text = currentItem.userMail
        holder.userUid.text = currentItem.userUid

        holder.editButton.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, UpdateUsersActivity::class.java)
            context.startActivity(intent)

            intent.putExtra("userName", currentItem.userName)
            intent.putExtra("userSurname", currentItem.userSurname)
            intent.putExtra("userBirthDate", currentItem.userBirthDate)
            intent.putExtra("userMail", currentItem.userMail)
            intent.putExtra("userUid", currentItem.userUid)

            context.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    class UsersViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val userName : TextView = itemView.findViewById(R.id.tvUserName)
        val userSurname : TextView = itemView.findViewById(R.id.tvUserSurname)
        val userMail : TextView = itemView.findViewById(R.id.tvUserMail)
        val userBirthDate : TextView = itemView.findViewById(R.id.tvUserBirthDate)
        val editButton: Button = itemView.findViewById(R.id.tvUserEdit)
        val userUid: TextView = itemView.findViewById(R.id.tvUserUid)
    }
}