
public class FamilyHirarchy {
	public static String getHirarchy(String str) throws Exception {
		if(str.isEmpty()) {
			return "No";
		} else if(str == null) {
			throw new Exception("null");
		} else if(str.contains("|")){
			return "|"+str.substring(str.indexOf(",", str.indexOf(",")+1)+1 , str.indexOf("|"))
			+ (str.charAt(0)!=str.charAt(str.indexOf("|")+1)?"|\n":"")		
			+ FamilyHirarchy.getHirarchy(str.substring(str.indexOf("|")+1));
		} else {
			return "|"+str.substring(str.lastIndexOf(",")+1)+"|";
			} 
		}
}
