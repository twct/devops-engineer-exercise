load("@build_bazel_rules_apple//apple:ios.bzl", "ios_application")
load("@build_bazel_rules_swift//swift:swift.bzl", "swift_library")

swift_library(
    name = "SwordleLibrary",
    # I must admit, using a `glob` expression as someone that has used CMake for many years, it feels strange.
    # CMake doesn't detect if files have changed with a glob expression, meanwhile Bazel does. Very cool!
    srcs = glob([
        "Swordle/*.swift",
    ]),
    data = glob([
        "*.xcassets/**/*",
        "*.lproj/**/*",
    ]),
    module_name = "Swordle",
    tags = ["manual"],
    visibility = ["//visibility:public"],
)

ios_application(
    name = "Swordle",
    bundle_id = "com.ergatta.Swordle",
    families = [
        "iphone",
        "ipad",
    ],
    infoplists = [":Info.plist"],
    minimum_os_version = "15.5",
    visibility = ["//visibility:public"],
    deps = [":SwordleLibrary"],
)