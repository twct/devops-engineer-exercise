# devops-engineer-exercise

This repo contains build instructions the iOS and Android Swordle applications, and runs unit tests with the Bazel build tool.

## Build instructions

### iOS

#### Build

```sh
$ bazel build //iOS:Swordle
```

#### Run Tests
```sh
$ bazel test //iOS/SwordleTests:SwordleTests
```