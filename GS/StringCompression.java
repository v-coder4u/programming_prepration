package gs;

public class StringCompression {

	public int compress(char[] chars) {
		int start = 0;
		for (int end = 0, count = 0; end < chars.length; end++) {
			count++;
			if (end == chars.length - 1 || chars[end] != chars[end + 1]) {
				// We have found a difference or we are at the end of array
				chars[start] = chars[end]; // Update the character at start pointer
				start++;
				if (count != 1) {
					// Copy over the character count to the array
					char[] arr = String.valueOf(count).toCharArray();
					for (int i = 0; i < arr.length; i++, start++)
						chars[start] = arr[i];
				}
				// Reset the counter
				count = 0;
			}
		}
		return start;
	}

}

//public int compress(char[] chars) {
//    StringBuilder sb = new StringBuilder();
//    int left = 0; 
//    int right = 1;
//    while(right < chars.length) {
//        if(chars[left] == chars[right]) {
//            right++;
//        } else {
//            int count = right - left;
//            sb.append(chars[left]);
//            if(count > 1) {
//                sb.append(count);
//                left = right - 1;
//            }
//            left++;
//            right++;
//        }
//    }
//    if(chars[left] != chars[right-1]) {
//        sb.append(chars[right]);
//    } else {
//        sb.append(chars[left]);
//        int count = right - left;
//		if (count > 1) {
//			sb.append(count);
//		}
//    }
//    for(int i = 0; i < sb.toString().length(); i++) {
//        chars[i] = sb.toString().charAt(i);
//    }
//    return sb.toString().length();
//}