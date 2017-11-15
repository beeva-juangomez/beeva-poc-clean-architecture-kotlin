package com.github.cleanArchitectureKotlin.domain.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Token(@PrimaryKey var token: String)