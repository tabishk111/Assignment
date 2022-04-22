package com.example.recyclerassignment.models

data class TeacherItem(
    val id: Int,
    val name: String,
    val profileImage: String,
    val qualification: List<String>,
    val subjects: List<String>
)