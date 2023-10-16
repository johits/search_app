package com.torder.search_app.presentation.base

interface DiffModel {
    val diffId: Any
    override fun equals(other: Any?): Boolean
}