package dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class Client extends CommonFunctionsOfCMSAndEMS{
        public  String billAmount;
        public  String tenure;
        public String getBillAmount() {
			return billAmount;
		}
		public void setBillAmount(String billAmount) {
			this.billAmount = billAmount;
		}
		public String getTenure() {
			return tenure;
		}
		public void setTenure(String tenure) {
			this.tenure = tenure;
		}
		public Map<String,String> getDataOfClient(Client client) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("id", client.getUid());
			map.put("fname", client.getFname());
			map.put("lname", client.getLname());
			map.put("number", client.getNumber());
			map.put("email", client.getEmail());
			map.put("billamount", client.getBillAmount());
			map.put("tenure", client.getTenure());
			
			return map;
		}
        
}
