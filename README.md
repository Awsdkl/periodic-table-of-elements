# <div align="middle"> Periodic Table of Elements </div>

Periodic table of elements is a mod that provides a full industrial machines and implements a full periodic table of
elements at Minecraft.

## Installation

1. Download the jar version of mod at Release page
2. Put the mod file in the mods folder of your game (Fabric Loader and Fabric API required)
3. Launch game

## Build

### Windows

**Release Version**

1. Download a release version of source code at release page
2. Extract the zip file
3. run `./gradlew.bat build` at powershell in the current folder (JDK 17 is required, we recommend the Microsoft build of JDK 17)

Alternatively, you can use Intellij Idea to build the project.

1. Download Intellij Idea at the official website (Community Edition is free)
2. Install Intellij Idea
3. Open the Plugins and install `Minecraft Dev`
4. Restart Intellij Idea
5. Download a release version of source code at release page
6. Extract the zip file into a folder
7. Open the folder with Intellij Idea, the project will be built without actions

**Git version**

1. Download and install a Windows version of git

2. Clone this repo

    ```powershell
    git clone https://github.com/Awsdkl/periodic-table-of-elements.git
    ```

3. Enter the folder with powershell and run `./gradlew.bat build`

    ```powershell
    cd periodic-table-of-elements
    ./gradlew.bat build
    ```

Alternatively Intellij Idea is able to build the project

1. Download and install Intellij Idea

2. Install `Minecraft Dev` plugin at the tab `Plugins`

3. Add a project with version control, choose git as the controller, and fill the URL
   with `https://github.com/Awsdkl/periodic-table-of-elements.git`

4. Intellij Idea will build the project without actions

### macOS / Linux

**macOS Users**: Please make sure that Xcode (or Xcode select) is installed.

1. Install git and Java Development Kit 17

    macOS (Ignore if you have already installed Xcode)

    ```sh
    sudo xcode-select install
    ```

    Arch Linux

    ```sh
    yay -S git amazon-corretto-17
    # or use paru
    # paru -S git amazon-corretto-17
    ```

2. clone this repository

    ```sh
    git clone https://github.com/Awsdkl/periodic-table-of-elements.git
    ```

3. Enter the folder and run build command

    ```sh
    cd periodic-table-of-elements
    chmod +x gradlew
    ./gradlew build
    ```

## Contribute this project

No matter who you are, no matter what you can do. If you are interested in the project, you can contribute this project!

It doesn't matter if you are not a programmer, you can provide translations, textures, sound affects e.t.c.

And please report issues if you met any problems of this mod while playing. We will work on the a.s.a.p.

Please read CONTRIBUTION.md for more information

## License

MIT License

## Thanks to

- Minecraft
- All the contributors of the repository
