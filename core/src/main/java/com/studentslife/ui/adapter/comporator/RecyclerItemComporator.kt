package com.studentslife.ui.adapter.comporator

interface RecyclerItemComparator {
    fun isSameItem(other: Any): Boolean
    fun isSameContent(other: Any): Boolean
}