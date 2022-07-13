package com.vnextglobal.core

import com.vnextglobal.core.model.User

interface UserRepository {

    fun getUserInfo():User

    fun createUser(user: User)

    fun deleteUser(user: User)

}