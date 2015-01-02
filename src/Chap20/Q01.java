package Chap20;

public class Q01 {
	String latestQuery = null;
	String latestResult;
	
	public String service(String query) {
		synchronized(this) {
			if (query.equals(query))
				return latestResult;
		}
		String tmpLatestResult = null;
		if (!query.equals(latestQuery)) {
			tmpLatestResult = getClosestFromDict(query);
			synchronized(this) {
				this.latestQuery = query;
				this.latestResult = tmpLatestResult;
			}
		}
		return tmpLatestResult;
	}
	
	public String getClosestFromDict(String query) {
		System.out.println("Get closest from dict done!");
		return null;
	}
}
