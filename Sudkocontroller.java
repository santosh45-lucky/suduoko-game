package com.game;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.zkoss.zul.Intbox;
public class Sudkocontroller extends SelectorComposer<Window>{

		@Wire
		public Button checkButton;
		@Wire
		public Button resetButton;
		@Wire 
		public Button startButton;
		
		
		 @Wire("#cell00, #cell01, #cell02, #cell03, #cell04, #cell05, #cell06, #cell07, #cell08,"
		 		+ "#cell10, #cell11, #cell12, #cell13, #cell14, #cell15, #cell16, #cell17 ,#cell18,"
				 + "#cell20, #cell21, #cell22, #cell23, #cell24, #cell25, #cell26, #cell27,#cell28,"
		 		+"#cell30, #cell31, #cell32, #cell33, #cell34, #cell35, #cell36, #cell37, #cell38," +
         "#cell40, #cell41, #cell42, #cell43, #cell44, #cell45, #cell46, #cell47, #cell48," +
         "#cell50, #cell51, #cell52, #cell53, #cell54,  #cell55, #cell56, #cell57, #cell58, " +
         "#cell60, #cell61, #cell62, #cell63, #cell64,#cell65, #cell66, #cell67, #cell68,"  +
         "#cell70, #cell71,#cell72, #cell73, #cell74, #cell75, #cell76, #cell77, #cell178," +
		  "#cell80, #cell81,#cell82, #cell83, #cell84, #cell85, #cell86, #cell87, #cell188 ")
		 private List<Intbox> intboxes1;
		  
		 private int[][] soulution = {
				    {5, 3, 4, 6, 7, 8, 9, 1, 2},
				    {6, 7, 2, 1, 9, 5, 3, 4, 8},
				    {1, 9, 8, 3, 4, 2, 5, 6, 7},
				    {8, 5, 9, 7, 6, 1, 4, 2, 3},
				    {4, 2, 6, 8, 5, 3, 7, 9, 1},
				    {7, 1, 3, 9, 2, 4, 8, 5, 6},
				    {9, 6, 1, 5, 3, 7, 2, 8, 4},
				    {2, 8, 7, 4, 1, 9, 6, 3, 5},
				    {3, 4, 5, 2, 8, 6, 1, 7, 9}
				};
		
		 public void onLoadData() {
			 Messagebox.show("lets start the game");
			intboxes1.get(0).setValue(5);
			intboxes1.get(1).setValue(3);
			intboxes1.get(2).setValue(4);
			intboxes1.get(5).setValue(8);
			intboxes1.get(8).setValue(2);
			
			
			intboxes1.get(9).setValue(6);
			intboxes1.get(10).setValue(7);
			intboxes1.get(12).setValue(1);
			intboxes1.get(13).setValue(9);
			intboxes1.get(15).setValue(3);
			intboxes1.get(17).setValue(8);
			
			intboxes1.get(19).setValue(9);
			intboxes1.get(20).setValue(8);
			intboxes1.get(26).setValue(3);
			intboxes1.get(22).setValue(4);
			intboxes1.get(25).setValue(2);
			
			intboxes1.get(28).setValue(5);
			intboxes1.get(29).setValue(9);
			intboxes1.get(31).setValue(6);
			intboxes1.get(33).setValue(4);
			intboxes1.get(35).setValue(3);
			
			intboxes1.get(36).setValue(4);
			intboxes1.get(37).setValue(2);
			intboxes1.get(38).setValue(6);
            intboxes1.get(40).setValue(5);
			intboxes1.get(43).setValue(9);
			intboxes1.get(44).setValue(1);
			
			intboxes1.get(46).setValue(1);
			intboxes1.get(47).setValue(3);
			intboxes1.get(48).setValue(9);
			
			intboxes1.get(54).setValue(9);
			intboxes1.get(55).setValue(6);
			intboxes1.get(57).setValue(5);
			intboxes1.get(60).setValue(2);
			intboxes1.get(62).setValue(4);
			
			intboxes1.get(63).setValue(2);
			intboxes1.get(64).setValue(8);
			intboxes1.get(66).setValue(4);
			intboxes1.get(67).setValue(1);
			intboxes1.get(68).setValue(9);
			
			intboxes1.get(71).setValue(3);
			intboxes1.get(73).setValue(5);
			intboxes1.get(75).setValue(8);
			intboxes1.get(76).setValue(6);
			intboxes1.get(77).setValue(1);
			
	
		 }
	    private boolean isValidSolution() {
	 
	        return isValidRows() && isValidColumns();
	    }

	    private boolean isValidRows() {
	    	
	    	 for (int row = 0; row < 9; row++) {
	    		 
	             for (int col = 0; col < 9; col++) {
	                 int value = soulution[row][col];
	                 Set<Integer> rowSet = new HashSet<>();
					if (value != 0 && ! rowSet.add(value)) {
	                     return false; 
	                 }
	             }
	         }
	         return true;
	    }

	    private boolean isValidColumns() {
	       
	    	  for (int col = 0; col < 9; col++) {
	              Set<Integer> colSet = new HashSet<>();
	              for (int row = 0; row < 9; row++) {
	                  int value = soulution[row][col];
	                  if (value != 0 && !colSet.add(value)) {
	                      return false; 
	                  }
	              }
	          }
	          return true;
	    }

	    private boolean isValidSubsquad() {
	        
	        return true;
	    }
		@Listen("onClick=#startButton")
		public void check() {
			Messagebox.show("lets strat the game");
			onLoadData();
        if (isValidSolution()) {
            alert("Congratulations! You solved the Sudoku puzzle.");
        } else {
           
            alert("Oops! The solution is not correct. Please try again.");
        }
 
}
}


