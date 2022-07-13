package com.vnextglobal.core

import com.vnextglobal.core.model.User
import com.vnextglobal.core.repo.LocalDbRepository
import javax.inject.Inject

class UserRepoImpl @Inject constructor(): UserRepository {
    @Inject
    internal lateinit var dbRepository: LocalDbRepository
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