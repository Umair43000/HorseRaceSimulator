# HorseRaceSimulator

## Setup Instructions

1. **Clone the Repository**
   - Start by cloning the repository to your local machine using the following command:
     ```bash
     git clone https://github.com/Umair43000/HorseRaceSimulator.git
     ```

2. **Navigate to the Project Directory**
   - After cloning the repository, navigate into the project directory:
     ```bash
     cd HorseRaceSimulator
     ```

3. **Open the Project in Your IDE**
   - Open the project folder (`HorseRaceSimulator`) in your preferred IDE such as VScode.

4. **Run the Project**
   - To run the project, navigate to the `Part2/` folder for the graphical version of the game and run `RacingGameGUI.java`.

## Dependencies

The following dependencies are required to run the project:

- **Java Development Kit (JDK)**: 
  - This project is written in Java. You should have JDK 8 or a newer version installed on your machine.
  - To download JDK, visit: [JDK Download](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html).

- **Swing** (Optional for GUI development):
  - If you are using the graphical user interface, Swing is required.

## Usage Guidelines

### Part I: Textual Version

1. **Navigate to the `Part1/` folder.**
   - This folder contains the text-based version of the game. It includes the core classes such as `Horse.java` and `Race.java`.

2. **Running the Textual Version**:
   - To run the textual version, open `Horse.java` and `Race.java` and run them sequentially.

   Example:
   ```bash
   java Part1.Horse
   java Part1.Race


1. Create a new file named `README.md` in the root of your `HorseRaceSimulator` directory.
2. Copy and paste the content above into the `README.md` file.
3. **Stage, commit, and push** the `README.md` file to your GitHub repository:

```bash
git add README.md
git commit -m "Added README file with setup and usage instructions"
git push origin main

# HorseRaceSimulator

This is a project for a horse racing simulation game, which includes both a **textual version** (Part 1) and a **graphical version** (Part 2).

## Setup Instructions

To run the project locally:

1. Clone the repository:

    ```bash
    git clone https://github.com/Umair43000/HorseRaceSimulator.git
    ```

2. Navigate into the project directory:

    ```bash
    cd HorseRaceSimulator
    ```

3. Compile and run the project using your Java IDE or from the terminal.

## Dependencies

- Java 8 or later
- Swing for graphical user interface (GUI)

## Usage Guidelines

- **Part 1**: Text-based version of the game. The user interacts with the console for race configuration, betting, and viewing results.
- **Part 2**: Graphical version of the game with a GUI. The user interacts with the interface to customize the track, horses, place bets, and view the race in action.

## Branching for GUI Development

To work on the GUI module, a separate branch called `gui-development` was created. Here's how to work with this branch:

1. **Create a new branch for GUI development**:

    - First, check out the `gui-development` branch:

      ```bash
      git checkout -b gui-development
      ```

2. **Work on the GUI module**:

    - All your changes related to the graphical user interface (GUI) should be made in this branch. This includes:
      - Designing and implementing the race GUI.
      - Adding components like buttons, panels, and event listeners for the GUI.
      - Any other features related to the graphical version of the game.

3. **Commit your changes**:

    - After making changes to the GUI, commit them with a clear message, for example:

      ```bash
      git add .
      git commit -m "Implemented race display in GUI"
      ```

4. **Merging back into the main branch**:

    - After you’ve finished implementing the GUI features, you will need to merge the changes back into the main branch. Here are the steps:

      - First, switch back to the `main` branch:

        ```bash
        git checkout main
        ```

      - Then, merge the `gui-development` branch into `main`:

        ```bash
        git merge gui-development
        ```

      - If there are any conflicts during the merge, resolve them manually. Git will mark the conflicting files, and you’ll need to edit those files and commit the changes.

      - Finally, push the merged changes to the repository:

        ```bash
        git push origin main
        ```

By following these instructions, you can keep the graphical user interface development separate from the core game logic and maintain a clean main branch.

---

This will ensure that anyone who looks at your repository's README.md will understand how to handle the branching for GUI development and work with it effectively.

---

### After writing these instructions:
1. **Save the README.md file** after making the changes.
2. **Commit the README.md file** with the new instructions:

```bash
git add README.md
git commit -m "Added branching instructions for GUI development"
