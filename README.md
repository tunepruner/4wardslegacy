<br />

<p align="center">
  <a href="https://github.com/tunepruner/4wards">
    <img src="Documentation/Images/4wardsICON.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">4wards</h3>

  <p align="center">
    A tool for independent learners
    <br />
  </p>
</p>

## What is 4wards?
### A desktop application
4wards will be a cross-platform GUI app, with a design that contemplates later expansion to support 
cloud back-up and a mobile client.
 
### Description
It's an effort tracker designed specifically for the independent learner. 
What sets it apart is its clock-out dialogue, which allows a user to 
easily associate a work session with <i>multiple</i> work topics, in varying 
amounts. In that dialogue, other specific info is collected and then used
to generate visualizations. The goal is to bring the user into a loop 
of generating and relishing gratifying data generated from recorded 
productivity time.

For a detailed description, see - the [MVP](Documentation/4wardsConcept/MVP.md).

## Progress

This application is under construction. Various experiments with 
different features can be found at these repos:
- [4wardsPOC1a](https://github.com/tunepruner/4wards_POC1.a_MultiList)
- [4wardsPOC1b](https://github.com/tunepruner/4wards_POC1.b_editor)
- [4wardsPOC1c](https://github.com/tunepruner/4wards_POC1.c_navigation)

This, being the main repo, has shell classes, packages, and some shell 
methods, but no implementation yet. 
It is transitioning from the design stage to the test plan stage. 
My goal is to adhere as well as possible to TDD techniques 
throughout the process. I aim to begin with a full architecture 
containing dummy components and gradually switch them out with fully working 
ones.

The Documentation directory is where most things are happening at present. 

## Things you'll need

- Java SDK 1.8 (includes JavaFX)
- JUnit 5
- Mockito
- A Plant UML plugin (if you want to view the diagrams on your machine)

## Docs At a Glance

In the directory Documentation/4wardsConcept, you can find:
- a [problem statement](Documentation/4wardsConcept/ProblemStatements.md),
- a [product vision](Documentation/4wardsConcept/ProductVision.md),
- the [MVP requirements](Documentation/4wardsConcept/MVP.md),
- the [post MVP overflow](Documentation/4wardsConcept/PostMvpOverflow.md)
- a [collection of diagrams](Documentation/PUML) written in plant uml code that are maintained in version control as the evolve. Since github doesn't have a plant uml parser (yet), [here are some rendered images](Documentation/PngExportsPuml/WithExplanation.md) to look at

## License

Distributed under the MIT License. See [`LICENSE`](LICENSE.txt) for more information.
