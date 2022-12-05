# iOS

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

http_archive(
    name = "build_bazel_rules_apple",
    sha256 = "4161b2283f80f33b93579627c3bd846169b2d58848b0ffb29b5d4db35263156a",
    url = "https://github.com/bazelbuild/rules_apple/releases/download/0.34.0/rules_apple.0.34.0.tar.gz",
)

load(
    "@build_bazel_rules_apple//apple:repositories.bzl",
    "apple_rules_dependencies",
)

apple_rules_dependencies()

load(
    "@build_bazel_rules_swift//swift:repositories.bzl",
    "swift_rules_dependencies",
)

swift_rules_dependencies()

load(
    "@build_bazel_rules_swift//swift:extras.bzl",
    "swift_rules_extra_dependencies",
)

swift_rules_extra_dependencies()

load(
    "@build_bazel_apple_support//lib:repositories.bzl",
    "apple_support_dependencies",
)

apple_support_dependencies()

# Android

# NOTE: This currently does not work. It fails with:
# maven/BUILD:1218:11: Desugaring v1/https/repo1.maven.org/maven2/org/jetbrains/kotlinx/kotlinx-coroutines-core-jvm/1.5.2/kotlinx-coroutines-core-jvm-1.5.2.jar for Android failed: (Exit 1): desugar_java8 failed: error executing command 

android_sdk_repository(
    name = "androidsdk",
    api_level = 31
)

# Kotlin

KOTLIN_VERSION = "1.3.61"
KOTLIN_RELEASE_SHA = "3901151ad5d94798a268d1771c6c0b7e305a608c2889fc98a674802500597b1c"

RULES_KOTLIN_COMPILER_RELEASE = {
    "urls": [
    "https://github.com/JetBrains/kotlin/releases/download/v{v}/kotlin-compiler-{v}.zip".format(v = KOTLIN_VERSION),
    ],
    "sha256": KOTLIN_RELEASE_SHA
}

RULES_KOTLIN_VERSION = "legacy-1.3.0-rc1"
RULES_KOTLIN_SHA = "9de078258235ea48021830b1669bbbb678d7c3bdffd3435f4c0817c921a88e42"

http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % RULES_KOTLIN_VERSION],
    type = "zip",
    strip_prefix = "rules_kotlin-%s" % RULES_KOTLIN_VERSION,
    sha256 = RULES_KOTLIN_SHA
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")
kotlin_repositories(compiler_release = RULES_KOTLIN_COMPILER_RELEASE)
kt_register_toolchains()

# END KOTLIN

RULES_JVM_EXTERNAL_TAG = "4.2"
RULES_JVM_EXTERNAL_SHA = "cd1a77b7b02e8e008439ca76fd34f5b07aecb8c752961f9640dea15e9e5ba1ca"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

COMPOSE_VERSION = "1.1.1"
KOTLIN_COMPILER_VERSION = "1.6.21"

maven_install(
    artifacts = [
        "org.jetbrains.kotlin:kotlin-stdlib:{}".format(KOTLIN_COMPILER_VERSION),
        "androidx.core:core-ktx:1.7.0",
        "androidx.appcompat:appcompat:1.4.1",
        "androidx.activity:activity-compose:1.4.0",
        "androidx.compose.material:material:{}".format(COMPOSE_VERSION),
        "androidx.compose.ui:ui:{}".format(COMPOSE_VERSION),
        "androidx.compose.ui:ui-tooling:{}".format(COMPOSE_VERSION),
        "androidx.compose.compiler:compiler:{}".format(COMPOSE_VERSION),
        "androidx.compose.runtime:runtime:{}".format(COMPOSE_VERSION),
    ],
    repositories = [
        "https://maven.google.com",
        "https://repo1.maven.org/maven2",
    ],
)