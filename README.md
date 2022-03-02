# Ergatta DevOps Engineer Exercise

This exercise is designed to test how you work with a variety of build systems. At Ergatta, we have products using many different platforms and environments. It’s important to be able to work with what we currently have, and show how that could extend to new platforms and products.

This shouldn’t take more than three–five hours, but you are welcome to spend as much time on it as you’d like. If you don’t have more than a few hours, that’s ok! Send over whatever you have.

## Objective

In this repository are two toy apps, one each targeting:

1. iOS, written in Swift and using SwiftUI
2. Android, written in Kotlin and using Jetpack Compose

Your task is:

1. Check out this repository
2. Push a clone of the source code into a repository you create
	1. It is important that you do not fork the initial repository—that makes your work easily visible to other candidates. If you are unable to create a repository that you control, we will be happy to set up an additional repository for you
3. Write a build script that can:
	1. Build both applications
	2. Run all tests in both applications

This should work as a POSIX-compatible shell script in the root of this repository `build.sh`. Caveats:

1. This is of course open-book. Feel free to Google around for how to build apps in these environments.
2. You can delegate the build and test processes themselves to other command-line tools.
3. Your script does not need to install the build tool(s), but should note in a README what tools are being used and how you installed them
4. Android and iOS do not need to use the same build system
5. I have supplied a Gradle file for the Android build. You are welcome to use Gradle as the build system for Android, or something else of your choosing.
6. Bonus points if you _do_ use the same build system for both, especially if it’s [Bazel](https://bazel.build).
7. Bonus points if you incorporate CI into it
