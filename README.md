# Createless Trains

This addon to Create Fabric (6.0.8.1+build.1744-mc1.20.1) was created for the Beyond Beta modpack.
It makes trains easier to use without needing the rest of Create.

Specific Changes:
- Display Boards no longer require power, and are now solid rather than hollow. The internal cogs have been removed. (They still display in ponders, haven't figured out how to remove them there)
- Steam Whistles can be placed anywhere, not just on fluid tanks, and only require redstone power to be activated.
- Train Stations can now manually accept schedules from the player's hand.
- All ponders not related to trains have been removed, and train related ponders have all been edited to remove blocks and text and mechanics related to other non train components in Create.
- Seat tooltips have been removed.
- The Wrench tooltip now only describes how it interacts with trains.
- Vanilla doors now open and close automatically on trains when arriving and leaving stations, just like Create's train doors and framed glass doors.
- Removed "Deliver Package" and "Receive Package" from Train Schedules

It also enables Embeddium compatibility by disabling a Sodium specific fix for the saw sprite texture atlas which crashes when Embeddium is loaded with Create.
Embeddium compatibility still requires overriding Flywheel's fabric loader dependency marking itself as breaking with embeddium.
- `config/fabric_loader_dependencies.json`
```
{
  "version": 1,
  "overrides": {
    "flywheel": {
      "-breaks": {
        "embeddium": "IGNORED"
      }
    }
  }
}
```

## Setup

This mod was developed using this template: https://github.com/Fabricators-of-Create/create-fabric-addon-template

## Credits
- Thank you to https://github.com/skycatminepokie for helping me figure out mixins for this mod on the Fabric discord!
- Display Board back texture edited version of https://modrinth.com/resourcepack/create-world-of-color by @gracedatgirl

## License

This mod is available under the MPL 2.0 license https://www.mozilla.org/en-US/MPL/2.0/
