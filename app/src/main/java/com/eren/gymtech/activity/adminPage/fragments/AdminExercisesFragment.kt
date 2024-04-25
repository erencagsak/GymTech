package com.eren.gymtech.activity.adminPage.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eren.gymtech.R
import com.eren.gymtech.activity.adminPage.AdminAddExerciseActivity
import com.eren.gymtech.activity.database.Exercises
import com.eren.gymtech.activity.database.ExercisesAdapter
import com.eren.gymtech.activity.generalPage.LoginActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AdminExercisesFragment : Fragment() {
    private lateinit var databaseReference: DatabaseReference
    private lateinit var exerciseRecyclerView: RecyclerView
    private lateinit var exerciseArrayList: ArrayList<Exercises>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_admin_exercises, container, false)

        exerciseRecyclerView = view.findViewById(R.id.adminExerciseList)
        exerciseRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        exerciseRecyclerView.setHasFixedSize(true)

        exerciseArrayList = arrayListOf()
        getUserData()

        val addExercisesButton = view.findViewById<Button>(R.id.addExercisesButton)
        addExercisesButton.setOnClickListener {
            val intent = Intent(context, AdminAddExerciseActivity::class.java)
            startActivity(intent)
        }

        return view
    }

    private fun getUserData() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Exercise")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (exerciseSnapshot in snapshot.children){
                        val exercise = exerciseSnapshot.getValue(Exercises::class.java)
                        exerciseArrayList.add(exercise!!)
                    }
                    exerciseRecyclerView.adapter = ExercisesAdapter(exerciseArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}