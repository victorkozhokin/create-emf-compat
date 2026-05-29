# Create Fly - EMF Compat (Skyhook)

## [Modrinth](https://modrinth.com/mod/create-emf-compat-(skyhook))


A small client-side mod for **Minecraft** that pauses **Entity Model Features** player animations while using Create's **Skyhook**.

Tested with Fresh Animations: Player Extension but it should work with any player animation RP.

And side effects to Climbable Ropes for Create Aeronautics.

## Video

[![EMF Skyhook Animation Pause](https://img.youtube.com/vi/072A-CVufho/maxresdefault.jpg)](https://youtu.be/072A-CVufho?si=IvY1qwvvB6avab2r)

## Dependencies
Fabric:
- [Fabric](https://fabricmc.net) 21.1+
- [Create Fly](https://modrinth.com/mod/create-fly) 6.0.9+

NeoForge:
- [NeoForge](https://neoforged.net/) 21.1+
- [Create](https://modrinth.com/mod/create) 6.0.10+

General:
- [Entity Model Features](https://modrinth.com/mod/entity-model-features) 3.2.4+
- [Entity Texture Features](https://modrinth.com/mod/entitytexturefeatures) Required for EMF

## Optional Dependencies
Only for NeoForge 1.21.1:

- [Create Aeronautics](https://modrinth.com/project/BVzZfTc1)
- [Climbable Ropes for Create Aeronautics](https://modrinth.com/mod/create-aeronautics-climbable-rope)
## Build

```bash
./gradlew build
```

For development, put the Create, EMF and ETF jars in `libs/` (see `build.gradle`).