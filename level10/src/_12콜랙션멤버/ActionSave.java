package _12콜랙션멤버;

public class ActionSave implements Action{

	@Override
	public void excute() {
		utils.getInstance().save(memberDAO.makeData());
	}

}
