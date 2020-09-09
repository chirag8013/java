package utilities;

import io.restassured.response.Response;

public class utilities {
	
	
	public void getdetails(String variable, int RespArraySize, Response resp){
		
for(int i=0; i<RespArraySize;i++){
			
			if(resp.jsonPath().getList("").get(i).toString().contains(variable)){
				
				System.out.println(resp.jsonPath().getList("").get(i));
			}
		}
		
		
	}
}
