package com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.mapper

import com.alilopez.demo.features.jsonplaceholder.data.datasources.remote.models.PostsDto
import com.alilopez.demo.features.jsonplaceholder.domain.entities.Posts


fun PostsDto.toDomain(): Posts {
    return Posts(
        id = this.id,
        title = this.title,
        body = this.body
    )
}