#!/usr/bin/env bash

set -euo pipefail

echo "Building iOS app"

bazel build //iOS:Swordle