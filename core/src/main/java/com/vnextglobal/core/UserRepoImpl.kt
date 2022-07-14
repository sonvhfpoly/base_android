package com.vnextglobal.core

import com.vnextglobal.core.database.BaseDatabase
import com.vnextglobal.core.model.User
import javax.inject.Inject

class UserRepoImpl @Inject internal constructor(private var baseDatabase: BaseDatabase): UserRepository {

    override fun getUserInfo(): User {
        return User(
            0,
            "son",
            "vu"
        )
    }

    override fun createUser(user: User) {

    }

    override fun deleteUser(user: User) {

    }
}