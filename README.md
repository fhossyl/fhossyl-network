# Fhossyl Network

[![actions_badge][]][actions] [![localized][]][translate]

⚠️ **Fhossyl is still a work in progress and is not recommended for production.**

`fhossyl-network` is a repository dedicated to network components for Minecraft:
Java Edition and Minecraft: Bedrock Edition protocols.

# Credits

* [Minecraft Protocol Wiki][protocol]. Information about Minecraft servers and clients have been taken from the
  Minecraft Protocol Wiki.
* [Ktor][ktorio] by `Ktor Team`. The Ktor for I/O dependency is being used on our `build.gradle.kts` for Input/Output
  work.
* [kotlinx.serialization][serialization] by `Kotlin`. The kotlinx.serialization dependency is being used on
  our `build.gradle.kts` to provide an optimized and cleaner binary (de)serialization systems.
* [kotlinx.coroutines][coroutines] by `Kotlin`. The kotlinx.coroutines dependency is being user on
  our `build.gradle.kts` to provide suspendable, readable and more optimized code.

[actions]: https://github.com/fhosyl/fhossyl-client/actions

[network]: https://github.com/fhossyl/fhossyl-network

[actions_badge]: https://github.com/fhossyl/fhossyl-network/workflows/Kotlin%20CI%20with%20Gradle/badge.svg

[localized]: https://badges.crowdin.net/fhossyl/localized.svg

[translate]: https://crowdin.com/project/fhossyl

[protocol]: https://wiki.vg

[ktorio]: https://ktor.io/

[serialization]: https://github.com/Kotlin/kotlinx.serialization

[coroutines]: https://github.com/Kotlin/kotlinx.coroutines