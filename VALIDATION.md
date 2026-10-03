# Verification

Base repository commit: `04a8256af4804eac54dbc3178df071a6abf56be4`.

Verified locally with Java 21, Minecraft 1.21.1, NeoForge 21.1.252, and Gradle 9.2.1:

```sh
bash gradlew --no-daemon --max-workers=1 -PbinaryOnly clean build
```

Result: **BUILD SUCCESSFUL**, five tests passed, zero failures or errors.

Checks cover all original metal registrations, additional items, nonempty tungsten-steel repair ingredient, all 184 active recipes, all 70 block loot tables, four placed features, jukebox-song data, item models and English names, and actual Adamantite/Ardanium feature injection into Overworld/Nether biomes.

All 597 active JSON resources parsed successfully. The built JAR contains metadata and the original music; it excludes the old recipe directory, backups, and test classes.

Limitations: no interactive client play-test, no multiplayer play-test, no Create compatibility test, and no Windows wrapper execution in this Linux environment. Artwork uses vanilla placeholders. Additional ore progression and provisional balance need review.

The normal source-recompiling development mode exceeded this sandbox's memory budget during dependency setup. Verification used the plugin's supported binary-patched mode instead. This does not skip compiling the mod or running the server-backed tests.

No changes were pushed to GitHub because the connected integration rejected write access. Apply the included patch to the base checkout or use the full source ZIP.
