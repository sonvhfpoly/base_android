package com.vnextglobal.core.repo

import com.vnextglobal.core.database.BaseDatabase
import javax.inject.Inject

internal class LocalDbRepository @Inject constructor(
    val baseDatabase: BaseDatabase
) {

}