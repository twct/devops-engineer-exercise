load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kt_android_library")

kt_android_library(
    name = "SwordleLibrary",
    srcs = glob(["java/**/*.kt"]),
    custom_package = "me.swaminathan.swordle",
    manifest = "AndroidManifest.xml",
    visibility = ["//visibility:public"],
    resource_files = glob(["res/**/*"]),
    deps = [
        "@maven//:androidx_activity_activity_compose",
        "@maven//:androidx_appcompat_appcompat",
        "@maven//:androidx_compose_material_material",
        "@maven//:androidx_compose_runtime_runtime",
        "@maven//:androidx_compose_ui_ui",
        "@maven//:androidx_compose_ui_ui_tooling",
        "@maven//:androidx_core_core_ktx",
        "@maven//:org_jetbrains_kotlin_kotlin_stdlib",
    ],
)

android_binary(
    name = "Swordle",
    manifest = ":AndroidManifest.xml",
    resource_files = glob(["res/**/*"]),
    deps = [
        ":SwordleLibrary",
    ],
)