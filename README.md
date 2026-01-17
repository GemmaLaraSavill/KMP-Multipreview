# KMP-Multipreviews

Unlock MultiPreviews in Compose Multiplatform using the Super Provider Pattern.

This project is designed for **Android Studio** and demonstrates how to create reusable Multipreviews in Kotlin Multiplatform to test different color schemes, screen sizes, and font scales across Android and iOS.

> **Note:** For the best experience with Compose Multiplatform previews, please use the latest version of [Android Studio](https://developer.android.com/studio).

## Project Structure
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in **Android Studio's** toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in **Android Studio's** toolbar (with the KMM plugin) or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

## Read the Blog Post

For a detailed explanation of the **Super Provider Pattern** and how it enables powerful MultiPreviews in Compose Multiplatform, check out the full blog post:

👉 [Compose Multiplatform MultiPreviews: The Super Provider Pattern](https://www.myhappyplace.dev/blog/compose-multiplatform-multipreviews-super-provider-pattern/)

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…