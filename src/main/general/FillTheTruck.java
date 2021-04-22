package general;

import java.util.*;

/*
boxes are all the same size
diffrent # of units eac product fit in a box
truck holds x numer of boxes


boxes = [1,2,3] //number of boxes avalaible for each product size, length = num
unitsPerbox = [2,3,4] // length = unitSize
truckSize = maax number of boxes on the truck


//Straegy
//map units to number of boxes and keep in tree map (we always need bigest)
//assume no two types of items have same number of units ina  box
//Use a hashmap that associted number of boxes with number of keys
//Use all the boxes that hold the max units first then decresae
//decrement trucksize for every box used, decrement appropriate category in boxes
//add to counter associted untis per that box

 */
public class FillTheTruck {
    public int fillTheTruck(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, int truckSize) {

    }
}
