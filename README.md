# Astral Metals

An exploration-focused metals mod, inspired by the spirit of Metallurgy. This branch ports the existing source to **Minecraft 1.21.1 / NeoForge 21.1.252 / Java 21**. It is not a Fabric build.

## Build and run

Install a Java 21 JDK, then open this folder as a Gradle project in IntelliJ IDEA Community. Set the project SDK and Gradle JVM to Java 21.

Linux/macOS:

```sh
bash gradlew build
```

Windows PowerShell:

```powershell
.\gradlew.bat build
```

On a low-memory machine, skip full Minecraft decompilation using the plugin's supported binary-patched artifacts:

```sh
bash gradlew -PbinaryOnly build
```

This optional mode was used for sandbox verification. For Windows, append `-PbinaryOnly` to the corresponding wrapper command.

Development client:

```sh
bash gradlew runClient
```

The first invocation downloads a pinned Gradle wrapper JAR and distribution, verifies their SHA-256 checksums, and caches them. Linux/macOS needs curl or wget and sha256sum or shasum; Windows uses PowerShell. Internet is required for the first build. The bootstrap is needed because the original repository did not contain a Gradle wrapper.

The built mod is `build/libs/astralmetals-0.1.0.jar`. Install it in a Minecraft 1.21.1 instance running NeoForge 21.1.252. Keep a backup before loading any existing world.

## Included in this port

- Preserved the 35 original metal names and registered their ingots, raw items, ores, and storage blocks.
- Registered the missing tungsten-steel ingot, Orithichalite scrap, upgrade template, and Orithichalite sword.
- Ported all five tungsten-steel tools to deferred NeoForge registration and modern tool attributes.
- Migrated recipe folder names, result fields, and smithing recipe type to 1.21.1.
- Replaced the two empty tungsten-steel recipe files with working alloy and tool recipes.
- Added tool repair ingredients, storage-block recipes, mining tags, block loot, and Fortune/Silk Touch behavior.
- Corrected worldgen vertical anchors and added biome modifiers for the original four ore features.
- Ported the original music disc to 1.21 jukebox-song data using the existing audio and measured duration.
- Added a creative tab, English names, vanilla-backed placeholder models, CI, and server-backed regression tests.

## Deliberately provisional

- All visual models use vanilla textures as placeholders. Original ore/tool artwork is still needed.
- New recipe defaults and Orithichalite sword stats are development defaults, not approved balance.
- Tungsten-steel currently combines one tungsten ingot and one steel ingot into two alloy ingots. The custom template recipe is eight diamonds around an Orithichalite ingot.
- Only Adamantite, Ardanium, Arthilite, and Orithichalite have natural generation. Other materials are available in Creative but still need an acquisition/progression design.
- There is no armor set, gun, new dimension, or Alloy Forge implementation in this port.
- Create interoperability uses common material tags and stable Astral Metals IDs. The old conditional skipping of zinc/brass has been removed to avoid missing recipe IDs. A Create compatibility play-test is still needed.

## Source layout and tests

`src/main/java` is the active NeoForge source. The original `maIn/`, `tools/`, and `registry/` trees are preserved as historical Fabric references and are not compiled. The old `resources/data/astralmetals/recipes` tree is excluded from the JAR; active recipes use `recipe`.

`src/test/java` contains server-backed checks for registration, recipe loading, worldgen, loot, and music data. They run as part of `build`. Test classes are not packaged in the release JAR. GitHub Actions builds and uploads the JAR without publishing a release.

## Before using this in Zero Point

Port or select one material chain rather than importing the whole roster. Confirm artwork, balance, natural generation, single-player behavior, multiplayer behavior, and permission to redistribute the music asset. This port preserves the existing sound file but does not establish its licensing.
