package com.example.newso.data.entity.database

import androidx.room.TypeConverter
import com.example.newso.data.entity.entities.Source

class Converter {

    @TypeConverter
    fun fromSource( source: Source) : String {

        return source.name;
    }

    @TypeConverter
    fun toSource( name: String ) : Source {

        return Source( name, name )
    }
}