load("@build_bazel_rules_apple//apple:ios.bzl", "ios_unit_test")
load("@build_bazel_rules_swift//swift:swift.bzl", "swift_library")

swift_library(
    name = "SwordleTestsLibrary",
    srcs = glob([
        "*.swift",
    ]),
    tags = ["manual"],
    deps = [
        "//iOS:SwordleLibrary",
    ],
)

ios_unit_test(
    name = "SwordleTests",
    families = [
        "iphone",
        "ipad",
    ],
    minimum_os_version = "15.5",
    deps = [":SwordleTestsLibrary"],
)