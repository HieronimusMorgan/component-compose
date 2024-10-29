package com.morg.component.util.theme

enum class ComponentSize {
    SMALL, MEDIUM, LARGE;

    override fun toString(): String {
        return when (this) {
            SMALL -> "small"
            MEDIUM -> "medium"
            LARGE -> "large"
        }
    }
}

enum class ComponentType {
    PRIMARY, SECONDARY, TERTIARY;

    override fun toString(): String {
        return when (this) {
            PRIMARY -> "primary"
            SECONDARY -> "secondary"
            TERTIARY -> "tertiary"
        }
    }
}