package Coffee.info.control;

import Coffee.info.service.RelationService;

public class RelationAction {
	private RelationService relationService;
	private String[] relation_key;
	private String my_relation;
	
	public RelationService getRelationService() {
		return relationService;
	}

	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	public String[] getRelation_key() {
		return relation_key;
	}

	public void setRelation_key(String[] relationKey) {
		relation_key = relationKey;
	}

	public String getMy_relation() {
		return my_relation;
	}

	public void setMy_relation(String myRelation) {
		my_relation = myRelation;
	}

	
	public String doInitRelationAction(){
		if (relationService.initRelation()) {
			return "success";
		}else{
			return "fault";
		}
		
	}
	
	public String docreateRelationAction(){
		if (relationService.createRelation(relation_key, my_relation)) {
			return "success";
		}else {
			return "fault";
		}
	}
	
	public String doremoveRelationAction(){
		if (relationService.removeRelation(relation_key)) {
			return "success";
		}else {
			return "fault";
		}
	}
}
