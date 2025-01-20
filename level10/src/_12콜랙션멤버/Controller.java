package _12콜랙션멤버;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	
	Utils utils=new Utils();
	private Map<Menu, Action> mapList;
	int start;
	int end;
	
	public Controller(){
		mapList = new HashMap<Menu, Action>();
		mapList.put(Menu.INSERT , new ActionInsert());
		mapList.put(Menu.DELETE , new ActionDelete());
		mapList.put(Menu.UPDATE , new ActionInsert());
		mapList.put(Menu.PRINT , new ActionInsert());
		mapList.put(Menu.SAVE , new ActionInsert());
		mapList.put(Menu.LOAD , new ActionInsert());
	}
	
	public Action getAction(Menu key) {
		return mapList.get(key);
	}
	
	public void run() {
		while (true) {
			System.out.println("========== 메뉴 ==========");
			System.out.println("1) 추가"); // id 중복제거 
			System.out.println("2) 삭제"); // id 로 삭제 
			System.out.println("3) 수정"); // id로 삭제 -> 비번 검색 -> 비번 맞으면 이름 수정 
			System.out.println("4) 출력"); // 이름순 으로 출력 
			System.out.println("5) 저장"); // member.txt  => id 순으로 저장 
			System.out.println("6) 로드"); //member.txt 로드
			System.out.println("0) 종료"); 
			start=0;
			end=6;
			int sel=Utils.getInstance().inInt(null, start, end);
			if(sel==1){
				// 추가하는 기능 DAO
				getAction(Menu.INSERT).excute();
			}else if(sel==2){
				getAction(Menu.DELETE).excute();
			}else if(sel==3){
				getAction(Menu.UPDATE).excute();
			}else if(sel==4){
				getAction(Menu.PRINT).excute();
			}else if(sel==5){
				getAction(Menu.SAVE).excute();
			}else if(sel==6){
				getAction(Menu.LOAD).excute();
			}else {
				System.out.println("=================");
				System.err.println("프로그램 종료");
				break;
			}
		}
	}
}
