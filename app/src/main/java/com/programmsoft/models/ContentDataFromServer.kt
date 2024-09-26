package com.programmsoft.models

data class ContentDataFromServer(
    val `data`: List<ContentDataItem>,
    val links: Links,
    val meta: Meta
)