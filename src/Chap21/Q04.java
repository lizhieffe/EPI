package Chap21;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Q04 {
	
	List<Q04FileInformation> files = new ArrayList<Q04FileInformation>();
	Map<Integer, List<Q04HashCodeInformation>> hashCodeInfo = new HashMap<Integer, List<Q04HashCodeInformation>>();
	
	private void loadTextFiles() {
		File folder = new File(Q04Constant.RES_ROOT, Q04Constant.TEXT_FILES_FOLDER);
		File[] listOfFiles = folder.listFiles();
		int num = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				num++;
				Q04FileInformation fi = new Q04FileInformation(listOfFiles[i]);
				fi.loadFileContent();
				files.add(fi);
			} else if (listOfFiles[i].isDirectory()) {
			}
		}
		System.out.println(num + " files are read");
	}
	
	private void biuldHashCodeInfo() {
		for (Q04FileInformation fileInfo : files) {
			Map<Integer, Q04HashCodeInformation> allHashCodes = fileInfo.calculateAllHashCodes();
			Iterator<Map.Entry<Integer, Q04HashCodeInformation>> it = allHashCodes.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Q04HashCodeInformation> entry = it.next();
				Integer hashCode = entry.getKey();
				Q04HashCodeInformation tmp = entry.getValue();
				if (!this.hashCodeInfo.containsKey(hashCode)) {
					this.hashCodeInfo.put(hashCode, new ArrayList<Q04HashCodeInformation>());
				}
				else {
					List<Q04HashCodeInformation> tmpList = hashCodeInfo.get(hashCode);
					tmpList.add(tmp);
				}
			}
		}
	}
	
	private void findCommonFiles() {
		// skip. extract the common files from the hash codes
	}
	
	public static void main(String[] args) {
		Q04 service = new Q04();
		service.loadTextFiles();
		service.biuldHashCodeInfo();
		System.out.println();
	}
}
