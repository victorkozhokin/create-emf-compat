# Create-EMF Compat (Skyhook)

## [Modrinth](https://modrinth.com/mod/create-emf-compat-(skyhook))


A small client-side mod for **Minecraft 1.21.1** (NeoForge) that pauses **Entity Model Features** player animations while using Create's **Skyhook** feature, like chain and rope riding from Aeronautics.

Tested with Fresh Animations: Player Extension but it should work with any player animation RP.

And side effects to Climbable Ropes for Create Aeronautics because Climbable ropes uses original skyhook (bless to dev of mod)

## Video

[![EMF Skyhook Animation Pause](https://img.youtube.com/vi/072A-CVufho/maxresdefault.jpg)](https://youtu.be/072A-CVufho?si=IvY1qwvvB6avab2r)

## Dependencies

- [NeoForge](https://neoforged.net/) 21.1+
- [Create](https://modrinth.com/mod/create) 6.0.10+
- [Entity Model Features](https://modrinth.com/mod/entity-model-features) 3.2.4+
- [Entity Texture Features]() Required for EMF

## Optional Dependencies
- [Create Aeronautics](https://modrinth.com/project/BVzZfTc1)
- [Climbable Ropes for Create Aeronautics](https://modrinth.com/mod/create-aeronautics-climbable-rope)
## Build

```bash
./gradlew build
```

Output jar: `build/libs/create_emf_compat-1.0.jar`

For development, put the Create, EMF and ETF jars in `libs/` (see `build.gradle`).