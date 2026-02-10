package com.alilopez.demo.features.factory.data.mappers

import com.alilopez.demo.features.factory.data.models.PostsDTO
import com.alilopez.demo.features.factory.domain.entities.Posts

fun PostsDTO.toDomain() : Posts {
    return Posts(
        id = this.id,
        title = this.title,
        body = this.body
    )
}