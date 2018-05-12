package id.iruna.roomtester.vo

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aditrioka on 21/02/18.
 */

@Entity(tableName = "person")
data class Person(
        val name: String,
        val age: Int,
        val hobby: String) {

        @PrimaryKey(autoGenerate = true)
        var id: Long? = null
}