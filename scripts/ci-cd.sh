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
            ACTION="build"
        ;;
        "test")
            ACTION="test"
        ;;
        *)
            >&2 echo "Expected either build or test."
            exit 1
        ;;
    esac
    case "$1" in
        "ios")
            if [ "$ACTION" - eq "BUILD" ]; then
                bazel build //iOS:Swordle
            else
                bazel test //iOS/SwordleTests:SwordleTests
            fi
        ;;
        "android")
            echo "TODO"
        ;;
        *)
            >&2 echo "Expected either ios or android"
            exit 1
        ;;
    esac
}

build "$@"