load("@build_bazel_rules_apple//apple:ios.bzl", "ios_ui_test")
load("@build_bazel_rules_swift//swift:swift.bzl", "swift_library")

swift_library(
    name = "SwordleUITestsLibrary",
    srcs = glob([
        "*.swift",
    ]),
    tags = ["manual"],
    deps = [
        "//iOS:SwordleLibrary",
    ],
)

ios_ui_test(
    name = "SwordleUITests",
    families = [
        "iphone",
        "ipad",
    ],
    test_host = "//iOS:Swordle",
    minimum_os_version = "15.5",
    deps = [":SwordleUITestsLibrary"],
)