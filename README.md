# devops-engineer-exercise

This repo contains instructions for building the Swordle app, for iOS and Android. 

## Build instructions

This project makes use of the Bazel build system. The recommend way to get started with Bazel is with [bazelisk](https://github.com/bazelbuild/bazelisk).

The version of Bazel that is known to work is pinned in the [.bazelversion](https://github.com/twct/devops-engineer-exercise/blob/main/.bazelversion) file, so once you have Bazel installed, you should be able to simply run the `build.sh` file, or follow the individual instructions below.

### iOS

#### Build

```sh
$ bazel build //iOS:Swordle
```

#### Run Tests
```sh
$ bazel test //iOS/SwordleTests:SwordleTests
```