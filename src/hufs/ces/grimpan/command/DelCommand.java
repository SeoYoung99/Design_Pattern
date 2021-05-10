/**
 * Created on 2015. 4. 4.
 * @author cskim -- hufs.ac.kr, Dept of CSE
 * Copy Right -- Free for Educational Purpose
 */
package hufs.ces.grimpan.command;

import hufs.ces.grimpan.core.GrimPanModel;
import hufs.ces.grimpan.svg.SVGGrimShape;

/**
 * @author cskim
 *
 */
public class DelCommand implements Command {

	GrimPanModel model = null;
	SVGGrimShape grimShape = null;//지워질 도형을 저장할 변수 for undo
	int i;//지울 도형의 인덱스
	
	public DelCommand(GrimPanModel model){
		this.model = model;
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		i = model.getSelectedShapeIndex();
		this.grimShape = model.shapeList.get(i);//지워질 도형을 저장
		model.shapeList.remove(i);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		model.shapeList.add(grimShape);//지워졌던 도형을 다시 리스트에 추가
	}
}
