#!/usr/bin/env bash

set -euo pipefail

function usuage () {
    >&2 echo "$0 <ios|android> <build|test>"
}

function build() {
    if [ "$#" -ne 2 ]; then
        usuage
        exit 1
    fi
    ACTION=""
    case "$2" in
        "build")
            ACTION="BUILD"
        ;;
        "test")
            ACTION="TEST"
        ;;
        *)
            >&2 echo "Expected either build or test."
            exit 1
        ;;
    esac
    case "$1" in
        "ios")
            if [ "$ACTION" = "BUILD" ]; then
                bazel build //iOS:Swordle
            else
                bazel test //iOS/SwordleTests:SwordleTests
            fi
        ;;
        "android")
            if [ ! -f $(pwd)/Android/gradlew ]; then
                >&2 echo "Can't find gradlew"
                exit 1
            fi
            if [ "$ACTION" = "BUILD" ]; then
                cd $(pwd)/Android && ./gradlew assembleRelease
            else
                cd $(pwd)/Android && ./gradlew test
            fi
        ;;
        *)
            >&2 echo "Expected either ios or android"
            exit 1
        ;;
    esac

    exit 0
}

build "$@"