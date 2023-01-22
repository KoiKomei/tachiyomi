plugins {
    id("com.android.library")
    kotlin("android")
    id("com.squareup.sqldelight")
}

android {
    namespace = "tachiyomi.data"

    defaultConfig {
        consumerProguardFiles("consumer-rules.pro")
    }

    sqldelight {
        database("Database") {
            packageName = "tachiyomi.data"
            dialect = "sqlite:3.24"
        }
    }
}

dependencies {
    implementation(project(":source-api"))
    implementation(project(":domain"))
    api(libs.sqldelight.android.driver)
    api(libs.sqldelight.coroutines)
    api(libs.sqldelight.android.paging)
}
