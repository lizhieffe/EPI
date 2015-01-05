package Chap21;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Q04FileInformation {
	
	String content;
	File file;
	
	private static int base = 131;
	private static int mod = 171;
	private static int RM;
	
	Q04FileInformation(File file) {
		this.file = file;
		int tmp = 1;
		for (int i = 0; i < Q04Constant.HASH_FUNCTION_BASE_LENGTH - 1; i++)
			tmp = (tmp * base) % mod;
		RM = tmp;
	}
	
	public void loadFileContent() {
		this.content = Q04FileUtil.readFile(file);
	}
	
	public Map<Integer, Q04HashCodeInformation> calculateAllHashCodes() {
		Map<Integer, Q04HashCodeInformation> result = new HashMap<Integer, Q04HashCodeInformation>();
		if (content.length() < Q04Constant.HASH_FUNCTION_BASE_LENGTH)
			return result;
		char[] c = content.toCharArray();
		int hashCode = 0;
		for (int i = 0; i < content.length() - Q04Constant.HASH_FUNCTION_BASE_LENGTH + 1; i++) {
			if (i == 0) {
				for (int j = 0; j < Q04Constant.HASH_FUNCTION_BASE_LENGTH; j++)
					hashCode += (hashCode * base + (int)(c[j])) % mod;
			}
			else {
				hashCode = ((hashCode - RM * (int)(c[i - 1])) % mod + (int)c[i + Q04Constant.HASH_FUNCTION_BASE_LENGTH - 1]) % mod;
			}
			Q04HashCodeInformation hci = new Q04HashCodeInformation(file, i);
			if (hashCode < 0)
				hashCode += mod;
			result.put(hashCode, hci);
		}
		return result;
	}
}
