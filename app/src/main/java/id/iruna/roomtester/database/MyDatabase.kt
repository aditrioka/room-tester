package id.iruna.roomtester.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.iruna.roomtester.vo.Person

/**
 * Created by aditrioka on 21/02/18.
 */

@Database(entities = arrayOf(Person::class), version = 1, exportSchema = false)
abstract class MyDatabase: RoomDatabase() {

    abstract fun personDao(): PersonDao
}