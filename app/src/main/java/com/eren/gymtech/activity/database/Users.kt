package com.eren.gymtech.activity.database

data class Users(var userName : String ?= null, var userSurname : String ?= null, var userBirthDate : String ?= null, var userRegisterDate : Int ?= null, var userRegisterFinishDate : Int ?= null, var userIsAMember : Boolean ?= null)
