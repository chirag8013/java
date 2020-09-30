package utilities;

import java.util.Iterator;

import io.restassured.response.Response;

public class utilities {
	
	
	public void getdetails(String variable, int RespArraySize, Response resp){
		
for(int i=0; i<RespArraySize;i++){
			
			if(resp.jsonPath().getList("").get(i).toString().contains(variable)){
				
				System.out.println(resp.jsonPath().getList("").get(i));
				
				
			}
		}
		
		
	}
	
	public void getdetailsbasedonratingactionid(String ratingactionid,String analystLocation,int RespArraySize, Response resp){
		for(int i=0; i<RespArraySize;i++){
			//if(resp.jsonPath().getList("ratingActionID").get(i).equals(ratingactionid)){
				//System.out.println("BELOW RESPONSE CONTAINS "+resp.jsonPath().getList("ratingActionID").get(i).toString());
			//}
			//if(resp.jsonPath().getList("analystLocation").get(i).equals(analystLocation)){
				//System.out.println("BELOW RESPONSE CONTAINS "+resp.jsonPath().getList("analystLocation").get(i).toString());
			//}
					
		if(resp.jsonPath().getList("ratingActionID").get(i).equals(ratingactionid)&&resp.jsonPath().getList("analystLocation").get(i).equals(analystLocation)){
			System.out.println("ratingActionName is " + resp.jsonPath().getList("ratingActionName").get(i));
			System.out.println("officeName is " + resp.jsonPath().getList("officeName").get(i));
			System.out.println("pressReleaseId is " + resp.jsonPath().getList("pressReleaseId").get(i));
			System.out.println("indicativeRatingInd is " + resp.jsonPath().getList("indicativeRatingInd").get(i));
			System.out.println("workItemType is " + resp.jsonPath().getList("workItemType").get(i));
			System.out.println("leadAnalystName is " + resp.jsonPath().getList("leadAnalystName").get(i));
			System.out.println("approverName is " + resp.jsonPath().getList("approverName").get(i));
			System.out.println("pacrEmail is " + resp.jsonPath().getList("pacrEmail").get(i));
			System.out.println("sublobname is " + resp.jsonPath().getList("sublobname").get(i));
			System.out.println("pacr is " + resp.jsonPath().getList("pacr").get(i));
			System.out.println("securityClassNm is " + resp.jsonPath().getList("securityClassNm").get(i));
			System.out.println("addendum is " + resp.jsonPath().getList("addendum").get(i));
			System.out.println("leadAnalystID is " + resp.jsonPath().getList("leadAnalystID").get(i));
			System.out.println("analystLocation is " + resp.jsonPath().getList("analystLocation").get(i));
			System.out.println("ratingOffice is " + resp.jsonPath().getList("ratingOffice").get(i));
			System.out.println("workItemReleaseDtm is " + resp.jsonPath().getList("workItemReleaseDtm").get(i));
			System.out.println("analystEmail is " + resp.jsonPath().getList("analystEmail").get(i));
			System.out.println("ratingShellDS is " + resp.jsonPath().getList("ratingShellDS").get(i));
			System.out.println("chairEmail is " + resp.jsonPath().getList("chairEmail").get(i));
			System.out.println("leadAnalystUniqueId is " + resp.jsonPath().getList("leadAnalystUniqueId").get(i));
			System.out.println("complianceID is " + resp.jsonPath().getList("complianceID").get(i));
			System.out.println("definitiveRatingPrevProvisional is " + resp.jsonPath().getList("definitiveRatingPrevProvisional").get(i));
			System.out.println("contactPersonId is " + resp.jsonPath().getList("contactPersonId").get(i));
			System.out.println("linkedAnotherActionInd is " + resp.jsonPath().getList("linkedAnotherActionInd").get(i));
			System.out.println("secondaryactionind is " + resp.jsonPath().getList("secondaryactionind").get(i));
			System.out.println("subsequentRatingInd is " + resp.jsonPath().getList("subsequentRatingInd").get(i));
			System.out.println("region is " + resp.jsonPath().getList("region").get(i));
			System.out.println("ratingActionDesc is " + resp.jsonPath().getList("ratingActionDesc").get(i));
			System.out.println("documentExceptionListingInd is " + resp.jsonPath().getList("documentExceptionListingInd").get(i));
			System.out.println("sourceSystem is " + resp.jsonPath().getList("sourceSystem").get(i));
			System.out.println("approverID is " + resp.jsonPath().getList("approverID").get(i));
			System.out.println("ratingShellId is " + resp.jsonPath().getList("ratingShellId").get(i));
			System.out.println("workItemStatus is " + resp.jsonPath().getList("workItemStatus").get(i));
			System.out.println("shadowCd is " + resp.jsonPath().getList("shadowCd").get(i));
			System.out.println("ratingCommitteeDate is " + resp.jsonPath().getList("ratingCommitteeDate").get(i));
			System.out.println("orgId is " + resp.jsonPath().getList("orgId").get(i));
			System.out.println("complianceType is " + resp.jsonPath().getList("complianceType").get(i));
			System.out.println("workItemSubType is " + resp.jsonPath().getList("workItemSubType").get(i));
			System.out.println("pressReleaseType is " + resp.jsonPath().getList("pressReleaseType").get(i));
			System.out.println("announcementInd is " + resp.jsonPath().getList("announcementInd").get(i));
			System.out.println("automaticRating is " + resp.jsonPath().getList("automaticRating").get(i));
			System.out.println("ratingReleaseDate is " + resp.jsonPath().getList("ratingReleaseDate").get(i));
			System.out.println("privateRatingActionInd is " + resp.jsonPath().getList("privateRatingActionInd").get(i));
			System.out.println("ratingActionID is " + resp.jsonPath().getList("ratingActionID").get(i));
			System.out.println("releaseDate is " + resp.jsonPath().getList("releaseDate").get(i));
			System.out.println("addendumEmail is " + resp.jsonPath().getList("addendumEmail").get(i));
			System.out.println("definitiveRatingInd is " + resp.jsonPath().getList("definitiveRatingInd").get(i));
			System.out.println("chair is " + resp.jsonPath().getList("chair").get(i));
			System.out.println("lobname is " + resp.jsonPath().getList("lobname").get(i));
			System.out.println("pyrRatingType is " + resp.jsonPath().getList("pyrRatingType").get(i));
			System.out.println("provisionalRatingInd is " + resp.jsonPath().getList("provisionalRatingInd").get(i));
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------------");
			System.out.println();
			
			
			
		}
		}
				
				
			}
}
