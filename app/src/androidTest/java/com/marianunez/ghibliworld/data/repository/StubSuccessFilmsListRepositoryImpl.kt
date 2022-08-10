package com.marianunez.ghibliworld.data.repository

import com.marianunez.ghibliworld.data.network.response.FilmsResponse

class StubSuccessFilmsListRepositoryImpl : FilmsListRepository {
    override suspend fun getFilmsList(): Result<List<FilmsResponse>> =
        Result.success(
            listOf(
                FilmsResponse(
                    id = "12cfb892-aac0-4c5b-94af-521852e46d6a",
                    title = "Grave of the Fireflies",
                    image = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qG3RYlIVpTYclR9TYIsy8p7m7AT.jpg",
                    movieBanner = "https://image.tmdb.org/t/p/original/vkZSd0Lp8iCVBGpFH9L7LzLusjS.jpg",
                    description = "In the latter part of World War II, a boy and his sister, orphaned when their mother is killed in the firebombing of Tokyo, are left to survive on their own in what remains of civilian life in Japan. The plot follows this boy and his sister as they do their best to survive in the Japanese countryside, battling hunger, prejudice, and pride in their own quiet, personal battle.",
                    director = "Isao Takahata",
                    releaseDate = "1988",
                    rtScore = "97"
                )
            )
        )
}