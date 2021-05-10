package hufs.ces.grimpan.state;

import hufs.ces.grimpan.core.GrimPanModel;
import hufs.ces.grimpan.core.ShapeFactory;
import hufs.ces.grimpan.svg.SVGGrimLine;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class DeleteBuilderState implements EditState {

	   ShapeFactory sf = null;   
	   GrimPanModel model = null;
	   
	   public DeleteBuilderState(GrimPanModel model, ShapeFactory sf){
	      this.model = model;
	      this.sf = sf;
	   }
	   @Override
	   public int getStateType() {
	      return EditState.EDIT_DELETE;
	   }
	   @Override
	   public void performMousePressed(MouseEvent event) {
	      Point2D p1 = new Point2D(Math.max(0, event.getX()), Math.max(0, event.getY()));
	      model.setStartMousePosition(p1);
	      model.setCurrMousePosition(p1);
	      model.setPrevMousePosition(p1);      
	     
	      model.getSelectedShape_del(); //MouseEvent 발생하면 해당도형을 가져와서
	      model.deleteShapeAction(); //delete 실행
	   }
	   @Override
	   public void performMouseReleased(MouseEvent event) {
	      
	   }
	   @Override
	   public void performMouseDragged(MouseEvent event) {
	     
	   }
	}
