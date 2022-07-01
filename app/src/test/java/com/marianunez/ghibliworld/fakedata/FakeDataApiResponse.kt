package com.marianunez.ghibliworld.fakedata

import com.marianunez.ghibliworld.data.network.response.FilmsResponse

val fakeFilmsResponse1 = FilmsResponse(
    id = "2baf70d1-42bb-4437-b551-e5fed5a87abe",
    title = "Castle in the Sky",
    image = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
    movieBanner = "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg",
    description = "The orphan Sheeta inherited a mysterious crystal that links her to the mythical sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta and Pazu must outwit the evil Muska, who plans to use Laputa's science to make himself ruler of the world.",
    director = "Hayao Miyazaki",
    releaseDate = "1986",
    rtScore = "95",
    people = listOf(
        "https://ghibliapi.herokuapp.com/people/598f7048-74ff-41e0-92ef-87dc1ad980a9",
        "https://ghibliapi.herokuapp.com/people/fe93adf2-2f3a-4ec4-9f68-5422f1b87c01",
        "https://ghibliapi.herokuapp.com/people/3bc0b41e-3569-4d20-ae73-2da329bf0786",
        "https://ghibliapi.herokuapp.com/people/40c005ce-3725-4f15-8409-3e1b1b14b583",
        "https://ghibliapi.herokuapp.com/people/5c83c12a-62d5-4e92-8672-33ac76ae1fa0",
        "https://ghibliapi.herokuapp.com/people/e08880d0-6938-44f3-b179-81947e7873fc",
        "https://ghibliapi.herokuapp.com/people/2a1dad70-802a-459d-8cc2-4ebd8821248b"
    ),
    species = listOf("https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2"),
    locations = listOf("https://ghibliapi.herokuapp.com/locations/"),
    vehicles = listOf("https://ghibliapi.herokuapp.com/vehicles/4e09b023-f650-4747-9ab9-eacf14540cfb"),
)

val fakeFilmsResponse2 = FilmsResponse(
    id = "12cfb892-aac0-4c5b-94af-521852e46d6a",
    title = "Grave of the Fireflies",
    image = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/qG3RYlIVpTYclR9TYIsy8p7m7AT.jpg",
    movieBanner = "https://image.tmdb.org/t/p/original/vkZSd0Lp8iCVBGpFH9L7LzLusjS.jpg",
    description = "In the latter part of World War II, a boy and his sister, orphaned when their mother is killed in the firebombing of Tokyo, are left to survive on their own in what remains of civilian life in Japan. The plot follows this boy and his sister as they do their best to survive in the Japanese countryside, battling hunger, prejudice, and pride in their own quiet, personal battle.",
    director = "Isao Takahata",
    releaseDate = "1988",
    rtScore = "97",
    people = listOf("https://ghibliapi.herokuapp.com/people/"),
    species = listOf("https://ghibliapi.herokuapp.com/species/af3910a6-429f-4c74-9ad5-dfe1c4aa04f2"),
    locations = listOf("https://ghibliapi.herokuapp.com/locations/"),
    vehicles = listOf("https://ghibliapi.herokuapp.com/vehicles/"),
)

val fakeFilmsListResponse = Result.success(
    listOf(
        fakeFilmsResponse1,
        fakeFilmsResponse2
    )
)