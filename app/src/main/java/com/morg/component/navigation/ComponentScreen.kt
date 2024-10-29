package com.morg.component.navigation

enum class ComponentScreen {
    LIST,
    AVATAR,
    TEXT_FIELD,
    BUTTON;

    companion object {
        fun fromRoute(route: String?): ComponentScreen = when (route?.substringBefore("/")) {
            LIST.name -> LIST
            AVATAR.name -> AVATAR
            TEXT_FIELD.name -> TEXT_FIELD
            BUTTON.name -> BUTTON
            null -> AVATAR
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
    }
}