package com.sameep.iiflassignment.db

import androidx.room.TypeConverter
import com.sameep.iiflassignment.rest.response.Content
import com.sameep.iiflassignment.rest.response.Excerpt
import com.sameep.iiflassignment.rest.response.Title

class Converter {

    companion object{

        @TypeConverter
        @JvmStatic
        fun titleObjectToText(title: Title):String{
            return if (title.rendered.isNullOrEmpty()) "Title N/A"
            else
                "${title.rendered}"
        }


        @TypeConverter
        @JvmStatic
        fun toTitleObject(title: String):Title{
            return if (title.isNullOrEmpty()) Title("Title N/A")
            else
                Title(title)
        }


        @TypeConverter
        @JvmStatic
        fun excerptObjectToText(excerpt: Excerpt):String{
            return if (excerpt.rendered.isNullOrEmpty()) "Title N/A"
            else
                "${excerpt.rendered}"
        }


        @TypeConverter
        @JvmStatic
        fun toExcerptObject(excerpt: String):Excerpt{
            return if (excerpt.isNullOrEmpty()) Excerpt("Excerpt N/A")
            else
                Excerpt(excerpt)
        }

        @TypeConverter
        @JvmStatic
        fun toContentObject(content : String):Content{
            return if (content.isNullOrEmpty()) Content("Content N/A")
            else
                Content(content)
        }

        @TypeConverter
        @JvmStatic
        fun contentToString(content: Content):String{
            return if (content.rendered.isNullOrEmpty()) "Title N/A"
            else
                content.rendered
        }

    }

}