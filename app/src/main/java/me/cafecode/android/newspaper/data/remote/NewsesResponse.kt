package me.cafecode.android.newspaper.data.remote

import com.google.gson.annotations.SerializedName
import me.cafecode.android.newspaper.data.models.News

data class NewsesResponse(var status: String,
                          var source: String,
                          var sortBy: String,
                          @SerializedName("articles") var newses: List<News>) {

}
