#!/usr/bin/env bash

set -euo pipefail

echo "Building iOS App"

bazel build //iOS:Swordle

$(pwd)/scripts/ci-cd.sh ios build

echo "Running iOS Tests"

$(pwd)/scripts/ci-cd.sh ios test

echo "Building Android App"

$(pwd)/scripts/ci-cd.sh android build

echo "Running Android Tests"

$(pwd)/scripts/ci-cd.sh android test