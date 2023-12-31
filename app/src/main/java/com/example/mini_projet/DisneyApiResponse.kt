package com.example.mini_projet

import com.example.mini_projet.DisneyCharacter

data class DisneyApiResponse(
    val data: List<DisneyCharacter>,
    val infos: DisneyApiInfos
) {
}