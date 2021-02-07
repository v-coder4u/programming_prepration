package gs;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

	public List<String> removeComments(String[] source) {
		List<String> result = new ArrayList();
		StringBuilder buffer = new StringBuilder();
		boolean blockComment = false;
		for (String line : source) {
			if (blockComment) {
				// don't touch buffer, it has some chars from previous line where block comment
				// started
			} else {
				// it's fresh new line, fresh start
				buffer.setLength(0);
			}

			for (int i = 0; i < line.length(); i++) {
				if (blockComment) {
					if (line.startsWith("*/", i)) {
						blockComment = false;
						i++;// skip that forward slash character
					} else {
						// we're still in comment, skipping chars
					}
				} else if (line.startsWith("/*", i)) {
					blockComment = true;
					i++;// skip that star character
				} else if (line.startsWith("//", i)) {
					break;// no need to move further in this line
				} else {
					// legit character
					buffer.append(line.charAt(i));
				}
			}

			if (buffer.length() > 0) {
				if (blockComment) {
					// do nothing, keep buffer for later
				} else {
					// this line is done
					result.add(buffer.toString());
				}
			}
		}

		return result;
	}
}
