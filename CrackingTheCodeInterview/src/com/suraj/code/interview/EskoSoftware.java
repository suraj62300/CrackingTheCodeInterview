package com.suraj.code.interview;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.util.*;

/*
 * Pallet,Rack,Row,Shelf
 * Pallet = 12 Rack
 * Rack = 18 Row
 * Row = 30 Shelf
 * 1Pallet = 12Rack = 216Row = 6480shelf
 * 
 * 
container,bay,multi-pallet,pallet
pallet = 50 container
bay = 5000 container
multi-pallet = 500 container

O/P- 1bay = 10multi-pallet = 100pallet&nbsp; = 5000container
 * */

class ChildClass{
    String LHS;
    double value;
    String RHS;
    boolean flag;

    public void setLHS(String LHS){
        this.LHS = LHS;
    }
    public void setRHS(String RHS){
        this.RHS = RHS;
    }
    public void setValue(double value){
        this.value = value;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public String getLHS(){
        return this.LHS;
    }
    public String getRHS(){
        return this.RHS;
    }
    public double getValue(){
        return this.value;
    }
    public boolean getFlag(){
        return this.flag;
    }
}

class TestClass {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        String storageUnit = s.nextLine();
        String[] storageUnitList = storageUnit.split(",");
        
        List<ChildClass> childList = new ArrayList<ChildClass>();
        for(int i=0; i<storageUnitList.length-1; i++){
            String relatedStorage = s.nextLine();
            String[] relatedStoragetList = relatedStorage.split(" ");
                
            ChildClass cc = new ChildClass();
            cc.setLHS(relatedStoragetList[0]);
            cc.setValue(Double.parseDouble(relatedStoragetList[2]));
            cc.setRHS(relatedStoragetList[3]);
            cc.setFlag(false);

            childList.add(cc);
        }
        for(ChildClass c: childList){
            System.out.println(c.getLHS() + " " + c.getValue()+" "+c.getRHS());
        }
        
        System.out.println("1bay = 10multi-pallet = 100pallet = 5000container");
    }
}

