<br />

<p align="center">
  <a href="https://github.com/tunepruner/4wards">
    <img src="Documentation/Images/4wardsICON.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">4wards</h3>

  <p align="center">
    An tool for independent learners
    <br />
  </p>
</p>

## What is 4wards?
### A desktop application
4wards will be a cross-platform GUI application, designed to expand to 
multi-device sync and cloud back-up.
 
### Description
It's an effort tracker designed specifically for the independent  
learner. What sets it apart is its clock-out dialogue, 
which allows a user to easily associate a work session with <i>multiple</i> 
work topics. In that dialogue, other specific info is collected and then used
to generate visualizations. The goal is to bring the user into a loop 
of generating and relishing gratifying data generated from work-time recorded.

For a detailed description, see - the [MVP](Documentation/4wardsConcept/MVP.md).
More info is available in the Documentation directory (see below for links).

## Progress

This application is under construction. Various experiments with 
different features can be found at these locations:
- [4wardsPOC1a](https://github.com/tunepruner/4wards_POC1.a_MultiList)
- [4wardsPOC1b](https://github.com/tunepruner/4wards_POC1.b_editor)
- [4wardsPOC1c](https://github.com/tunepruner/4wards_POC1.c_navigation)

This, being the main repo, has shell classes, packages, and some shell 
methods, but no implementation yet. 
It is transitioning from the design stage to the test plan stage. 
My goal is to apply TDD techniques to maximize technical agility. I aim to 
begin with a full architecture 
containing dummy components and gradually switch them out with fully working 
ones.

The Documentation directory is where most things are happening at present. 

## Dependencies

- Java SDK 1.8 (includes JavaFX)
- JUnit 5
- Mockito
- IntelliJ PlantUML plugin (for viewing .puml files and .md files, 
some of which contain embedded puml code. Not sure if the embedded stuff can 
be viewed with any other plugin...)

## Docs At a Glance

In the directory Documentation/4wardsConcept, you can find:
- a [problem statement](Documentation/4wardsConcept/ProblemStatements.md),
- a [product vision](Documentation/4wardsConcept/ProductVision.md),
- the [MVP requirements](Documentation/4wardsConcept/MVP.md),
- the [post MVP overflow](Documentation/4wardsConcept/PostMvpOverflow.md),

## License

Distributed under the MIT License. See [`LICENSE`](LICENSE.txt) for more information.
