// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
tasks.register("printJavaHome") {
    doLast {
        throw GradleException("JAVA_HOME: ${System.getProperty("java.home")}")
    }
}

tasks.register("printKeyStores") {
    doLast {
        val sb = StringBuilder()
        java.security.Security.getProviders().forEach { provider ->
            provider.getServices().forEach { service ->
                if (service.getType() == "KeyStore") {
                    sb.append("Provider: ${provider.getName()}, KeyStore Type: ${service.getAlgorithm()}\n")
                }
            }
        }
        throw GradleException(sb.toString())
    }
}