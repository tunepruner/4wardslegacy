# Diagrams
These diagrams are here to give a taste of where the project is at currently. 
### GUI layer
![gui_layer.png](gui_layer.png)

### DAO layer
![dao_layer.png](dao_layer.png)

### Persistence layer
![](persistence_layer.png)


Shows where each of the 5 windows in the GUI package will need to get its data from.
![DataNeededPerWindow.png](DataNeededPerWindow.png)


This shows the hierarchy of panes to which each editor will belong. <!-- Flow chart needed!--> 
![](GuiPackageNavigationRelated.png)

## Days Editor
This package is receiving attention before the other editors, since it is the first one a user would interact with, and also since it provides the most challenges. 

Shows how the DaysEditor class relates to Dao layer
![DaysEditorLayers.png](DaysEditorLayers.png)

Birdeye view of the dayseditor package
![CellPackageFull.png](CellPackageFull.png)

This the drag behavior of the day cells is arguably the biggest challenge in this editor. 
![](setOnMouseDraggedSequence.png)

![](setOnMouseReleased.png)