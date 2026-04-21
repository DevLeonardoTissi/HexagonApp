package br.com.leonardo.hexagonapp.mock

import br.com.leonardo.localData.model.PersonalProfile

object MockData {

    val mockActivesProfiles = listOf(
        PersonalProfile(
            id = "1",
            cpf = "123.456.789-00",
            name = "Leonardo Silva",
            city = "São Paulo",
            dateOfBirth = 631152000000L,
            active = true,
            photo = "https://example.com/photo1.jpg"
        ),
        PersonalProfile(
            id = "2",
            cpf = "987.654.321-11",
            name = "Ana Oliveira",
            city = "Rio de Janeiro",
            dateOfBirth = 788918400000L,
            active = true,
            photo = null
        ),
        PersonalProfile(
            id = "3",
            cpf = "444.555.666-77",
            name = "Ricardo Santos",
            city = "Belo Horizonte",
            dateOfBirth = 946684800000L,
            active = true,
            photo = "https://example.com/photo3.jpg"
        )
    )

    val mockInactivesProfiles = listOf(
        PersonalProfile(
            id = "1",
            cpf = "123.456.789-00",
            name = "Leonardo Silva",
            city = "São Paulo",
            dateOfBirth = 631152000000L,
            active = false,
            photo = "https://example.com/photo1.jpg"
        ),
        PersonalProfile(
            id = "2",
            cpf = "987.654.321-11",
            name = "Ana Oliveira",
            city = "Rio de Janeiro",
            dateOfBirth = 788918400000L,
            active = false,
            photo = null
        ),
        PersonalProfile(
            id = "3",
            cpf = "444.555.666-77",
            name = "Ricardo Santos",
            city = "Belo Horizonte",
            dateOfBirth = 946684800000L,
            active = false,
            photo = "https://example.com/photo3.jpg"
        )
    )

    val mockProfiles = listOf(
        PersonalProfile(
            id = "1",
            cpf = "123.456.789-00",
            name = "Leonardo Silva",
            city = "São Paulo",
            dateOfBirth = 631152000000L,
            active = false,
            photo = "https://example.com/photo1.jpg"
        ),
        PersonalProfile(
            id = "2",
            cpf = "987.654.321-11",
            name = "Ana Oliveira",
            city = "Rio de Janeiro",
            dateOfBirth = 788918400000L,
            active = true,
            photo = null
        ),
        PersonalProfile(
            id = "3",
            cpf = "444.555.666-77",
            name = "Ricardo Santos",
            city = "Belo Horizonte",
            dateOfBirth = 946684800000L,
            active = true,
            photo = "https://example.com/photo3.jpg"
        )
    )

}