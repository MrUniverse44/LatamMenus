# LatamMenus

> The best alternative to paid menus plugins and other free plugins with limitations
> Totally FREE

## Features
* 1.8.x - 1.21.x support
* Java 17 and higher support
* Conditions for actions and display
* PlaceholderAPI Support
* Different menus
* And more!

# Docs

## ¿How can I put a skull texture?

For legacy versions try, for example:
```Yml
"texture:eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWMyNTBiNDdlMTBhNTBkNjkxNjZjYjBlY2FmMjM0MTAwY2FlNzg5OWE0ODk4MTA4YzEzMDcwMTdhNWE3ZWJiMyJ9fX0="
```
for new versions try:
```Yml
"texture:https://textures.minecraft.net/texture/3ce4f211264b6e3f263202959494a87e3e86869c0bf9d17bc941ad78bb884f13"
```

These values are in the material path.

## ¿How can I create a condition?

These are different condition system:
The Open conditions
path:
```Yml
menu-settings:
  open-conditions: []
```

The Per-Item display conditions:
```Yml
items:
  <item-path>:
    display-condition: []
```

with this display-condition we have another path, if the player don't have these conditions, to display another item:
```Yml
items:
  <item-path>:
    without-conditions: []
```

you have conditions for actions:
```Yml
items:
  <item-path>:
    actions-condition: []
```

and if these conditions fails we have another action path for failed conditions
```Yml
items:
  <item-path>:
    failed-actions-conditions: []
```

## ¿How can I edit menu configuration?

```Yml
menu-settings:
  # We support numbers from 1 to 6  
  rows: 1
  # Title of tis menu
  name: "Here your menu name
```

## Action List:

```
You can see action list with the command in-game: /latammenus actions
```

The action path is
``` Yaml
items:
  <item-path>:
    actions: []
```

## Plugin Permissions
```
Only we have 1 permission by default, for commands: latammenus.admin
```

## Plugin Item config:

Entire item config:

```Yml
items:
  <item-path>:
    material: ""
    name: ""
    lore: []
    amount: 1
    enchantments: []
    display-condition: []
    without-conditions:
      material: ""
      name: ""
      amount: 1
      lore: []
      enchantments: []
    slot: 1
    slots: []
    actions-condition: []
    actions: []
    failed-actions-conditions: []
```

All paths are optional except for Material, name and any slot path.

# Firework charge colors:

```Yml
items:
  <item-path>:
    charge-color: RED
```