package com.artemissoftware.amphitriteui.animation.flip.models

enum class FlipSides(val angle: Float) {

    FRONT(0f) {
        override val next: FlipSides get() = BACK
    },
    BACK(180f) {
        override val next: FlipSides get() = FRONT
    };

    abstract val next: FlipSides
}