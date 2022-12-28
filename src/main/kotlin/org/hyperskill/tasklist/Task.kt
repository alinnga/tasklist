package org.hyperskill.tasklist

import kotlinx.datetime.LocalDateTime

data class Task(var priority: Char = 'L',
                var date: LocalDateTime = LocalDateTime(2010, 1, 1, 0, 0),
                var description: MutableList<String> = mutableListOf("default task"))