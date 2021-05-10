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
	SVGGrimShape grimShape = null;//������ ������ ������ ���� for undo
	int i;//���� ������ �ε���
	
	public DelCommand(GrimPanModel model){
		this.model = model;
		
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		i = model.getSelectedShapeIndex();
		this.grimShape = model.shapeList.get(i);//������ ������ ����
		model.shapeList.remove(i);
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		model.shapeList.add(grimShape);//�������� ������ �ٽ� ����Ʈ�� �߰�
	}
}
