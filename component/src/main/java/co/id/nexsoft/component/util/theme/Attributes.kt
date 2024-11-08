package co.id.nexsoft.component.util.theme

import java.util.Locale

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

fun setId(id: String?, label: String = ""): String {
    return id
        ?: label.trim()
            .lowercase(Locale.getDefault())
            .replace("\\s+".toRegex(), "_")
}