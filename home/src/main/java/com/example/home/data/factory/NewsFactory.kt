package com.example.home.data.factory

import com.example.home.domain.model.News
import javax.inject.Inject

internal class NewsFactory
@Inject constructor()
{
    fun get() = listOf(
        News("Polytechnic's spring", "","prof_IKNI","Its a good time\n buy a ticket"),
        News("Otaman", "", "prof_INEM", "YAKTAK in Lviv\n Patry with pool\n Lets start a summer"),
        News("Presentation by SoftServe", "", "prof_IKNI", "Soft Serve company presented a new programming")
    )
}